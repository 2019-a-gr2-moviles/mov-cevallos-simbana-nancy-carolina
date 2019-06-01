package com.example.ejemploparcelable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.MainActivity

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)


        val caro: Usuario? = this.intent
            .getParcelableExtra<Usuario>("usuario")

        val cachetes:Mascota?=this.intent.
            getParcelableExtra<Mascota>("mascota")

        Log.i("parcelable","Nombre ${caro?.nombre}")
        Log.i("parcelable","Nombre ${caro?.edad}")
        Log.i("parcelable","Nombre ${caro?.fechaNacimiento.toString()}")
        Log.i("parcelable","Nombre ${caro?.sueldo}")

        Log.i("parcelable","Nombre ${cachetes?.nombre}")
        Log.i("parcelable","Nombre ${cachetes?.dueño?.nombre}")
    }
    fun regresarAMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)
    }
}
