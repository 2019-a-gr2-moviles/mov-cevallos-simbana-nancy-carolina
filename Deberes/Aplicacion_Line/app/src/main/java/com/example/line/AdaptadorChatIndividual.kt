package com.example.line

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class AdaptadorChatIndividual(private val listaChats:List<Chat>,
                              private val contexto: ChatIndividualActivity,
                              private val recyclerView: RecyclerView
): RecyclerView.Adapter<AdaptadorChatIndividual.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mensajeEnvioTextView: TextView
        var mensajeRecibidoTextView: TextView
        var horaEntregaTextView: TextView
        var horaRecibidaTextView: TextView
        var vistoTextView: TextView

        init {
            mensajeEnvioTextView = view.findViewById(R.id.txt_enviado) as TextView
            mensajeRecibidoTextView = view.findViewById(R.id.txt_recibido) as TextView
            horaEntregaTextView = view.findViewById(R.id.txt_hora_entregado) as TextView
            horaRecibidaTextView = view.findViewById(R.id.txt_hora_recibido) as TextView
            vistoTextView = view.findViewById(R.id.txt_visto) as TextView


            val layout2 = view.findViewById(R.id.layout_mensajes) as LinearLayout

            /*layout
                .setOnClickListener {
                    //val nombreActual=it.findViewById(R.id.txt_nombre) as TextView

                    val conversacion = Chat(mensajeEnvioTextView.text.toString(),
                        mensajeRecibidoTextView.text.toString(),
                        horaEntregaTextView.text.toString(),
                        horaRecibidaTextView.text.toString(),
                        vistoTextView.text.toString()
                    )

                    Log.i("recycler-view", "Layout presionado")
                }*/

        }


    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ):
            AdaptadorChatIndividual.MyViewHolder {

        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout2,
                p0,
                false
            )
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return listaChats.size
    }

    override fun onBindViewHolder(
        myViewHolder: AdaptadorChatIndividual.MyViewHolder,
        position: Int
    ) {

        val conversacion = listaChats[position]

        myViewHolder.mensajeEnvioTextView.text = conversacion.mensaje_enviado
        myViewHolder.mensajeRecibidoTextView.text = conversacion.mensaje_recibido
        myViewHolder.horaEntregaTextView.text = conversacion.hora_entregado
        myViewHolder.horaRecibidaTextView.text = conversacion.hora_recibido
        myViewHolder.vistoTextView.text = conversacion.visto


    }
}
