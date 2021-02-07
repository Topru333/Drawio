package com.topru.drawio.control

import com.topru.drawio.model.forms.Vector2D
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

object MouseControl : MouseAdapter() {
    var mouseClicked: Boolean = false
    var mousePosition: Vector2D = Vector2D()


    override fun mouseReleased(e: MouseEvent) {
        mouseClicked = false
    }

    override fun mousePressed(e: MouseEvent) {
        mousePosition = Vector2D(e.x.toDouble(), e.y.toDouble())
        mouseClicked = true
    }

    override fun mouseDragged(e: MouseEvent) {
        mousePosition = Vector2D(e.x.toDouble(), e.y.toDouble())
    }
}