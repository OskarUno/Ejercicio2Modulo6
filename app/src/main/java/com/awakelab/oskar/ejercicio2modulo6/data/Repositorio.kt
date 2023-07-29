package com.awakelab.oskar.ejercicio2modulo6.data

import androidx.lifecycle.LiveData
import com.awakelab.oskar.ejercicio2modulo6.data.local.Item
import com.awakelab.oskar.ejercicio2modulo6.data.local.ItemDao

class Repositorio(private val itemDao: ItemDao) {

    //Recibe un item desde el view
    suspend fun insertItem(item: Item) {
        itemDao.insetarItem(item)
    }

    fun getItem(): LiveData<List<Item>> {
        return itemDao.getAllItems()
    }

}