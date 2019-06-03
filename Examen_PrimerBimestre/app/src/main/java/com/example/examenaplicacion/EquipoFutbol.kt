package com.example.examenaplicacion

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class EquipoFutbol(
    var idEquipo:Int?,
    var nombre:String,
    var liga:String,
    var fechaCreacion: Date,
    var numberCopasInternacionales:Int,
    var campeonActual:Boolean
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readSerializable() as Date,
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idEquipo)
        parcel.writeString(nombre)
        parcel.writeString(liga)
        parcel.writeSerializable(fechaCreacion)
        parcel.writeInt(numberCopasInternacionales)
        parcel.writeByte(if (campeonActual) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EquipoFutbol> {
        override fun createFromParcel(parcel: Parcel): EquipoFutbol {
            return EquipoFutbol(parcel)
        }

        override fun newArray(size: Int): Array<EquipoFutbol?> {
            return arrayOfNulls(size)
        }
    }
    override  fun toString():String{
        return "{${nombre.toUpperCase()}}"
    }
}