package com.nik.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.graphics.Path

import androidx.appcompat.widget.AppCompatButton

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
     val path = Path()
    private val bounds = RectF()


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

    fun getBounds(): RectF {
        path.computeBounds(bounds, true)
        return bounds
    }


    private fun drawFirstAzov(color: Int, canvas: Canvas) {
        val scaleFactor = width / 600f

        paint.shader = LinearGradient(
            0f, 0f, 0f,
            height.toFloat(),
            color,
            Color.WHITE,
            Shader.TileMode.MIRROR
        )

        path.reset()
        path.moveTo(75f * scaleFactor, 0f)
        path.lineTo(75f * scaleFactor, 367f * scaleFactor)
        path.lineTo(96f * scaleFactor, 367f * scaleFactor)
        path.lineTo(96f * scaleFactor, 291f * scaleFactor)
        path.lineTo(124f * scaleFactor, 306f * scaleFactor)
        path.lineTo(124f * scaleFactor, 439f * scaleFactor)
        path.lineTo(170f * scaleFactor, 471f * scaleFactor)
        path.lineTo(170f * scaleFactor, 327f * scaleFactor)
        path.lineTo(236f * scaleFactor, 367f * scaleFactor)
        path.lineTo(236f * scaleFactor, 223f * scaleFactor)
        path.lineTo(209f * scaleFactor, 223f * scaleFactor)
        path.lineTo(209f * scaleFactor, 280f * scaleFactor)
        path.lineTo(175f * scaleFactor, 257f * scaleFactor)
        path.lineTo(175f * scaleFactor, 133f * scaleFactor)
        path.lineTo(124f * scaleFactor, 117f * scaleFactor)
        path.lineTo(124f * scaleFactor, 233f * scaleFactor)
        path.lineTo(75f * scaleFactor, 200f * scaleFactor)

        path.close()
        canvas.drawPath(path, paint)
    }
}
