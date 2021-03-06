package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import com.example.ejemploparcelable.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener {
            irAParcelable()
        }
        //btn_toast.setOnClickListener {
        //    irAToast()
        //}
        btn_adapter.setOnClickListener {
            irAListView()
        }

        btn_recycler_view.setOnClickListener {
            iraRecycler()
        }

        btn_intentRespuesta.setOnClickListener {

        }
        /* Snackbar
            .make(view, "Gracias por crear un nuevo usuario", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
            */
    }
    /*
    fun irAToast(){
        val intentExplicito = Intent(
            this,
            Main2Activity::class.java
        )
        startActivity(intentExplicito)
    }


*/

    fun irAListView(){
        val intentExplicito = Intent(
            this,
            ListViewActivity::class.java
        )
        startActivity(intentExplicito)
    }


    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val adrian = Usuario("Adrian",
            29,
            Date(),
            12.12)
        intentExplicito.putExtra("usuario",adrian)

        val cachetes = Mascota("Cachetes", adrian)
        intentExplicito.putExtra("mascota", cachetes)


        startActivity(intentExplicito)


    }

    fun mostrarSnack(view: View, texto:String){
        Snackbar
            .make(view, texto, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

    }

    fun iraRecycler(){
        val intentExplicito=Intent(
            this, ReciclerViewActivity::class.java
        )
        startActivity(intentExplicito)
    }


    fun iraIntentRespuesta(){
        val intentRespuesta= Intent(
            this,IntentRespuestaActivity::class.java
        )
        startActivity(intentRespuesta)
    }




}
