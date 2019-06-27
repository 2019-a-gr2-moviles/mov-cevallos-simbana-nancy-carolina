package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaNombres = arrayListOf<String>()
        listaNombres.add("Nancy")
        listaNombres.add("Carolina")
        listaNombres.add("Cevallos")
        listaNombres.add("Simbaña")
        listaNombres.add("Maria")

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            listaNombres)

        lv_ejemplo.adapter = adapter

        lv_ejemplo.onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->
            Log.i("list-view","Posicion $position")
        }



    }
}
