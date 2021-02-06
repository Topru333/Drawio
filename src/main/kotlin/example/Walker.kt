package example

import com.topru.drawio.api.ObjectDrawable
import com.topru.drawio.api.ObjectControllable
import com.topru.drawio.model.draw.Ellipse
import com.topru.drawio.model.scene.SceneObject
import com.topru.drawio.model.draw.Vector2D
import java.awt.Graphics2D
import kotlin.random.Random

class Walker(var position: Vector2D, var size: Vector2D) : SceneObject(), ObjectControllable, ObjectDrawable {

    private var vel = Vector2D(Random.nextDouble(-5.0,5.1), Random.nextDouble(-5.0,5.1))
    private var center: Vector2D = Vector2D(position.x - 40, position.y - 40)

    override fun update() {
        position+=vel
        var acc = center-position
        acc.setMag(0.1)
        vel+=acc

    }

    override fun draw(g: Graphics2D) {
        g.draw(Ellipse(Vector2D(position.x-size.x/2, position.y-size.y/2), Vector2D(size.x, size.y)))
        g.fillOval(center.x.toInt(),center.y.toInt(),6,6)
    }


    override fun mouseClicked(x: Int, y: Int) {
        center = Vector2D(x.toDouble(), y.toDouble())
    }

}