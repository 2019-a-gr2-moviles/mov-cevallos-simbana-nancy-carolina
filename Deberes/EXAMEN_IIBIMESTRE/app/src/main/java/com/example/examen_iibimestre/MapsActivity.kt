package com.example.examen_iibimestre

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.util.Log
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var tienePermisosLocalizacion = false
    private var idEquipo = -1

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
        BDD.listaJugadorCompleta.forEach { jugador ->
            Log.i("http", "${jugador.nombreCompletoJugador}")
            var latitud = jugador.latitud.toDouble()
            var longitud = jugador.longitud.toDouble()
            anadirMarcador(LatLng(latitud, longitud), jugador.nombreCompletoJugador)
        }

        mMap.setOnMarkerClickListener { marker ->
            abriDatosJugador(marker.title)
            Toast.makeText(
                this,
                "${marker.title}\n${marker.position}",
                Toast.LENGTH_LONG
            ).show()
            true

        }
    }

    fun solicitarPermisosLocalizacion() {
        val permisoFineLocation = ContextCompat
            .checkSelfPermission(
                this.applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )

        val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED

        if (tienePermiso) {
            Log.i("mapa", "Tiene permisos de FINE_LOCATION")
            this.tienePermisosLocalizacion = true
        } else {
            // Codigo que vamos a esperar (1)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }

    }
    fun establecerConfiguracionMapa(mapa: GoogleMap) {
        val contexto = this.applicationContext
        with(mapa) {
            val permisoFineLocation = ContextCompat
                .checkSelfPermission(
                    contexto,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )

            val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED
            if (tienePermiso) {
                mapa.isMyLocationEnabled = true
            }

            this.uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }

    }

    fun anadirMarcador(latLng: LatLng, title: String) {
        mMap.addMarker(MarkerOptions().position(latLng).title(title))
    }

    fun abriDatosJugador(nombreJugador: String) {
        val intent = Intent(
            this,
            ListaJugadoresActivity::class.java
        )
        intent.putExtra("idJugador", nombreJugador);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
