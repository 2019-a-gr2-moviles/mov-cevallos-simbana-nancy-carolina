package Modelo
val listaP=ArrayList<Producto>()
class Producto {
    var idCategoria:String=""
    var codigo:String=""
    var descripcion:String=""
    var color:String=""
    var precio:String=""
    var talla:String=""


    override fun toString(): String {
        return this.codigo.toString()
    }
}