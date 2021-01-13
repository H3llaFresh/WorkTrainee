package by.vlfl.fxsuperpro.ui.screens.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.vlfl.fxsuperpro.databinding.ActivityStartBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthorizationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    private val viewModel: AuthorizationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}