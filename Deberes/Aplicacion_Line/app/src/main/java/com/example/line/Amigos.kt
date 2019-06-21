package com.example.line

import android.os.Parcel
import android.os.Parcelable

class Amigos(
    var nombre:String,
    var ultimo_mensaje:String,
    var hora_conexion: String,
    var imagen:Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(ultimo_mensaje)
        parcel.writeString(hora_conexion)
        parcel.writeInt(imagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Amigos> {
        override fun createFromParcel(parcel: Parcel): Amigos {
            return Amigos(parcel)
        }

        override fun newArray(size: Int): Array<Amigos?> {
            return arrayOfNulls(size)
        }
    }
}