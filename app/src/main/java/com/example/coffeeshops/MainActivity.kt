package com.example.coffeeshops

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coffe = ArrayList<Shops>()
        coffe.add(Shops(R.drawable.images,"Antico Caffe Greco","St. Italy, Rome"))
        coffe.add(Shops(R.drawable.images1,"Coffee Room","St. Germany, Berlin"))
        coffe.add(Shops(R.drawable.images2,"Coffee Ibiza","St. Colon, Madrid"))
        coffe.add(Shops(R.drawable.images3,"Pudding Coffee Shop","St. Diagonal, Barcelona"))
        coffe.add(Shops(R.drawable.images4,"L'Express","St. Picadilly Circus, London"))
        coffe.add(Shops(R.drawable.images5,"Coffee Corner","St. Angel Guimera, Valencia"))
        coffe.add(Shops(R.drawable.images6,"Sweet Cup","St. Kinkerstraat, Amsterdam"))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        recView.setHasFixedSize(true)

        val adaptador = ShopsAdapter(coffe)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        adaptador.onClick = {
            recView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }


    }
}