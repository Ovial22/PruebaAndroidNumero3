package com.ceduc.comm
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val productoNombre = intent.getStringExtra("producto_nombre")
        val productoDescripcion = intent.getStringExtra("producto_descripcion")
        val productoCodigo = intent.getStringExtra("producto_codigo")
        val productoPrecio = intent.getDoubleExtra("producto_precio", 0.0)
        val productoImagen = intent.getIntExtra("producto_imagen", R.drawable.istockphoto_1206806317_612x612)

        val nombreTextView = findViewById<TextView>(R.id.madeloTview)
        val descripcionTextView = findViewById<TextView>(R.id.DescripcionTextView)
        val codigoTextView = findViewById<TextView>(R.id.CodigoTextView)
        val precioTextView = findViewById<TextView>(R.id.PreciotextView)
        val imagenProductoImageView = findViewById<ImageView>(R.id.imageView)
        val botonAgregarCarrito = findViewById<Button>(R.id.botonAgregarCarrito)


        nombreTextView.text = productoNombre
        descripcionTextView.text = productoDescripcion
        codigoTextView.text = productoCodigo
        precioTextView.text = "Precio: $productoPrecio"
        imagenProductoImageView.setImageResource(productoImagen)


        botonAgregarCarrito.setOnClickListener{
            val producto = obtenerProductoActual()

            if (producto != null) {
                agregarProductoAlCarrito(producto)
            } else {
                Toast.makeText(this, "No se ha logrado agregar el producto al carrito", Toast.LENGTH_SHORT).show()
            }

        }

    }

        private fun obtenerProductoActual(): Producto? {
            val productoNombre = intent.getStringExtra("producto_nombre") ?: ""
            val productoDescripcion = intent.getStringExtra("producto_descripcion") ?: ""
            val productoCodigo = intent.getStringExtra("producto_codigo") ?: ""
            val productoPrecio = intent.getDoubleExtra("producto_precio", 0.0)
            val productoImagen = intent.getIntExtra("producto_imagen", R.drawable.istockphoto_1206806317_612x612)

            return if (productoNombre != null && productoDescripcion != null && productoCodigo != null && productoPrecio != 0.0) {
                Producto(
                    productoNombre,
                    productoImagen,
                    productoCodigo,
                    productoDescripcion,
                    productoPrecio )
                }
                else
                {
                 null
                }
            }

    private fun agregarProductoAlCarrito(producto: Producto) {
    Carrito.agregarAlCarrito(producto)
    Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show()
    }
}


