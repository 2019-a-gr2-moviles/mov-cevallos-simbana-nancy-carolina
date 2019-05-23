package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.ejemploparcelable.R
import com.example.ejemploparcelable.Usuario
import com.example.ejemploparcelable.Mascota
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener {
            irAParcelable()
        }

    }

    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val caro = Usuario("Caro",
            29,
            Date(),
            12.12)
        intentExplicito.putExtra("usuario",caro)


        val cachetes =Mascota("Cachetes",caro)
        intentExplicito.putExtra("mascota",cachetes)

        startActivity(intentExplicito)
    }
}
