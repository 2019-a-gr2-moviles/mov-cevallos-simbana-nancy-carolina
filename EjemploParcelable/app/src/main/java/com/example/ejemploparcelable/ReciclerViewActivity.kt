package com.example.ejemploparcelable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.myapplication.AdaptadorPersona
import kotlinx.android.synthetic.main.activity_recicle_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicle_view)

        val lista= arrayListOf<Persona>()
        val recycler_view=rv_personas
        val actividad=this


        lista.add(Persona("Carolina","1718010653"))
        lista.add(Persona("Nancy","2345678909"))
        lista.add(Persona("Cevallos","3456789873"))

        val adaptadorPersona=AdaptadorPersona(
             lista,
             actividad,
             recycler_view

         )
        rv_personas.adapter=adaptadorPersona
        rv_personas.itemAnimator=DefaultItemAnimator()
        rv_personas.layoutManager=LinearLayoutManager(this)

        adaptadorPersona.notifyDataSetChanged()

        fun cambiarNombreTextView(texto: String){
            txt_titulo_rv.text=texto
        }

        /*fun iniciarRecyclerView(
            lista: this,
            actividad:ReciclerViewActivity,
            recycler_view:RecyclerView){

        }*/

    }
}
