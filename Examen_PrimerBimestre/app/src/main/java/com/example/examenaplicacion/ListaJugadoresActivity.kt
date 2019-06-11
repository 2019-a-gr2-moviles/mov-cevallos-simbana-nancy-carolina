package com.example.examenaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_jugadores.*

class ListaJugadoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_jugadores)
        val idPadre:Int=intent.getIntExtra("idEquipoFutbol",1)
        val adapter=ArrayAdapter<Jugador>(
            this, android.R.layout.simple_list_item_1,
            bdDatos.listaJugador.filter { it.eqipoFutbolId == idPadre}
        )
        lv_judadores.adapter=adapter;
        lv_judadores.onItemClickListener=AdapterView.OnItemClickListener{parent, view, position, id ->
            val filaSeleccionada=parent.getItemAtPosition(position) as Jugador
            val irGestionJugador=Intent(this, GestionJugadoresActivity::class.java)
            irGestionJugador.putExtra("JugadorSeleccionado",filaSeleccionada)
            irGestionJugador.putExtra("idPadre",idPadre)
            irGestionJugador.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(irGestionJugador)
        }
    }
}
