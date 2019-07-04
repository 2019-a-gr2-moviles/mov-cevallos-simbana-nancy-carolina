package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList
import com.github.kittinunf.result.Result.*
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost

class ConexionHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_http)
        //parseando un objeto
        /*val json = """

                {
                  "createdAt": 1561663617636,
                  "updatedAt": 1561663617636,
                  "id": 1,
                  "nombre": "Manticore Labs"
                }

        """.trimIndent()

        try {
            val empresaInstancia=Klaxon()
                .parse<Empresa>(json)
            Log.i("http",
                "Nombre ${empresaInstancia?.nombre}")
            Log.i("http",
                "Id ${empresaInstancia?.id}")
            if(empresaInstancia!=null){
                Log.i("http",
                    "Fecha ${Date(empresaInstancia.createdAt)}")
            }


        }catch (e:Exception){
            Log.i("http",
                "Error instanciando la empresa")
        }*/


        //para un arreglo de registros

        val jsonarreglo="""
            [
                {
                  "usuariosDeEmpresa": [
                      {
                          "createdAt": 1561663617636,
                          "updatedAt": 1561663617636,
                          "id": 1,
                          "nombre": "Adrian",
                          "fkEmpresa": 1,
                      }
                  ],
                  "createdAt": 1561663617636,
                  "updatedAt": 1561663617636,
                  "id": 1,
                  "nombre": "Manticore Labs"
                }
            ]
        """.trimIndent()

        try {
            val empresaInstanciaArreglo=Klaxon()
                .parseArray<Empresa>(jsonarreglo)
            empresaInstanciaArreglo?.forEach {
                Log.i("http",
                    "Nombre ${it.nombre}")
                Log.i("http",
                    "Id ${it.id}")

                Log.i("http",
                    "Fecha ${Date(it.createdAt)}")

                it.usuariosDeEmpresa.forEach {
                    Log.i("http",
                        "Nombre ${it.nombre}")
                    Log.i("http",
                        "FK ${it.fkEmpresa}")
                }

            }



        }catch (e:Exception){
            Log.i("http",
                "Error instanciando arreglo de empresa ${e.message}")
        }


        val url="http://172.31.104.102:1337/empresa/1"

        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        val empresaParseada=Klaxon()
                            .parse<Empresa>(data)
                        if(empresaParseada!=null){
                            Log.i("http", "iiiiiiiiiiiii")
                            Log.i("http", "${empresaParseada.nombre}")
                            Log.i("http", "${empresaParseada.id}")
                        }
                    }
                }
            }

        val parametrosCrearEmpresa=listOf(

                "nombre" to "Manticore Labs 2",
                "apellido" to "Cevallos",//Colados
                "sueldo" to 200.50,
                "casado" to false,
                "hijos" to null

        )
        //Parametros=List<Pair<String,Any?>>
        val urlCrearEmpresa="http://172.31.104.102:1337/empresa"
        urlCrearEmpresa
            .httpPost(parametrosCrearEmpresa)
            .responseString{request, response, result ->
                when(result){
                    is Failure->{
                        val error =result.getException()
                        Log.i("http","Error: ${error}")
                    }
                    is Success->{
                        val empresaString=result.get()
                        Log.i("http","${empresaString}")
                    }
                }
            }
    }
}
