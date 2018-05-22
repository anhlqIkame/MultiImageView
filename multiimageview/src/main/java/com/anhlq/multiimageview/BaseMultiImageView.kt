package com.anhlq.multiimageview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.widget.ImageView
import java.util.*


class BaseMultiImageView(context: Context) : ImageView(context) {
    //Shape of view
    var shape = Shape.NONE
        set(value) {
            field = value
            invalidate()
        }

    private val paintDivider = Paint(Paint.ANTI_ALIAS_FLAG)

    var dividerColor = Color.WHITE
        set(value) {
            field = value
            paintDivider.color = value
            invalidate()
        }
    var dividerWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, resources.displayMetrics)
        set(value) {
            field = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)
            invalidate()
        }

    //Corners radius for rectangle shape
    var rectCorners = 100

    init {
        paintDivider.isAntiAlias = true
        paintDivider.color = dividerColor
    }

    private val bitmaps = ArrayList<Bitmap>()
    private val path = Path()
    private val rect = RectF()
    var multiDrawable: Drawable? = null
        get() = field

    /**
     * Add image to view
     */
    fun addImage(bitmap: Bitmap) {
        bitmaps.add(bitmap)
        refresh()
    }

    /**
     * Remove all images
     */
    fun clear() {
        bitmaps.clear()
        refresh()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        refresh()
    }

    /**
     * recreate MultiDrawable and set it as Drawable to ImageView
     */
    private fun refresh() {
        multiDrawable = MultiDrawable(bitmaps, dividerWidth)
        setImageDrawable(multiDrawable)
    }

    override fun onDraw(canvas: Canvas?) {
        if (canvas != null) {
            if (drawable != null) {
                //if shape not set - just draw
                if (shape != Shape.NONE) {
                    path.reset()
                    //ImageView size
                    rect.set(0f, 0f, width.toFloat(), height.toFloat())
                    if (shape == Shape.RECTANGLE) {
                        //Rectangle with corners
                        path.addRoundRect(rect, rectCorners.toFloat(),
                                rectCorners.toFloat(), Path.Direction.CW)
                    } else {
                        //Oval
                        path.addOval(rect, Path.Direction.CW)
                    }
                    //Clip with shape
                    canvas.drawPath(path, paintDivider)
                    canvas.clipPath(path)
                }
                super.onDraw(canvas)
            }
        }
    }

    //Types of shape
    enum class Shape {
        CIRCLE, RECTANGLE, NONE
    }
}