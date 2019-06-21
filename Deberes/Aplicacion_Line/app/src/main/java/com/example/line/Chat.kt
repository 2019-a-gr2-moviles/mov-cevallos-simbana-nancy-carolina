package com.example.line

import android.os.Parcel
import android.os.Parcelable

class Chat(
    var mensaje_enviado:String,
    var mensaje_recibido:String,
    var hora_entregado:String,
    var hora_recibido:String,
    var visto:String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(mensaje_enviado)
        parcel.writeString(mensaje_recibido)
        parcel.writeString(hora_entregado)
        parcel.writeString(hora_recibido)
        parcel.writeString(visto)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Chat> {
        override fun createFromParcel(parcel: Parcel): Chat {
            return Chat(parcel)
        }

        override fun newArray(size: Int): Array<Chat?> {
            return arrayOfNulls(size)
        }
    }
}