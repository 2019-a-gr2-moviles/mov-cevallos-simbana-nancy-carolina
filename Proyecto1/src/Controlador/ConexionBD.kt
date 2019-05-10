package Controlador

import Modelo.Categoria
import Modelo.Producto
import java.io.*
import javax.swing.JOptionPane

class ConexionBD{

    var categoria=Categoria()
    var producto=Producto()

    fun leerArchivo():ArrayList<Producto>{
        val contenido=File("src/archivos/bdProducto.txt").readText()

        /*val cadena=BufferedReader(FileReader(File("src/archivos/bdProducto.txt")))
        val content = cadena.readLine()*/
        var listaProducto=ArrayList<Producto>()
        val lista =contenido.split(';')

        lista.forEach{ element->
            val elementos=element.split(',')
            val elementosProducto = Producto()
            if(elementos.size>1){
                print(elementos)
                elementosProducto.idCategoria=elementos[0]
                elementosProducto.codigo=elementos[1]
                elementosProducto.descripcion=elementos[2]
                elementosProducto.talla=elementos[3]
                elementosProducto.color=elementos[4]
                elementosProducto.precio=elementos[5]
                listaProducto.add(elementosProducto)
                print(elementosProducto)
            }
        }
        print(listaProducto)
        return listaProducto
    }

    fun EscribiArchivo(listaProductos:ArrayList<Producto>):Boolean{
        var cadena:String=""
        var exito=false
        listaProductos.forEach{item->
            cadena+=item.idCategoria+","+item.codigo+","+item.descripcion+","+item.talla+","+item.color+","+item.precio+";"
        }
        try {
            val content2 = File("src/archivos/bdProducto.txt").writeText(cadena)
            JOptionPane.showMessageDialog(null, "Ingreso Exitoso")
            exito=true
        }catch (e:IllegalStateException){
            JOptionPane.showMessageDialog(null, "Se produjo un Error")
        }

        return exito
    }
    fun leerArchivoCategoria():ArrayList<Categoria>{
        val contenido=File("src/archivos/bdCategoria.txt").readText()

        /*val cadena=BufferedReader(FileReader(File("src/archivos/bdProducto.txt")))
        val content = cadena.readLine()*/
        var listaCategoria=ArrayList<Categoria>()
        val lista =contenido.split(';')

        lista.forEach{ element->
            val elementos=element.split(',')
            val elementosCategoria = Categoria()
            if(elementos.size>1){
                print(elementos)
                elementosCategoria.idCategoria=elementos[0]
                elementosCategoria.nombreCategoria=elementos[1]
                listaCategoria.add(elementosCategoria)
            }
        }
        print(listaCategoria)
        return listaCategoria
    }

    fun EscribiArchivoCategoria(listaProductos:ArrayList<Categoria>):Boolean{
        var cadena:String=""
        var exito=false
        listaProductos.forEach{item->
            cadena+=item.idCategoria+","+item.nombreCategoria+";"
        }
        try {
            val content2 = File("src/archivos/bdCategoria.txt").writeText(cadena)
            JOptionPane.showMessageDialog(null, "Ingreso Exitoso")
            exito=true
        }catch (e:IllegalStateException){
            JOptionPane.showMessageDialog(null, "Se produjo un Error")
        }

        return exito
    }
}