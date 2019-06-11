package com.example.examenaplicacion

import android.os.Parcel
import android.os.Parcelable
import android.app.PendingIntent.getActivity
import android.content.Context
import android.provider.Settings.System.getString
import android.support.v4.content.res.TypedArrayUtils.getText
import java.util.*

class EquipoFutbol(
    var idEquipo:Int,
    var nombre:String,
    var liga:String,
    var fechaCreacion: String,
    var numberCopasInternacionales:Int,
    var campeonActual:Boolean
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idEquipo)
        parcel.writeString(nombre)
        parcel.writeString(liga)
        parcel.writeString(fechaCreacion)
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
        return "${nombre}"
    }
}
