package com.ceduc.comm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaProductosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_productos)

        val listaProductosDisponibles = obtenerListaDeProductos()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerListaDProductoa)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adaptador = ProductosAdapter(listaProductosDisponibles)
        recyclerView.adapter = adaptador
    }

    private fun obtenerListaDeProductos(): List<Producto> {
        val lista = mutableListOf<Producto>()
        lista.add(Producto("", R.drawable.drone, "Código: 722-01", "Quedan 18 unidades en bodega / 5 unidad por Internet", 99.99))
        lista.add(Producto("", R.drawable.mcbook, "Código: 03-152", "Quedan 24 unidades en bodega / 6 unidad por Internet", 299.99))
        lista.add(Producto("", R.drawable.sound, "Código: 307-3", "Quedan 11 unidades en bodega / 2 unidad por Internet", 159.99))
        lista.add(Producto("", R.drawable.vr, "Código: 5-504", "Quedan 4 unidades en bodega / 1 unidad por Internet", 559.99))
        return lista
    }
}