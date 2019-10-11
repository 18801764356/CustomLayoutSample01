package demo.wj.customlayoutsample.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import demo.wj.customlayoutsample.dip2Px
import kotlin.math.min

/**
 * 作者 ：wangJiang
 * 时间 ：2019/10/11
 * 描述 ：
 */
class CustomCircleView @JvmOverloads constructor(
    ctx: Context,
    attributeSet: AttributeSet? = null,
    style: Int = 0
) : View(ctx, attributeSet, style) {

    private val defaultRadius = dip2Px(50f).toInt()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        var width = 0
        var height = 0

        when (widthMode) {
            MeasureSpec.EXACTLY -> width = widthSize
            MeasureSpec.AT_MOST -> width = defaultRadius
            MeasureSpec.UNSPECIFIED -> width = defaultRadius
        }
        when (heightMode) {
            MeasureSpec.EXACTLY -> height = heightSize
            MeasureSpec.AT_MOST -> height = defaultRadius
            MeasureSpec.UNSPECIFIED -> height = defaultRadius
        }
        width = min(width,height)
        height = min(width,height)
        setMeasuredDimension(width,height)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.YELLOW
        val radius = measuredWidth/2f
        val cx = radius
        val cy = radius
        canvas.drawCircle(cx,cy,radius,paint)
    }

}
