package com.example.line

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class AdaptadorChats(
    private val listaAmigos:List<Amigos>,
    private val contexto: MainActivity,
    private val recyclerView: RecyclerView
):RecyclerView.Adapter<AdaptadorChats.MyViewHolder>() {

    inner class  MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var chatsImagenView:ImageView
        var nombreTextView:TextView
        var mensajeTextView:TextView
        var horaTextView:TextView
        var imagenNum:Int=0

        init {
            chatsImagenView = view.findViewById(R.id.img_chats) as ImageView
            nombreTextView = view.findViewById(R.id.txt_nombre) as TextView
            mensajeTextView = view.findViewById(R.id.txt_mensaje) as TextView
            horaTextView = view.findViewById(R.id.txt_hora) as TextView


            val layout = view.findViewById(R.id.chats_layout) as LinearLayout

            layout
                .setOnClickListener {
                    //val nombreActual=it.findViewById(R.id.txt_nombre) as TextView

                    val mensaje = Amigos(nombreTextView.text.toString(),
                        mensajeTextView.text.toString(),
                        horaTextView.text.toString(),
                        imagenNum
                        )
                    iraChatIndividual(mensaje)
                    Log.i("recycler-view", "Layout presionado")
                }

        }
        fun iraChatIndividual(mensaje:Amigos){
            contexto.irAChatActivity(mensaje)
        }

    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int):
            AdaptadorChats.MyViewHolder {

            val itemView=LayoutInflater
                .from(p0.context)
                .inflate(
                    R.layout.layout,
                    p0,
                    false
                )
            return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return listaAmigos.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorChats.MyViewHolder,
                                  position: Int
    ) {

        val chat = listaAmigos[position]

        myViewHolder.chatsImagenView.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp)
        myViewHolder.nombreTextView.text = chat.nombre
        myViewHolder.mensajeTextView.text = chat.ultimo_mensaje
        myViewHolder.horaTextView.text = chat.hora_conexion


    }


}