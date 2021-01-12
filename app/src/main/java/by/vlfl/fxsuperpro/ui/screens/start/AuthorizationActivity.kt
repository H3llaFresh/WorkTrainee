package by.vlfl.fxsuperpro.ui.screens.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.vlfl.fxsuperpro.databinding.ActivityStartBinding

class AuthorizationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}