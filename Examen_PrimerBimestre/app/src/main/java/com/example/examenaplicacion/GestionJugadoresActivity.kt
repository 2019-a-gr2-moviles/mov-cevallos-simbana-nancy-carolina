package com.example.examenaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gestion_jugadores.*
import kotlinx.android.synthetic.main.activity_gestion_jugadores.text_fechaIngreso
import kotlinx.android.synthetic.main.activity_gestion_jugadores.text_nombreCamiseta
import kotlinx.android.synthetic.main.activity_gestion_jugadores.text_nombreJugador
import kotlinx.android.synthetic.main.activity_gestion_jugadores.text_numCamiseta
import kotlinx.android.synthetic.main.activity_gestion_jugadores.text_poder

class GestionJugadoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_jugadores)

        val jugadorSeleccionado=intent.getParcelableExtra<Jugador>("JugadorSeleccionado")
        text_nombreJugador.setText(jugadorSeleccionado.nombreCompletoJugador.toString())
        text_numCamiseta.setText(jugadorSeleccionado.numeroCamiseta.toInt())
        text_nombreCamiseta.setText(jugadorSeleccionado.nombreCamisate.toString())
        text_fechaIngreso.setText(jugadorSeleccionado.fechaIngresoEquipo.toString())
        text_poder.setText(jugadorSeleccionado.poderEspecialDos.toString())
        text_nombreJugador.setText(jugadorSeleccionado.goles.toString())
        val id=jugadorSeleccionado.idJugadpr.toString().toInt()
        val idPadre=intent.getIntExtra("idPadre",1)
        btn_eliminar.setOnClickListener { eliminarJugador(id, idPadre) }

        btn_actualizar.setOnClickListener { actualizarJugador(id,idPadre) }
    }

    fun eliminarJugador(id:Int, idPadre:Int){
        bdDatos.eliminarporIdJugadoro(id,idPadre)
        Toast.makeText(this, bdDatos.usuario+" "+ getString(R.string.msg_eliminado),Toast.LENGTH_LONG).show()
        val iraLista= Intent(this,ListaJugadoresActivity::class.java)
        iraLista.putExtra("idEquipoFutbol",idPadre)
        startActivity(iraLista)
    }

    fun actualizarJugador(id:Int,idPadre: Int){
            val jugadorEditado=Jugador(
                id,
                text_numCamiseta.text.toString().toInt(),
                text_nombreCamiseta.text.toString(),
                text_nombreJugador.text.toString(),
                text_poder.text.toString(),
                text_fechaIngreso.text.toString(),
                text_goles.text.toString().toInt(),
                idPadre
            )
        bdDatos.editarJugador(jugadorEditado,idPadre)
        Toast.makeText(this, bdDatos.usuario+" "+ getString(R.string.msg_actualizado),Toast.LENGTH_LONG).show()
        val iraLista= Intent(this,ListaJugadoresActivity::class.java)
        iraLista.putExtra("idEquipoFutbol",idPadre)
        startActivity(iraLista)
    }
}
