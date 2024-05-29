package com.example.lab10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lab10.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPhotos()

        binding.addPhotoButton.setOnClickListener {
            val retrofit = RetrofitClient.getInstance()
            val apiInterface = retrofit.create(ApiInterface::class.java)
            lifecycleScope.launch {
                try {
                    val photo = Photo(
                        id = binding.photoId.text.toString().toInt(),
                        albumId = binding.albumId.text.toString().toInt(),
                        title = binding.photoTitle.text.toString(),
                        url = binding.url.text.toString(),
                        thumbnailUrl = binding.thumbnailUrl.text.toString()
                    )
                    val response = apiInterface.addPhoto(photo)
                    if (response.isSuccessful && response.body() != null) {
                        Toast.makeText(applicationContext, "new photo added", Toast.LENGTH_SHORT).show()
                    }
                } catch (Ex: Exception) {
                    Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun getPhotos(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            val response = apiInterface.getPhotoById(1)
            binding.textView.text = response.body()?.title
        }
    }
}