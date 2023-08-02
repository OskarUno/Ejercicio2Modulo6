package com.awakelab.oskar.ejercicio2modulo6.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.awakelab.oskar.ejercicio2modulo6.data.Repositorio
import com.awakelab.oskar.ejercicio2modulo6.data.local.Item
import com.awakelab.oskar.ejercicio2modulo6.data.local.ItemDataBase
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repositorio

    init {
        val dao = ItemDataBase.getDatabase(application).getItemDao()
        repository = Repositorio(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repository.getItem()

    fun insertItem(name: String, price: Int, quantity: Int) = viewModelScope.launch {
        val item = Item(name, price, quantity)
        repository.insertItem(item)
    }

}
