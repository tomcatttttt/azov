package com.nik.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton

class StarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : AppCompatButton(context, attrs) {
    private var yellowColor = Color.YELLOW
    private var blackColor = Color.BLACK

    var counter = 1

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        Log.d("Tag", "huy")
    }

    private var paint: Paint = Paint(Paint.FILTER_BITMAP_FLAG)
    private var path: Path = Path()

    init {
        findViewById<StarView>(R.id.starView).setOnClickListener(View.OnClickListener {
            when (counter) {
                1 -> { Log.d("ebat", "click 1") }

                2 -> { Log.d("ebat", "click 2") }

                3 -> { Log.d("ebat", "click 3") }

                else -> { counter = 0
                    paint.color = blackColor }
            }
            counter++
        })
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        drawFirstAzov(canvas)
        drawSecondAzov(canvas)
        drawThirdAzov(canvas)
    }

    private fun drawFirstAzov(canvas: Canvas)  {
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
        paint.color = blackColor
        canvas.drawPath(path, paint)
        invalidate()
    }

    private fun drawSecondAzov(canvas: Canvas) {
        canvas.save()
        canvas.translate(width.toFloat() / 3.6234f, 0f)
        drawFirstAzov(canvas)
        canvas.restore()
    }

    private fun drawThirdAzov(canvas: Canvas) {
        canvas.save()
        canvas.translate(width.toFloat() / 1.80847f, 0f)
        drawFirstAzov(canvas)
        canvas.restore()
    }
}

