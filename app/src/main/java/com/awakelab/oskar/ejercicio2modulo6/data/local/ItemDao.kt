package com.awakelab.oskar.ejercicio2modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select

@Dao
interface ItemDao {

    @Insert
    suspend fun insetarItem(item:Item)

    @Query("select * from item_table order by id ASC")
    fun getAllItems(): LiveData<List<Item>>

}