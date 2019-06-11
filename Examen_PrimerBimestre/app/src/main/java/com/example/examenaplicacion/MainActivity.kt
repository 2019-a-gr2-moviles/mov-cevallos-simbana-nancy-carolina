package com.example.examenaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_ingresar.setOnClickListener { iniciarSesion() }
    }

    fun iniciarSesion(){

        bdDatos.usuario=text_usuario.text.toString()
        val intentInicio=Intent(this, MenuActivity::class.java)
        intentInicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentInicio)
    }
}
