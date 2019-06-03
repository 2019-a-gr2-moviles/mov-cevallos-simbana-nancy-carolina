package com.example.examenaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import android.widget.Toast;

class MenuActivity : AppCompatActivity() {

    var usuario:String="";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
       usuario=intent.getStringExtra("usuario").toString()
        btn_gestionPapas.setOnClickListener { gestionarPapa() }
        btn_crearPapa.setOnClickListener { crearPapa() }

    }

    fun gestionarPapa(){
        val intentGestion=Intent(this, ListaPapaActivity::class.java)
        startActivity((intentGestion))
    }

    fun crearPapa(){
        val intentCrear=Intent(this, CrearPapaActivity::class.java)
        startActivity(intentCrear)
    }
}
