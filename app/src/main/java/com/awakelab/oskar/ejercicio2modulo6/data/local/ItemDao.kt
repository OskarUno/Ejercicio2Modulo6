package com.awakelab.oskar.ejercicio2modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {

    //Le retiré el suspend a la funcion
    @Insert
     suspend fun insetarItem(item: Item)

    @Query("select * from item_table order by id ASC")
    fun getAllItems(): LiveData<List<Item>>
}