package com.nik.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import kotlin.math.sin
import android.view.View
import kotlin.math.cos
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat

class StarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatButton(context, attrs) {

    private val yellow = Color.YELLOW
    private val black = Color.BLACK
    private var counter = 0
    private var firstStarColor = black
    private var secondStarColor = black
    private var thirdStarColor = black
    private val paint = Paint(Paint.FILTER_BITMAP_FLAG)
    private val path = Path()

    init {
        setOnClickListener {
            counter++
            when (counter % 4) {
                1 -> {
                    firstStarColor = yellow
                    secondStarColor = black
                    thirdStarColor = black
                    invalidate()
                }
                2 -> {
                    firstStarColor = yellow
                    secondStarColor = yellow
                    thirdStarColor = black
                    invalidate()
                }
                3 -> {
                    firstStarColor = yellow
                    secondStarColor = yellow
                    thirdStarColor = yellow
                    invalidate()
                }
                0 -> {
                    firstStarColor = black
                    secondStarColor = black
                    thirdStarColor = black
                    invalidate()
                }
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            drawFirstAzov(firstStarColor, it)
            it.save()
            it.translate(width.toFloat() / 3.6234f, 0f)
            drawFirstAzov(secondStarColor, it)
            it.restore()
            it.save()
            it.translate(width.toFloat() / 1.80847f, 0f)
            drawFirstAzov(thirdStarColor, it)
            it.restore()
        }
    }

    private fun drawFirstAzov(color: Int, canvas: Canvas) {
        paint.shader = LinearGradient(
            0f, 0f, 0f,
            height.toFloat(),
            color,
            Color.WHITE,
            Shader.TileMode.MIRROR
        )

        path.moveTo(width.toFloat() / 7.4f, 0f)
        path.lineTo(width.toFloat() / 7.4f, 367f)
        path.lineTo(width.toFloat() / 5.6f, 367f)
        path.lineTo(width.toFloat() / 5.6f, 291f)
        path.lineTo(width.toFloat() / 4.45f, 306f)
        path.lineTo(width.toFloat() / 4.45f, 439f)
        path.lineTo(width.toFloat() / 3.45f, 471f)
        path.lineTo(width.toFloat() / 3.45f, 327f)
        path.lineTo(width.toFloat() / 2.49f, 367f)
        path.lineTo(width.toFloat() / 2.49f, 223f)
        path.lineTo(width.toFloat() / 2.8117f, 223f)
        path.lineTo(width.toFloat() / 2.8117f, 280f)
        path.lineTo(width.toFloat() / 3.4f, 257f)
        path.lineTo(width.toFloat() / 3.4f, 133f)
        path.lineTo(width.toFloat() / 4.45f, 117f)
        path.lineTo(width.toFloat() / 4.45f, 233f)
        path.lineTo(width.toFloat() / 7.4f, 200f)

        path.close()
        canvas.drawPath(path, paint)
    }
}
