package com.ceduc.comm
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class CarritoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)


        val listaProductosEnCarrito = Carrito.obtenerListaProductos()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adaptador = ProductosAdapter(listaProductosEnCarrito)
        recyclerView.adapter = adaptador

        val botonPagar = findViewById<Button>(R.id.buttondePagarsinFuncionalidad)
        botonPagar.setOnClickListener{
            Toast.makeText(this, "Se procedera al pago de los productos", Toast.LENGTH_SHORT).show()
        }


     }

}