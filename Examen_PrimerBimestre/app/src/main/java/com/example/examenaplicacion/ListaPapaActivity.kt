package com.example.examenaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_papa.*

class ListaPapaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_papa)

        val adapter =ArrayAdapter<EquipoFutbol>(
            this,
            android.R.layout.simple_list_item_1,
            bdDatos.listaEquipo
        )

        lv_papas.adapter=adapter;
        lv_papas.onItemClickListener=AdapterView.OnItemClickListener{
            parent, view, position, id ->

            val filaSeleccionada=parent.getItemAtPosition(position) as EquipoFutbol
            val iraGestion=Intent(this, GestionEquipoActivity::class.java)
            iraGestion.putExtra("EquipoGestion",filaSeleccionada)
            iraGestion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(iraGestion)
        }
    }
}
