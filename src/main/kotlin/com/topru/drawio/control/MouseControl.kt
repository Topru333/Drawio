package com.topru.drawio.control

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class MouseControl() : MouseAdapter() {

    private val subscribers = mutableListOf<(MouseEvent) -> Unit>()

    fun subscribe(onClick: (MouseEvent) -> Unit) {
        subscribers.add(onClick)
    }

    override fun mouseReleased(e: MouseEvent) {
        for (ob in subscribers) {
            ob.invoke(e)
        }
    }

    override fun mouseDragged(e: MouseEvent) {
        for (ob in subscribers) {
            ob.invoke(e)
        }
    }

}