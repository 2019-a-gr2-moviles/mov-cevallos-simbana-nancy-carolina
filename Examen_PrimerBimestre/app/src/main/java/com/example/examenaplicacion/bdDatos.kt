


package com.example.examenaplicacion
import java.util.*
import kotlin.collections.ArrayList

class bdDatos {
    companion object {
        var usuario = ""
        val listaEquipo= arrayListOf<EquipoFutbol>()
        val listaJugador= arrayListOf<Jugador>()
        val idEquipo:Int=0;
        val idJugador:Int=0;


        fun editarEquipo(equipo:EquipoFutbol){
            val indice= listaEquipo.indexOfFirst { it.idEquipo.toInt()==equipo.idEquipo.toInt()}
            listaEquipo[indice].nombre=equipo.nombre
            listaEquipo[indice].liga=equipo.liga
            listaEquipo[indice].fechaCreacion=equipo.fechaCreacion
            listaEquipo[indice].numberCopasInternacionales=equipo.numberCopasInternacionales
            listaEquipo[indice].campeonActual=equipo.campeonActual
        }

        fun eliminarporIdEquipo(id:Int){
            listaEquipo.removeAll{it.idEquipo==id}
        }

        fun editarJugador(jugador:Jugador, idPadre:Int){
            val indice= listaJugador.indexOfFirst { it.idJugadpr.toString().toInt()==jugador.idJugadpr.toString().toInt() && it.eqipoFutbolId.toInt()==idPadre.toInt()}
            listaJugador[indice].numeroCamiseta=jugador.numeroCamiseta
            listaJugador[indice].nombreCamisate=jugador.nombreCamisate
            listaJugador[indice].nombreCompletoJugador=jugador.nombreCompletoJugador
            listaJugador[indice].fechaIngresoEquipo=jugador.fechaIngresoEquipo
            listaJugador[indice].goles=jugador.goles
        }

        fun eliminarporIdJugadoro(id:Int, idPadre:Int){
            listaJugador.removeAll{it.idJugadpr==id && it.eqipoFutbolId==idPadre }
        }

    }




    }



