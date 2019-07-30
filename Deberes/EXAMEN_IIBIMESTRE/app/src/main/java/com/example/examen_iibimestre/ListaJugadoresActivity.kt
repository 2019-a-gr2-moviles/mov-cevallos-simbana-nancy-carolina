package com.example.examen_iibimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_jugadores.*

class ListaJugadoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_jugadores)
        val idJugador=this.intent.getIntExtra("idJugador", -1)
        val nombreJugador=this.intent.getStringExtra("nombreJugador")
        val jugadorEncontrado:ArrayList<Jugador> = arrayListOf()
        val respuesta=BDD.listaJugador.filter {
             it.nombreCompletoJugador==nombreJugador
        }
        Log.i("http","Respues filter: ${respuesta}")
        //iniciarRecyclerView(jugadorEncontrado,this,rv_jugadores)
    }

    fun iniciarRecyclerView(
        listaJugadores:ArrayList<Jugador>,
        actividad:ListaJugadoresActivity,
        recyclerView: androidx.recyclerview.widget.RecyclerView
    ){
        val adaparJugador=AdaptadorJugador(listaJugadores,actividad,recyclerView)
        rv_jugadores.adapter=adaparJugador
        rv_jugadores.itemAnimator= androidx.recyclerview.widget.DefaultItemAnimator()
        rv_jugadores.layoutManager= androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaparJugador.notifyDataSetChanged()
    }

    fun eliminarJugador(idJugador:Int){
        val url =BDD.url("jugador")+"?id=${idJugador}"
        url

            .httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        BDD.listaJugadorCompleta = arrayListOf()
                        runOnUiThread {
                            irAMapa()
                        }
                    }
                }
            }
    }

    private fun irAMapa() {
        val intent = Intent(
            this, MapsActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    }
    fun irListaEquipo(){
        val intent=Intent(
            this,ListaEquiposActivity::class.java
        )
        startActivity(intent)
    }

    fun actualizarJugador(
        jugador: Jugador
    ){
        val intentActualizar=Intent(
            this, ActualizarJugadorActivity::class.java
        )
        intentActualizar.putExtra("id",jugador.id)
        intentActualizar.putExtra("numeroCamiseta",jugador.numeroCamiseta)
        intentActualizar.putExtra("nombreCamiseta",jugador.nombreCamiseta)
        intentActualizar.putExtra("nombreJugador",jugador.nombreCompletoJugador)
        intentActualizar.putExtra("fechaIngreso",jugador.fechaIngresoEquipo)
        intentActualizar.putExtra("poder",jugador.poderEspecialDos)
        intentActualizar.putExtra("goles",jugador.goles)
        intentActualizar.putExtra("equipoId",jugador.equipoFutbolId)

        startActivity(intentActualizar)
    }

}
