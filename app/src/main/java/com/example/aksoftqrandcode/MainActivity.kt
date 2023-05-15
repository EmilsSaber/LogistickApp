package com.example.aksoftqrandcode

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.aksoftqrandcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var requestCamera: ActivityResultLauncher<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, NavControllerFragment())
                    .commit()
            } else {
                Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show()
            }
        }

        requestCamera?.launch(android.Manifest.permission.CAMERA)
    }
}