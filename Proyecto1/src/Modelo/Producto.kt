package Modelo

class Producto {
    var codigo:String=""
     var descripcion:String=""
     var color:String=""
     var precio:String=""

    /*constructor(codigo:String,descripcion:String, color:String, precio:String){
        this.codigo=codigo
        this.descripcion=descripcion
        this.color=color
        this.precio=precio
    }*/
/*
    fun getCodigo():String{
        return codigo
    }

    fun setCodigo(codigo: String){
        this.codigo= codigo
    }

    fun getDescripcion():String{
        return descripcion
    }

    fun setDescripcion(descripcion: String){
        this.descripcion= descripcion
    }

    fun getColor():String{
        return  color
    }

    fun setColor(color: String){
        this.color=color
    }

    fun getPrecio():String{
        return  precio
    }

    fun setPrecio(precio: String){
        this.precio=precio
    }*/

    override fun toString(): String {
        return this.codigo.toString()
    }

}