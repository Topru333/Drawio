package example.ball

import com.topru.drawio.api.ObjectDrawable
import com.topru.drawio.model.scene.SceneObject
import java.awt.Graphics2D
import java.awt.geom.Rectangle2D

class Border : SceneObject(), ObjectDrawable {
    val rectangle = Rectangle2D.Double(10.0,10.0,950.0,910.0)
    override fun draw(g: Graphics2D) {
        g.draw(rectangle)
    }
}