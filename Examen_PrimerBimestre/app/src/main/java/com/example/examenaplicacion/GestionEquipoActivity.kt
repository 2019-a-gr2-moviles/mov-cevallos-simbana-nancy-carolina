package com.example.examenaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gestion_equipo.*

class GestionEquipoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_equipo)

        val equipoGestion=intent.getParcelableExtra<EquipoFutbol>("EquipoGestion")
        text_nombreJugador.setText(equipoGestion.nombre.toString())
        text_liga.setText(equipoGestion.liga.toString())
        text_fechaEquipo.setText(equipoGestion.fechaCreacion.toString())
        text_numeroCopas.setText(equipoGestion.numberCopasInternacionales.toString())
        if(equipoGestion.campeonActual)check_Campeon.isChecked


        var idEquipo=equipoGestion.idEquipo
        btn_actualizar.setOnClickListener { actualizarEquipo(idEquipo) }
        btn_eliminar.setOnClickListener { elimininarEqiupo(idEquipo) }
        btn_gestionJugadores.setOnClickListener { iragestionJugador(idEquipo) }
        btn_crearJugador.setOnClickListener { iracrearJugador(idEquipo) }


    }

    fun actualizarEquipo(id:Int){
        var campeon=false
        if(check_Campeon.isChecked) campeon=true
        val equipoEditado=EquipoFutbol(
            id,
            text_nombreJugador.text.toString(),
            text_liga.text.toString(),
            text_fechaEquipo.text.toString(),
            text_numeroCopas.text.toString().toInt(),
            campeon
        )
        bdDatos.editarEquipo(equipoEditado)
        Toast.makeText(this,bdDatos.usuario+ getString(R.string.msg_actualizado),Toast.LENGTH_LONG).show()
        val iraLista= Intent(this,ListaPapaActivity::class.java)
        startActivity(iraLista)
    }

    fun elimininarEqiupo(id:Int){
        bdDatos.eliminarporIdEquipo(id)
        Toast.makeText(this,bdDatos.usuario+getString(R.string.msg_eliminado),Toast.LENGTH_LONG).show()
        val iraLista=Intent(this,MenuActivity::class.java)
        iraLista.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(iraLista)
    }

    fun iragestionJugador(id:Int){
        var gestionJugador=Intent(this, ListaJugadoresActivity::class.java)
        gestionJugador.putExtra("idEquipoFutbol",id)


       // gestionJugador.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(gestionJugador)
    }

    fun iracrearJugador(id:Int){
        val crearJugador=Intent(this,CrearJugadorActivity::class.java)
        crearJugador.putExtra("idEquipoFutbol",id)
        startActivity(crearJugador)
    }
}
