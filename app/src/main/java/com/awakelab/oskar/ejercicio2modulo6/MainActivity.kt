package com.awakelab.oskar.ejercicio2modulo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.awakelab.oskar.ejercicio1modulo6room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}