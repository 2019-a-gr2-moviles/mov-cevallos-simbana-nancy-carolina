package com.example.examen_iibimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_jugador.*
import java.lang.Exception

class CrearJugadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_jugador)
        val idEquipo:Int=intent.getIntExtra("idEquipo",-1)
        btn_guardar.setOnClickListener {
            try{
                val jugador=Jugador(
                    -1,
                    text_numCamiseta.text.toString().toInt(),
                    text_nombreCamiseta.text.toString(),
                    text_nombreJugador.text.toString(),
                    text_poder.text.toString(),
                    text_fechaIngreso.text.toString(),
                    text_goles.text.toString().toInt(),
                    text_longitud.text.toString(),
                    text_latitud.text.toString(),
                    idEquipo
                )
                guardarJugador(jugador)
            }catch (e:Exception){
                Toast.makeText(
                    this,"${BDD.nomreUsuario}: No se realizó la petición",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun guardarJugador(nuevoJugador:Jugador){
        try{
            val url=BDD.url("jugador")
            val jsonDatos="""
                {
                    "numeroCamiseta":"${nuevoJugador.numeroCamiseta}",
                    "nombreCamiseta":"${nuevoJugador.nombreCamiseta}",
                    "nombreCompletoJugador":"${nuevoJugador.nombreCompletoJugador}",
                    "poderEspecialDos":"${nuevoJugador.poderEspecialDos}",
                    "fechaIngresoEquipo":"${nuevoJugador.fechaIngresoEquipo}",
                    "goles":"${nuevoJugador.goles}",
                    "equipoFutbolId":"${nuevoJugador.equipoFutbolId}",

                }
            """.trimIndent()
            Log.i("http",jsonDatos)
            url
                .httpPost().body(jsonDatos)
                .responseString { request, response, result ->
                    when(result){
                        is Result.Failure->{
                            val ex=result.getException()
                            Log.i("http", "Error: ${ex.message}")
                        }
                        is Result.Success->{
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
                }
        }catch (e:Exception){
            Toast.makeText(
                this,"${BDD.nomreUsuario}: No se realizó la petición",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun irAListaEquipo() {
        val intent = Intent(
            this,
            ListaEquiposActivity()::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}

