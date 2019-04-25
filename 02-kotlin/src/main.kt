import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    println("Hello, world!")
    /*
    * Comentario
    * */

    //Variables:
    //mutables (val):se puede reasignar una variable

    var nombre="Carolina"
    nombre="Nancy"

    //inmutables (val): no se puede reasignar la variable-> nombreI="Nancy"
    val nombreI="Caro"


    //Tipo de datos
    val apellido: String ="Cevallos"
    val edad: Int =24
    val sueldo: Double =4.00
    val casado: Boolean =false
    val profesor: Boolean =false
    val hijos: Nothing? =null

    //Duck typing
    //Si parece un pato
    //si camina como pato
    //si suena como pato
    //si vuela como pato
    //es un PATO
    //por lo que no es necesario que se escriba un tipo de dato, ya que kotlin ya lo asimila

    //Condicionales
    if(apellido == "Cevallos" && nombreI == "Caro"){
        println("Verdadero")
    }else{
        println("False")
    }

    val tieneNombreYApellido=if(apellido!=null && nombreI!=null)"ok" else "no"

    println(tieneNombreYApellido)

    estaJalado(1.0)
    estaJalado(5.0)
    estaJalado(7.0)
    estaJalado(10.0)
    holaMundo("Caro")
    holaMundoAvanzado(2)

    val total= sumarDosNumeros(1,3)//las variables como numUno y numDos lo pone automaticamente el editor de texto
    println(total)

    val arregloCumpleanos: Array<Int> = arrayOf(1,2,3,4)
    var arregloTodo: Array<Any> = arrayOf(1,"asd",19.2,true)//se crear una lista con diferente contenido

    //se puede cambiar un dato de la lista a pesar de tener el tipo de variable inmutable
    arregloCumpleanos[0]=5
    arregloCumpleanos.set(0,5)

    arregloTodo= arrayOf(5,2,3,4)


    //val notas:ArrayList<Int>= arrayListOf<Int>(1,2,3,4,5)
    val notas= arrayListOf(1,2,3,4,5,6)

    //iteraciones
    notas.forEach{nota:Int ->
        println(nota)
    }

    //FOR EACH->Itera el arreglo
    notas.forEachIndexed{indice, nota->
        println("Indice: $indice")
        println("Nota: $nota")

    }

    //MAP ->ITERA Y MODIFICA EL ARREGLO
    //Impares+1 Pares+2

    val notasDos = notas.map { nota->
        val modulo=nota % 2
        when(modulo){
            0 -> {
                nota+2
            }
            else ->{
                nota+1
            }
        }
    }

    notasDos.forEach {
        println("Notas 2: $it")

    }

    val respuestaFilter = notas
        .filter {//filtrar el arreglo
        it<5 && it>2
        it in 3..4//rango
        }
        .map { //mutar o cambiar el arreglo
            it*2
        }

    respuestaFilter.forEach {
        println(it)
    }


    val novias = arrayListOf(1,2,3,4,5)
    val respuestaNovia:Boolean = novias.any {
        it ==3
    }
    println(respuestaNovia)


    val tazos= arrayListOf(1,2,3,4,5,6,7)
    val respuestaTazos=tazos.all{
        it>1
    }
    println(respuestaTazos)

    val totalTazos=tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo //puede realizarse cualquier operacion con los valores de la lista
    }

    println(totalTazos)






    val fecha = Date()
    fecha.time= 12312332L
    fecha.year=2000
    //fecha=Date(year:2000, month:6, date:12)

    val numerito=Numero(1)
}




fun estaJalado(nota: Double){
    when (nota){
        7.0 -> {
            println("pasaste con las justas")
        }
        10.0 -> {
            println("Genail :D Felicidades!")
        }
        0.0 -> {
            println("Dios mio que vago!")
        }
        else->{
            println("Tu nota es: $nota")
            //println("Tu nota es: ${nota}" )
        }
    }
}

fun holaMundo(mensaje: String):Unit {
    println("Mensaje: $mensaje.")
}

fun holaMundoAvanzado(mensaje:Any):Unit {
    println("Mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno: Int, numDos: Int): Int{
    return numUno+numDos
}


class Usuario(val cedula:String){

    public var nombre:String = ""
    public var apellido:String = ""

    constructor(cedulaM:String,
                apellido:String) : this(cedulaM) {

        this.apellido = apellido

    }
}



class Numero(var numero:Int){

    constructor(numeroString:String):this(numeroString.toInt()){
        println("CONSTRUCTOR")
    }

    init {
        println("INIT")
        this.numero
    }
}










class UsuarioKT(var nombre:String,
                var apellido: String,
                private var id:Int,
                protected var id_:Int){


    init {
        // Escribir codigo
    }

    public fun hola():String{
        return this.apellido
    }
    private fun hola2(){

    }
    protected fun hola3(){

    }

    companion object {
        val gravedad = 10.5
        fun correr(){
            println("Estoy corriendo en $gravedad")
        }
    }

}

class BaseDeDatos{
    companion object {
        val usuarios = arrayListOf(1,2,3)
        fun agregarUsuario(usuario:Int){
            this.usuarios.add(usuario)
        }
        fun eliminarUsuaruio(usuario:Int){
            // this.usuarios.
        }
    }
}


fun aa(){
    UsuarioKT.gravedad
    UsuarioKT.correr()
}


fun a(){
    var caro = UsuarioKT("a","b",3,2)
    caro.nombre = "asdasd"

    val caro2 = Usuario("a")
    caro2.nombre = " "
    caro2.apellido = " "
}


class A{}

// A.correr()  // Metodo Estatico
// A.gravedad // Propiedad estatica

abstract class Numeros(var numeroUno:Int,
                       var numeroDos:Int){

}
class Suma(numeroUnos:Int,
           numeroDoss:Int) :
    Numeros(numeroUnos,numeroDoss){

}
fun cc(){
    val a = Suma(1,2)
    // val b = Numeros(1,2)
    // val b = Numeros(1,2)
}


fun presley(requerido:Int,
            opcional:Int =1,
            nulo:UsuarioKT?){
    if(nulo != null){
        nulo.nombre
    }
    val nombresito:String? = nulo?.nombre.toString()
    nulo!!.nombre


}
fun cddd(){
    presley(requerido = 1, nulo = null) // Named Parameters
    presley(1,1,null)
    presley(1,1,null)
}

