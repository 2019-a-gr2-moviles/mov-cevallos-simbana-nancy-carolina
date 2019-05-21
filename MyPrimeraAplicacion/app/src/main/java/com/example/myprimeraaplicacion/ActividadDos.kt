package com.example.myprimeraaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad_dos.*

class ActividadDos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)

        val nombre:String?=intent.getStringExtra("nombre")
        val edad:Int?=intent.getIntExtra("edad",0)
        println(nombre)
        println(edad)

        Log.i("intents","Nombre:$nombre")
        Log.i("intents","Edad:$edad")

        btn_actividad_uno.setOnClickListener {
            irAActividadUno()
        }
    }

    fun irAActividadUno(){
        val intent=Intent(
            this,
            MainActivity::class.java
        )

        startActivity(intent)

    }

}
