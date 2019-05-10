package Controlador

import Modelo.Categoria
import Modelo.Producto
import java.io.File
import com.google.gson.Gson


var producto=Producto()

fun leerArchivo(){
    val content = File("src/archivos/bdProducto.txt").readText()
    return content

}

fun EscribiArchivo(nuevoproducto:Producto){
    val jsonProducto=gson.toJson(producto)
    val content2 = File("src/archivos/bdProducto.txt").writeText(jsonProducto)

}