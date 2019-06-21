package com.example.line

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        var lista = arrayListOf<Amigos>()

        lista.add(Amigos("Nancy","Estamos hablando","13:00",1))
        lista.add(Amigos("Sergio","Chaooo","15:10",2))
        lista.add(Amigos("Mamá","Cuidate","12:45",3))
        lista.add(Amigos("Carolina","Hola como estas","2:00",4))


        navView.setOnNavigationItemReselectedListener { item->
            when(item.itemId){
                R.id.navigation_chats->{
                    rv_lista_inicial.setBackgroundColor(0)
                    iniciarRecyclerView(lista,this, rv_lista_inicial)
                }


            }
            true
        }


    }

    fun iniciarRecyclerView(
        lista:List<Amigos>,
        actividad: MainActivity,
        recycler_view: RecyclerView

    ){
        val adaptadorChats=AdaptadorChats(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter=adaptadorChats
        recycler_view.itemAnimator= DefaultItemAnimator()
        recycler_view.layoutManager= LinearLayoutManager(actividad)

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

    fun irARecylerView(){
        val intentRecycler=Intent(
            this,
            ReciclerViewActivity::class.java
        )
        startActivity(intentRecycler)
    }
}
