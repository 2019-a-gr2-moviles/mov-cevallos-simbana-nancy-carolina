package com.example.examen_iibimestre

import android.view.View
import android.widget.TextView
import com.example.examen_iibimestre.R
import com.example.examen_iibimestre.Jugador
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import com.example.examen_iibimestre.ListaJugadoresActivity

class AdaptadorJugador(
    private val listaJugadores:ArrayList<Jugador>,
    private val contexto:ListaJugadoresActivity,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView

):
    androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorJugador.MyViewHolder>(){


        inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
            var idJugadorTrextView:TextView
            var nombreJugadorTextView:TextView
            var numeroCamisetaTextView:TextView
            var nombreCamisetaTextView:TextView
            var poderTextView:TextView
            var fechaIngresoTextView:TextView
            var golesTextView:TextView
            var equipoTextView:TextView
            var eliminarBoton:Button
            var actualizarBoton:Button

            init {
                idJugadorTrextView=view.findViewById(R.id.text_view_idJugador) as TextView
                nombreJugadorTextView=view.findViewById(R.id.text_view_nombreJugador) as TextView
                numeroCamisetaTextView=view.findViewById(R.id.text_view_numeroCamiseta) as TextView
                nombreCamisetaTextView=view.findViewById(R.id.text_view_nombreCamiseta) as TextView
                poderTextView=view.findViewById(R.id.text_view_poder) as TextView
                fechaIngresoTextView=view.findViewById(R.id.text_view_fechaIngreso) as TextView
                equipoTextView=view.findViewById(R.id.text_view_equipoId) as TextView
                golesTextView=view.findViewById(R.id.text_view_goles) as TextView
                eliminarBoton=view.findViewById(R.id.btn_eliminar_jugador) as Button
                actualizarBoton=view.findViewById(R.id.btn_actualizar_jugador) as Button

                actualizarBoton.setOnClickListener {
                    val jugador=Jugador(
                        idJugadorTrextView.text.toString().toInt(),
                        numeroCamisetaTextView.text.toString().toInt(),
                        nombreCamisetaTextView.text.toString(),
                        nombreJugadorTextView.text.toString(),
                        poderTextView.text.toString(),
                        fechaIngresoTextView.text.toString(),
                        golesTextView.text.toString().toInt(),
                        "0","0",
                        equipoTextView.text.toString().toInt()
                    )
                    contexto.actualizarJugador(jugador)
                }

                eliminarBoton.setOnClickListener {
                    contexto.eliminarJugador(idJugadorTrextView.text.toString().toInt())
                }


            }
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorJugador.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_jugadores,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaJugadores.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorJugador.MyViewHolder, position: Int) {
        val jugador: Jugador = listaJugadores[position]
        myViewHolder.idJugadorTrextView.text = jugador.id.toString()
        myViewHolder.numeroCamisetaTextView.text = jugador.numeroCamiseta.toString()
        myViewHolder.nombreCamisetaTextView.text = jugador.nombreCamiseta
        myViewHolder.nombreJugadorTextView.text = jugador.nombreCompletoJugador
        myViewHolder.fechaIngresoTextView.text = jugador.fechaIngresoEquipo.toString()
        myViewHolder.poderTextView.text = jugador.poderEspecialDos
        myViewHolder.golesTextView.text = jugador.goles.toString()
        myViewHolder.equipoTextView.text=jugador.equipoFutbolId.toString()
    }


    }
