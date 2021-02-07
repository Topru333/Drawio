package com.topru.drawio

import com.topru.drawio.api.ObjectDrawable
import com.topru.drawio.api.ObjectPhysics
import com.topru.drawio.control.MouseControl
import com.topru.drawio.jframe.Painter
import com.topru.drawio.model.forms.Vector2D
import com.topru.drawio.model.scene.SceneObject
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer

class Scene() : ActionListener  {

    private var timer: Timer = Timer(33, this)
    private val objects = mutableListOf<SceneObject>()
    private val physics = mutableListOf<ObjectPhysics>()
    private val gravity = Vector2D(y = 0.5)
    val painter = Painter()

    init {
        timer.isRepeats = true
        timer.start()
        painter.addMouseListener(MouseControl)
        painter.addMouseMotionListener(MouseControl)
    }

    override fun actionPerformed(e: ActionEvent?) {
        if(e?.source==timer) {
            objects.forEach { it.update() }
            physics.forEach { it.applyForce(gravity) }
            painter.repaint()
        }
    }

    fun addToScene(ob: SceneObject) {
        if (ob is ObjectDrawable) painter.paint(ob)
        if (ob is ObjectPhysics) physics.add(ob)
        this.objects.add(ob)
        println("Object $ob added to scene")
    }

}



