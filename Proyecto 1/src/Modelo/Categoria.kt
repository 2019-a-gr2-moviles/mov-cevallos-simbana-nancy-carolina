package Modelo

import java.io.Serializable

class Categoria:Serializable {
    var idCategoria:String=""
    var nombreGrupo:String=""
    var listaProducto:ArrayList<Producto>?=null
}