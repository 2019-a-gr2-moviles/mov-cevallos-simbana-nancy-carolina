package com.example.examenaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear_papa.*

class CrearPapaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_papa)

        btn_guardar.setOnClickListener { guardarDatosEquipo()
        }
    }

    fun guardarDatosEquipo(){
        var campeon=false
        val nombre=text_nombreEquipo.text.toString()
        val liga=text_liga.text.toString()
        val fechaCreacion=text_fechaEquipo.text.toString()
        val numeroCopasInternacional=text_numeroCopas.text.toString().toInt()
        if(check_campeon.isChecked){campeon=true}
        val campeonActual=campeon
        val idEquipo:Int= bdDatos.idEquipo+1

        bdDatos.listaEquipo.add(EquipoFutbol(idEquipo,nombre,liga,fechaCreacion,numeroCopasInternacional,campeonActual))
        Toast.makeText(this,bdDatos.usuario+ getString(R.string.msg_guardado),Toast.LENGTH_SHORT).show()
        val iraMenu= Intent(this,MenuActivity::class.java)
        iraMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(iraMenu)
    }
}
