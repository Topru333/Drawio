package com.topru.drawio

import com.topru.drawio.api.ObjectControllable
import com.topru.drawio.api.ObjectDrawable
import com.topru.drawio.control.MouseControl
import com.topru.drawio.jframe.Painter
import com.topru.drawio.model.scene.SceneObject
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.MouseEvent
import javax.swing.Timer

class Scene() : ActionListener  {

    private var timer: Timer = Timer(33, this)
    private val objects = mutableListOf<SceneObject>()
    private val mouseEngine = MouseControl()

    val painter = Painter()

    init {
        timer.isRepeats = true
        timer.start()
        painter.addMouseListener(mouseEngine)
        painter.addMouseMotionListener(mouseEngine)
    }

    override fun actionPerformed(e: ActionEvent?) {
        if(e?.source==timer) {
            for (ob in objects) {
                ob.update()
            }
            painter.repaint()
        }
    }

    fun addToScene(ob: SceneObject) {
        if (ob is ObjectControllable) mouseEngine.subscribe { event: MouseEvent -> ob.mouseClicked(event.x, event.y) }
        if (ob is ObjectDrawable) painter.paint(ob)
        this.objects.add(ob)
        println("Object $ob added to scene")
    }

}



