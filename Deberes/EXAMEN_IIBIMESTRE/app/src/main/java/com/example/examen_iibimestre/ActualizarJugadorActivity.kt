package com.example.examen_iibimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.kittinunf.fuel.httpPut
import kotlinx.android.synthetic.main.activity_actualizar_jugador.*
import java.lang.Exception
import javax.xml.transform.Result

class ActualizarJugadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_jugador)
        val id: Int = this.intent.getIntExtra("id", -1)
        val numeroCamisera: Int = this.intent.getIntExtra("numeroCamiseta", -1)
        val nombreCamiseta = this.intent.getStringExtra("nombreCamiseta")
        val nombreJugador = this.intent.getStringExtra("nombreJugador");
        val fechaIngreso = this.intent.getStringExtra("fechaIngreso");
        val poder = this.intent.getStringExtra("poder")
        val goles = this.intent.getIntExtra("goles", -1)
        val equipoId = this.intent.getIntExtra("equipoId", -1)

        text_numCamiseta.hint = numeroCamisera.toString()
        text_nombreCamiseta.hint = nombreCamiseta
        text_nombreJugador.hint == nombreJugador
        text_fechaIngreso.hint = fechaIngreso
        text_poder.hint = poder
        text_goles.hint = goles.toString()

        btn_actualizar.setOnClickListener {
            try {
                val jugador = Jugador(
                    id, text_nombreJugador.toString().toInt(), text_nombreCamiseta.toString(),
                    text_nombreJugador.toString(),  text_poder.toString(), text_fechaIngreso.toString(),
                    text_goles.toString().toInt(),
                    text_longitud.toString(), text_latitud.toString(), -1
                )
                actualizarJugador(jugador)
            } catch (e: Exception) {
                Toast.makeText(
                    this, "${BDD.nomreUsuario}:No se pudo realizar la acción",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun actualizarJugador(jugador:Jugador){
        try{
            val url =BDD.url("jugador")+"/${jugador.id}"
            val jsonJugador="""
                {
                "numeroCamiseta":"${jugador.numeroCamiseta}",
                "nombreCamiseta":"${jugador.nombreCamiseta}",
                "nombreCompletoJugador":"${jugador.nombreCompletoJugador}",
                "poderEspecialDos":"${jugador.poderEspecialDos}",
                "fechaIngresoEquipo":"${jugador.fechaIngresoEquipo}",
                "goles":"${jugador.goles}",
                "longitud":"${jugador.longitud}",
                "latitu":"${jugador.latitud}",
                }
            """.trimIndent()
            url
                .httpPut().body(jsonJugador)
                .responseString { request, response, result ->
                    when (result) {
                        is com.github.kittinunf.result.Result.Failure -> {
                            val ex = result.getException()
                            Log.i("thhp", "Error:${ex.message}")
                            Toast.makeText(
                                this, "${BDD.nomreUsuario}: No se pudo realizar esta accion",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        is com.github.kittinunf.result.Result.Success -> {

                            runOnUiThread {
                                Toast.makeText(
                                    this,
                                    "${BDD.nomreUsuario}: Operación exitosa",
                                    Toast.LENGTH_LONG
                                ).show()
                                irAListaEquipo()
                            }

                        }
                    }

                }}catch (e:Exception){
                Toast.makeText(
                    this,"${BDD.nomreUsuario}: No se pudo realizar esta accion",
                    Toast.LENGTH_LONG
                ).show()
        }
    }

    fun irAListaEquipo(){

        intent= Intent(this,
            ListaJugadoresActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}