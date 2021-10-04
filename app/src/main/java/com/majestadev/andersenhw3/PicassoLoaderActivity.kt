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
import com.squareup.picasso.Picasso
import java.lang.Exception
import java.util.concurrent.Executors

class PicassoLoaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso_loader)

        val imageView: ImageView = findViewById(R.id.imageView)
        val getImageButton: Button = findViewById(R.id.getImageButton)
        val imageUrlEditText: EditText = findViewById(R.id.imageUrlEditText)

        val builder = Picasso.Builder(this)
            .listener { _, _, _ ->
                Toast.makeText(
                    this,
                    "Failed to load the image",
                    Toast.LENGTH_SHORT
                ).show()
            }

        val picasso = builder.build()

        getImageButton.setOnClickListener {
            val url = imageUrlEditText.text.toString()
            picasso.load(url).placeholder(R.drawable.loading_animation).into(imageView)

            it.hideKeyboard()
        }
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}