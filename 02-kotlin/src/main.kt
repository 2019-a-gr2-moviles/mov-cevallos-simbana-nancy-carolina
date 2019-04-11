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

    estaJalado(nota = 1.0)
    estaJalado(nota = 5.0)
    estaJalado(nota = 7.0)
    estaJalado(nota = 10.0)

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