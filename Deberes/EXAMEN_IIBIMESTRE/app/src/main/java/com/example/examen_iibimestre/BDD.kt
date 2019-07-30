package com.example.examen_iibimestre

class BDD {
    companion object{
        var nomreUsuario:String=""
        var listaJugador:ArrayList<Jugador> = arrayListOf()
        var listaJugadorCompleta:ArrayList<Jugador> = arrayListOf()

        private val ip = "192.168.100.159"
        private val puerto = "1337"

        fun url(ruta: String): String {
            var rutaAux = ""
            when (ruta) {
                "jugador" -> rutaAux = "jugador"
                "equipo" -> rutaAux = "equipo"
                else -> rutaAux = ""
            }
            return "http://$ip:$puerto/${rutaAux}"
        }
    }
}