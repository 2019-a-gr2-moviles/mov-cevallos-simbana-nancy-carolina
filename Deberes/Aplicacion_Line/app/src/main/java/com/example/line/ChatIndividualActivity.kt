package com.example.line

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_chat_individual.*

class ChatIndividualActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_individual)

        val mensaje: Amigos = this.intent.getParcelableExtra<Amigos>("mensaje")
        //Log.i("mensaje", "Mensaje ${mensaje?.nombre}")



        var listaconversacio = arrayListOf<Chat>()



        listaconversacio.add(Chat("Hola ","Hola","8:45","8:50","Visto"))
        listaconversacio.add(Chat("Como estas","Bien gracias","9:00","9:19","visto"))
        listaconversacio.add(Chat("¿sigues estudiando","Si, y tu a que te dedicas","9:20","9:20","visto"))
        listaconversacio.add(Chat("ya me gradué","Oh que lindo","8:23","9:00","visto"))
        listaconversacio.add(Chat("Si te invito a mi grado","Sin duda estaré ahi","9:23","9:25","visto"))
        listaconversacio.add(Chat("Te espero entonces","cuenta con ello , cuando es?","9;53","10:00","visto"))
        listaconversacio.add(Chat("Es este Sabado a la 10:00","En donde?","10:23","10:30","visto"))
        listaconversacio.add(Chat("En la casa de mis tios, te espero","Claro que si cuenta conmigo","11:03","10:10","visto"))
        listaconversacio.add(Chat("Nos vemos hasta entonces","ok, cuidate ", "11:29","12:00","visto"))


        iniciarRecycler(listaconversacio,this,rv_chat_individual)
    }

    fun iniciarRecycler(
        lista: List<Chat>,
        actividad: ChatIndividualActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorchat = AdaptadorChatIndividual(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorchat
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorchat.notifyDataSetChanged()
    }
}
