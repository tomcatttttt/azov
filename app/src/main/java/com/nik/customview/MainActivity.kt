package com.nik.customview

import android.content.Context
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nik.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            applyButton.setOnClickListener {
                val width = widthEditText.text.toString().toIntOrNull() ?: starView.width
                val height = heightEditText.text.toString().toIntOrNull() ?: starView.height
                val starWidth = starView.width.toFloat() / 3.6234f
                val starHeight =
                    starWidth / starView.getBounds().width() * starView.getBounds()
                        .height()
                val scaleWidth = width / starWidth
                val scaleHeight = height / starHeight
                starView.layoutParams = starView.layoutParams.apply {
                    this.width = width
                    this.height = (scaleWidth.coerceAtMost(scaleHeight) * starHeight).toInt()
                }
            }
        }
    }
}