package com.awakelab.oskar.ejercicio2modulo6.presentacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.awakelab.oskar.ejercicio1modulo6room.databinding.FragmentAddBinding
import com.awakelab.oskar.ejercicio1modulo6room.databinding.ItemBinding
import com.awakelab.oskar.ejercicio2modulo6.data.local.Item

/*
[] implementar clase Adapter
[]  heredar RecyclerView.Adapter
[] creaciones de los métodos: onCreateViewHolder, getItemCount y onBindViewHolder
[] crear clase anidada ViewHolder, que hereda de la clase ViewHolder
[] Agregar constructor
[] crear objeto, data class
[] Crear lista
[ ] asignar tamaño de la lista en getItemCount
[] definir Binding Class del Item
[] cambiar view por el binding
[ ] declarar variable item en onBindViewHolder
[ ] implementar binding en clase viewHolder
[x] Adapter+ view holder
[ x] obtener los datos
*/
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    lateinit var binding: ItemBinding
    private val listItem = mutableListOf<Item>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.render(item)
    }

    class ItemViewHolder(val v: ItemBinding) : RecyclerView.ViewHolder(v.root) {
        fun render(item: Item) {
            v.tvNombre.text = item.nombre
            v.tvPrecio.text = item.precio.toString()
            v.tvCantidad.text = item.cantidad.toString()
            v.tvTotal.text = (item.precio * item.cantidad).toString()
        }
    }
}