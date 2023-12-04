package com.ceduc.comm

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.annotation.SuppressLint

class SQLiteDB (context: Context):SQLiteOpenHelper(context,"productos", null, 1) {
    companion object {
        private const val TABLE_NAME = "productos"
        private const val COL_NOMBRE = "nombre"
        private const val COL_IMAGEN = "imagen"
        private const val COL_CODIGO = "codigo"
        private const val COL_DESCRIPCION = "descripcion"
        private const val COL_PRECIO = "precio"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME " +
                "($COL_NOMBRE TEXT, $COL_IMAGEN INTEGER, $COL_CODIGO TEXT PRIMARY KEY, " +
                "$COL_DESCRIPCION TEXT, $COL_PRECIO REAL)"
        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun agregarProducto(producto: Producto): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NOMBRE, producto.nombre)
        contentValues.put(COL_IMAGEN, producto.imagen)
        contentValues.put(COL_CODIGO, producto.codigo)
        contentValues.put(COL_DESCRIPCION, producto.descripcion)
        contentValues.put(COL_PRECIO, producto.precio)

        val resultado = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return resultado
    }
    @SuppressLint("Range")
    fun obtenerProductos(): ArrayList<Producto> {
        val productos = ArrayList<Producto>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor: Cursor? = db.rawQuery(query, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val nombre = cursor.getString(cursor.getColumnIndex(COL_NOMBRE))
                    val imagen = cursor.getInt(cursor.getColumnIndex(COL_IMAGEN))
                    val codigo = cursor.getString(cursor.getColumnIndex(COL_CODIGO))
                    val descripcion = cursor.getString(cursor.getColumnIndex(COL_DESCRIPCION))
                    val precio = cursor.getDouble(cursor.getColumnIndex(COL_PRECIO))
                    val producto = Producto(nombre, imagen, codigo, descripcion, precio)
                    productos.add(producto)
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
        db.close()
        return productos
    }

    fun borrarProducto(codigo:String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "$COL_CODIGO=?", arrayOf(codigo))
    }

    fun actualizarProducto(producto: Producto): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NOMBRE, producto.nombre)
        contentValues.put(COL_IMAGEN, producto.imagen)
        contentValues.put(COL_DESCRIPCION, producto.descripcion)
        contentValues.put(COL_PRECIO, producto.precio)
        return db.update(TABLE_NAME, contentValues, "$COL_CODIGO=?", arrayOf(producto.codigo))
    }
}