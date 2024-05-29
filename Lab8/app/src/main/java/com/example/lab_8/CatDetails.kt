package com.example.lab_8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_8.databinding.CatDetailsBinding

class CatDetailsActivity : AppCompatActivity() {
    private lateinit var binding: CatDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CatDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catBreed = intent.getStringExtra("catBreed")
        binding.catDetailsButton.text = catBreed
    }
}
