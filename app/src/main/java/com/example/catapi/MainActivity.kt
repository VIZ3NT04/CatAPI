package com.example.catapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.catapi.service.CatApiService
import com.example.catapi.singelton.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val catBreeds = RetrofitInstance.api.getListadoRazas()
                catBreeds.forEach { cat ->
                    println("Raza: ${cat.name}, Origen: ${cat.origin}, Temperamento: ${cat.temperament} , Peso: ${cat.weight.metric} kg / ${cat.weight.imperial} lb")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}