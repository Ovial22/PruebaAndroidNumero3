package com.ceduc.comm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductosAdapter(private val listaProductos: List<Producto>) :
    RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_producto, parent, false)
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val currentItem = listaProductos[position]

        holder.imageView.setImageResource(currentItem.imagen)
        holder.nombreTextView.text = currentItem.nombre
        holder.codigoTextView.text = currentItem.codigo
        holder.descripcionTextView.text = currentItem.descripcion
        holder.precioTextView.text = currentItem.precio.toString()
    }

    override fun getItemCount() = listaProductos.size

    inner class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nombreTextView: TextView = itemView.findViewById(R.id.madeloTview)
        val codigoTextView: TextView = itemView.findViewById(R.id.CodigoTextView)
        val descripcionTextView: TextView = itemView.findViewById(R.id.DescripcionTextView)
        val precioTextView: TextView = itemView.findViewById(R.id.PreciotextView)
        val botonAgregarCarrito: Button = itemView.findViewById(R.id.botonAgregarCarrito)

        init {
            botonAgregarCarrito.visibility = View.GONE
        }
    }

}

