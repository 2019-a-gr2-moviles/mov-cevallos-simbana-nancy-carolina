package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista = arrayListOf<Persona>()
        // val recycler_view = rv_personas
        // val actividad = this

        lista.add(Persona("Adrian","171819134"))
        lista.add(Persona("Vicente","0192839495"))
        lista.add(Persona("Adrian","2003938182"))

        iniciarRecyclerView(lista,this, rv_personas)

    }


    fun iniciarRecyclerView ( lista: List<Persona>,
                              actividad: ReciclerViewActivity,
                              recycler_view: RecyclerView
    ){

        val adaptadorPersona = AdaptadorPersona(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPersona
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }


    fun cambiarNombreTextView (texto: String)
    {
        txt_Titulo_rv.text = texto
    }

}
