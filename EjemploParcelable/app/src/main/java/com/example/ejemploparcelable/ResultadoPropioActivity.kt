package com.example.ejemploparcelable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        btn_intentRespuesta.setOnClickListener {
            devolverRespuesta()
        }

        btn_respuestaPropia.setOnClickListener {
            enviarIntentConRespuestaPropia()
        }
    }

    fun enviarIntentConRespuestaPropia(){
        val intentPropio=Intent(
            this,
            ResultadoPropioActivity::class.java
        )
        this.startActivityForResult(intentPropio,305)
    }


    fun devolverRespuesta(){
        val nombre="Caro"
        val edad=30
        val intentRespuesta=Intent()

        intentRespuesta.putExtra("nombreUsuario",nombre)
        intentRespuesta.putExtra("edadUsuario",edad)


        this.setResult(
            RESULT_OK,//podemos enviar RESULT OK o RESULT CANCELED
            intentRespuesta
        )
    }



}
