package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_primero.setOnClickListener {
            abrirPrimerFragmento()
        }
        btn_segundo.setOnClickListener {
            abrirSegundoFragmento()
        }
        btn_tercero.setOnClickListener{
            abrirTercerFragmento()
        }
    }

    fun abrirPrimerFragmento(){
        //1) Llamar a un Manager
        val fragmentManager = supportFragmentManager
        //2) Empezar la transaccción
        val transaccion = fragmentManager.beginTransaction()
        //3) Definir la instancia del fragmento
        val primerFragment = Primero_Fragment()
        //4)Reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmento, primerFragment) //sacar el número de identificación del cly usando R.i
        //5)Terminar la transaccion
        transaccion.commit()
    }
    fun abrirSegundoFragmento(){
        //1) Llamar a un Manager
        val fragmentManager = supportFragmentManager
        //2) Empezar la transaccción
        val transaccion = fragmentManager.beginTransaction()

        //3) Definir la instancia del fragmento
        val segundoFragmento = Segundo_Frangment()
        //4)Reemplazamos el fragmento

        transaccion.replace(R.id.cly_fragmento, segundoFragmento) //sacar el número de identificación del cly usando R.i
        //5)Terminar la transaccion
        transaccion.commit()
    }
    fun abrirTercerFragmento(){
        //1) Llamar a un Manager
        val fragmentManager = supportFragmentManager
        //2) Empezar la transaccción
        val transaccion = fragmentManager.beginTransaction()

        //3) Definir la instancia del fragmento
        val tercerFragmento = Segundo_Frangment()
        //4)Reemplazamos el fragmento

        val argumentos =Bundle();
        argumentos.putInt("constador",1)
        tercerFragmento.arguments=argumentos

        transaccion.replace(R.id.cly_fragmento, tercerFragmento) //sacar el número de identificación del cly usando R.i
        //5)Terminar la transaccion
        transaccion.commit()
    }
}
