package Controlador

import Modelo.Producto
import escrbiriLeer

class ProductoBD {
    val conexion=ConexionBD()
    var listaProductos=ArrayList<Producto>()
    val producto=Producto()

    fun consultarLista(){
        listaProductos==escrbiriLeer.leerArchivo()
    }

    fun ingresarProducto(){

    }

    fun editarProducto(){

    }

    fun eliminarProducto(){

    }
}