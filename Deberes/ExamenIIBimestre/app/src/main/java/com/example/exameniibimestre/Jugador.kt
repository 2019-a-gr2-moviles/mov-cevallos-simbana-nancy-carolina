package com.example.exameniibimestre

class Jugador (
    var id:Int,
    var numeroCamiseta:Int,
    var nombreCamiseta:String,
    var nombreCompletoJugador:String,
    var poderEspecialDos:String,
    var fechaIngresoEquipo:String,
    var goles:Int,
    var equipoFutbolId:Equipo,
    var longitud:String,
    var latitud:String
){

    override fun toString(): String {
        return this.nombreCompletoJugador
    }

}