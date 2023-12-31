package com.awakelab.oskar.ejercicio2modulo6.presentacion

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.awakelab.oskar.ejercicio1modulo6room.R
import com.awakelab.oskar.ejercicio1modulo6room.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding
    private val itemViewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        initListener()
        return binding.root
    }

    private fun initListener() {

        binding.btnGuardar.setOnClickListener {
            val nombre = binding.editTextNombre.text.toString()
            val precio = binding.editTextPrecio.text.toString().toInt()
            val cantidad = binding.editTextCantidad.text.toString().toInt()
            itemViewModel.insertItem(nombre, precio, cantidad)
            Toast.makeText(context, "Producto Agregado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

        binding.editTextCantidad.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isNotEmpty()) {
                    val total =
                        s.toString().toInt() * binding.editTextPrecio.text.toString().toInt()
                    binding.txtResultado.text = total.toString()
                } else {
                    binding.txtResultado.text = ""
                }
            }
        })
    }
}