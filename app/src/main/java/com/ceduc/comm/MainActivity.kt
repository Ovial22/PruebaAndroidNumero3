package com.ceduc.comm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDronBlanco = findViewById<ImageButton>(R.id.botonDronBlanco)
        val btnTelevisorLcd = findViewById<ImageButton>(R.id.botonTelevisorLcd)
        val btnAuriculares = findViewById<ImageButton>(R.id.botonAuriculares)
        val btnVrHeadset = findViewById<ImageButton>(R.id.botonVrHeadset)
        val btnVerCarrito = findViewById<Button>(R.id.botonVerCarrito)
        val btnListar = findViewById<Button>(R.id.botonListar)

        fun abrirGestionProducto(producto: Producto) {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("producto_nombre", producto.nombre)
            intent.putExtra("producto_descripcion", producto.descripcion)
            intent.putExtra("producto_codigo", producto.codigo)
            intent.putExtra("producto_precio", producto.precio)
            intent.putExtra("producto_imagen", producto.imagen)
            startActivity(intent)

        }

        btnDronBlanco.setOnClickListener {
            abrirGestionProducto(Producto("Dron Blanco", R.drawable.drone, "Código: 722-01", "Peso: 1Kg\nBateria Max: 2h\nMarca: MaxWell\nGarantia: 1 año", 99.99))
        }

        btnTelevisorLcd.setOnClickListener {
            abrirGestionProducto(Producto("Televisor LCD", R.drawable.mcbook, "Código: 03-152", "Peso: 13Kg\nTelevisor: LCD 4K\nMarca: Samsung\nGarantia: 3 años", 299.99))
        }

        btnAuriculares.setOnClickListener {
            abrirGestionProducto(Producto("Auriculares", R.drawable.sound, "Código: 307-3", "Peso: 1kg\nAuriculares Gamer\nHi-Res Audio\nTriple-Driver in-ear\nMarca: 1MORE ", 159.99))
        }

        btnVrHeadset.setOnClickListener {
            abrirGestionProducto(Producto("VR Headset", R.drawable.vr, "Código: 5-504", "Peso: 2Kg\nCasco de realidad virtual para\nla Consola de Videojuegos\nMarca: SONY\nGarantia 2 años ", 559.99))
        }

        btnListar.setOnClickListener {
            val intent = Intent(this, ListaProductosActivity::class.java)
            startActivity(intent)
        }
        btnVerCarrito.setOnClickListener {
            val intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)
        }

    }
}
data class Producto(
    val nombre: String,
    val imagen: Int,
    val codigo: String,
    val descripcion: String,
    val precio: Double
)
object Carrito {
    private val listaProductos: MutableList<Producto> = mutableListOf()

    fun agregarAlCarrito(producto: Producto) {
        listaProductos.add(producto)
    }
    fun obtenerListaProductos(): List<Producto> {
        return listaProductos.toList()
    }


}


