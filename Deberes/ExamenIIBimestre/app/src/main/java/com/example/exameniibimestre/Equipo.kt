package com.example.exameniibimestre

class Equipo(
    public var nombre:String,
    var liga:String,
    var fechaCreacion:String,
    var numeroCopasInternacionales:Int,
    var campeonActual:Boolean,
    var id:Int

) {
    override fun toString(): String {

        return this.nombre
    }
}