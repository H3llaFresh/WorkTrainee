package by.vlfl.fxsuperpro.ui.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.vlfl.fxsuperpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}