package com.example.examenaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear_jugador.*

class CrearJugadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_jugador)
        val idPadre:Int=intent.getIntExtra("idEquipoFutbol",1)
        btn_guardar.setOnClickListener { guardarJugador(idPadre) }
    }

    fun guardarJugador(idPadre:Int){
        val id:Int=bdDatos.idJugador+1
        bdDatos.listaJugador.add(
            Jugador(
            id,
            text_numCamiseta.text.toString().toInt(),
            text_nombreCamiseta.text.toString(),
            text_nombreJugador.text.toString(),
            text_poder.text.toString(),
            text_fechaIngreso.text.toString(),
            text_goles.text.toString().toInt(),
            idPadre
            )
        )
        Toast.makeText(this,bdDatos.usuario+ getString(R.string.msg_guardado), Toast.LENGTH_SHORT).show()
        val iragestionEquipo=Intent(this,MenuActivity::class.java)
        //iragestionEquipo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(iragestionEquipo)


    }
}
