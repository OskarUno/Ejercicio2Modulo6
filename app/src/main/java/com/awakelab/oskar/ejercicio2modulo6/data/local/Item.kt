package com.awakelab.oskar.ejercicio2modulo6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
    val nombre: String,
    val precio: Int,
    val cantidad: Int,

    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
