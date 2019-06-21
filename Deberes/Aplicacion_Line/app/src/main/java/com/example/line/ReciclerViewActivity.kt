package com.example.line

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        var lista = arrayListOf<Amigos>()

        lista.add(Amigos("Nancy","Estamos hablando","13:00",1))
        lista.add(Amigos("Sergio","Chaooo","15:10",2))
        lista.add(Amigos("Mamá","Cuidate","12:45",3))
        lista.add(Amigos("Carolina","Hola como estas","2:00",4))

        iniciarRecyclerView(lista,this, rv_chats)

    }

    fun iniciarRecyclerView(
        lista:List<Amigos>,
        actividad:ReciclerViewActivity,
        recycler_view:RecyclerView

    ){
        val adaptadorChats=AdaptadorChats(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter=adaptadorChats
        recycler_view.itemAnimator=DefaultItemAnimator()
        recycler_view.layoutManager=LinearLayoutManager(actividad)

        adaptadorChats.notifyDataSetChanged()
    }

    fun irAChatActivity(mensaje: Amigos){
        val intentExplicito = Intent(
            this,
            ChatIndividualActivity::class.java
        )
        intentExplicito.putExtra("mensaje",mensaje)
        startActivity(intentExplicito)


    }
}
