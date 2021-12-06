package com.hoony.coroutinesample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hoony.coroutinesample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            onMain.setOnClickListener {
                viewModel.launch(Dispatchers.Main)
            }
            onDefault.setOnClickListener {
                viewModel.launch(Dispatchers.Default)
            }
            onIo.setOnClickListener {
                viewModel.launch(Dispatchers.IO)
            }
        }
    }
}