package com.example.examen_iibimestre

class Jugador (
    var id:Int,
    var numeroCamiseta:Int,
    var nombreCamiseta:String,
    var nombreCompletoJugador:String,
    var poderEspecialDos:String,
    var fechaIngresoEquipo:String,
    var goles:Int,
    var longitud:String,
    var latitud:String,
    var equipoFutbolId:Int
){

    override fun toString(): String {
        return this.nombreCompletoJugador
    }

}