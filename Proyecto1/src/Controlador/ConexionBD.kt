package Controlador

import Modelo.Categoria
import Modelo.Producto
import java.io.*

class ConexionBD{

    var categoria=Categoria()
    val listaProducto=ArrayList<Producto>()

    fun leerArchivo():ArrayList<Producto>{
        val cadena=BufferedReader(FileReader(File("src/archivos/bdProducto.txt")))
        val content = cadena.readLine()
        val dbPRODUCTO=ArrayList<Producto>()
        val lista =content.split(';')
        lista.forEach{ element->
            val elementos=element.split(',')
            val elementosProducto = Producto(
                codigo=" ",
                desscripcion=" ",
                color=" ",
                precio=" "
            )

            elementosProducto.codigo=elementos[0]
            elementosProducto.descripcion=elementos[1]
            elementosProducto.color=elementos[2]
            elementosProducto.precio=elementos[3]
            listaProducto.add(elementosProducto)
        }

        return listaProducto
    }

    fun EscribiArchivo(listaProductos:ArrayList<Producto>){
        var cadena:String=""
        listaProductos.forEach{item->
            cadena=item.codigo+","+item.descripcion+","+item.color+","+item.precio+";"
        }
        val content2 = File("src/archivos/bdProducto.txt").writeText(cadena)

    }
}