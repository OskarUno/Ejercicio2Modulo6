package com.awakelab.oskar.ejercicio2modulo6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.awakelab.oskar.ejercicio1modulo6room.R
import com.awakelab.oskar.ejercicio1modulo6room.databinding.FragmentListtBinding

/* Pasos para crear un recycler view
[ ] item layout
[ ] agregar constraints
[] cambiar altura de constraints layout de item layout a wrap content
[] definir ID
[ ] layout con recycler view
[ ] asignar layout manager
[x ] implementar clase Adapter
[x]  heredar RecyclerView.Adapter
[x] creaciones de los métodos: onCreateViewHolder, getItemCount y onBindViewHolder
[x ] crear clase anidada ViewHolder, que hereda de la clase ViewHolder
[x] Agregar constructor
[x] crear objeto, data class
[x] Crear lista
[x] asignar tamaño de la lista en getItemCount
[x] definir Binding Class del Item
[x] cambiar view por el binding
[x] declarar variable item en onBindViewHolder
[x] implementar binding en clase viewHolder
[x] Adapter+ view holder
[ x] obtener los datos
*/

class ListFragment : Fragment() {
    lateinit var binding: FragmentListtBinding
    val itemViewModel: ItemViewModel by activityViewModels()
    val adapter = ItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListtBinding.inflate(inflater, container, false)
        initLista()
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.floatingActionButton4.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

    }

    private fun initLista() {
        itemViewModel.getAllItems().observe(viewLifecycleOwner) {
        adapter.setData(it)
        }
        binding.rv.adapter = adapter
    }

}