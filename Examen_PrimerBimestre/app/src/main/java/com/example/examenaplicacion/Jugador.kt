package com.example.examenaplicacion

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Jugador (
    var idJugadpr:Int?,
    var numeroCamiseta:Int,
    var nombreCamisate:String,
    var nombreCompletoJugador:String,
    var poderEspecialDos:String,
    var fechaIngresoEquipo:String,
    var goles:Int,
    var eqipoFutbolId:Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idJugadpr)
        parcel.writeInt(numeroCamiseta)
        parcel.writeString(nombreCamisate)
        parcel.writeString(nombreCompletoJugador)
        parcel.writeString(poderEspecialDos)
        parcel.writeString(fechaIngresoEquipo)
        parcel.writeInt(goles)
        parcel.writeInt(eqipoFutbolId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Jugador> {
        override fun createFromParcel(parcel: Parcel): Jugador {
            return Jugador(parcel)
        }

        override fun newArray(size: Int): Array<Jugador?> {
            return arrayOfNulls(size)
        }
    }

    override  fun toString():String{
        return "${nombreCompletoJugador}"
    }
}


