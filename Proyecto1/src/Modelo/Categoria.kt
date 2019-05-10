package Modelo

import java.io.Serializable

class Categoria:Serializable {
    var idCategoria:String=""
    var nombreCategoria:String=""


    override fun toString(): String {
        return this.idCategoria.toString()
    }
}