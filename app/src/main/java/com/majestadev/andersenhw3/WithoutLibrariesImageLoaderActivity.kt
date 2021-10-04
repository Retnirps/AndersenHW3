package com.majestadev.andersenhw3

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.lang.Exception
import java.util.concurrent.Executors

class WithoutLibrariesImageLoaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_libraries_image_loader)

        val imageView: ImageView = findViewById(R.id.imageView2)
        val getImageButton: Button = findViewById(R.id.getImageButton2)
        val imageUrlEditText: EditText = findViewById(R.id.imageUrlEditText2)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        var image: Bitmap?

        getImageButton.setOnClickListener {
            val url = imageUrlEditText.text.toString()

            executor.execute {
                try {
                    val inputStream = java.net.URL(url).openStream()
                    image = BitmapFactory.decodeStream(inputStream)

                    handler.post {
                        imageView.setImageBitmap(image)
                    }
                } catch (e: Exception) {
                    Toast.makeText(
                        this,
                        "Failed to load the image",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            it.hideKeyboard()
        }
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}