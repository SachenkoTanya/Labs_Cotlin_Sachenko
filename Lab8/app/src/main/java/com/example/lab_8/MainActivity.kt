package com.example.lab_8

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerViewVert.layoutManager = LinearLayoutManager(this)
        val cats = listOf(
            Pair("Siamese", "https://images.unsplash.com/photo-1568152950566-c1bf43f4ab28"),
            Pair("Persian", "https://images.unsplash.com/photo-1585137173132-cf49e10ad27d"),
            Pair("Maine Coon", "https://images.unsplash.com/photo-1569591159212-b02ea8a9f239"),
            Pair("Bengal", "https://images.unsplash.com/photo-1598463166228-c0f90d180918"),
            Pair("Ragdoll", "https://images.unsplash.com/photo-1620933288385-b2f6f1931d9e"),
        )

        val adapter = CatAdapter(cats){ position: Int ->
            val intent = Intent(this, CatDetailsActivity::class.java)
            intent.putExtra("catBreed", cats[position].first)
            startActivity(intent)
        }

        binding.recyclerViewVert.adapter = adapter
        binding.recyclerViewHor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val animalsNames = listOf(
            "Siamese",
            "Persian",
            "Maine Coon",
            "Bengal",
            "Ragdoll",
        )
        val adapterSecond = HorizontalViewAdapter(animalsNames)
        binding.recyclerViewHor.adapter = adapterSecond
    }
}