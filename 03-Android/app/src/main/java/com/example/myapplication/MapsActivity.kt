package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var tienePermisosLocalizacion=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        solicitarPermisosLocalizacion()
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        establecerConfiguracionMapa(mMap)
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-0.210375, -78.488687)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,17f))
    }

    fun establecerConfiguracionMapa(mapa:GoogleMap){
        //para configurar un mapa es necesario primeramente fijar , habilitar y deshabilitar configuraciones
        with(mapa){//forma de ver si existe o no el mapa
            //this.->podemos agregar condiguraciones al mapara
            mapa.isMyLocationEnabled=true
            this.uiSettings.isZoomControlsEnabled=true//para que el boton de zoom este habilitado
            uiSettings.isMyLocationButtonEnabled=true// no es necesario poner this
        }
    }

    fun solicitarPermisosLocalizacion(){
        //---es una buena practica siempre verificar los permisos de leer y escribir archivos
        val permisoFineLocation =ContextCompat
            .checkSelfPermission(
                this.applicationContext,
                //android.Manifest.permission.->se puede ver todos los permisos disponible
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        val tienePermiso=permisoFineLocation== PackageManager.PERMISSION_GRANTED

        if(tienePermiso){
            Log.i("mapa","Tiene permisos de FINE_LOCATION")
            this.tienePermisosLocalizacion = true
        }else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1
            )
        }

    }
}
