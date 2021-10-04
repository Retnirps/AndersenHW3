package com.majestadev.andersenhw3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val picassoButton: Button = findViewById(R.id.picassoButton)
        val withoutLibrariesButton: Button = findViewById(R.id.withoutLibrariesButton)

        picassoButton.setOnClickListener {
            startActivity(Intent(this, PicassoLoaderActivity::class.java))
        }

        withoutLibrariesButton.setOnClickListener {
            startActivity(Intent(this, WithoutLibrariesImageLoaderActivity::class.java))
        }
    }
}