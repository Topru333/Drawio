package com.topru.drawio.jframe

import com.topru.drawio.api.ObjectDrawable
import java.awt.Component
import java.awt.Graphics
import java.awt.Graphics2D

class Painter() : Component()  {
    private val toPaint = mutableListOf<ObjectDrawable>()

    fun paint(obj: ObjectDrawable) {
        toPaint.add(obj)
    }

    override fun paint(g: Graphics?) {
        super.paint(g)
        toPaint.forEach {
            it.draw(g as Graphics2D)
        }
    }

}