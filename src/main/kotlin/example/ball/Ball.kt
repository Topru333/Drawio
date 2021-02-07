package example.ball

import com.topru.drawio.api.ObjectDrawable
import com.topru.drawio.api.ObjectPhysics
import com.topru.drawio.control.MouseControl
import com.topru.drawio.model.forms.Ellipse
import com.topru.drawio.model.forms.Vector2D
import com.topru.drawio.model.scene.SceneObject
import java.awt.Graphics2D

class Ball(position: Vector2D, val border: Border) : SceneObject(), ObjectPhysics, ObjectDrawable {

    private var vel = Vector2D()
    private var acc = Vector2D()
    private val ellipse: Ellipse = Ellipse(Vector2D(position.x, position.y), Vector2D(30.0, 30.0))

    override fun draw(g: Graphics2D) {
        g.draw(ellipse)
    }

    override fun applyForce(force: Vector2D) {
        this.acc+=force
    }

    override fun update() {
        if (MouseControl.mouseClicked) {
            applyForce(Vector2D(.2, .0))
        }
        vel+=acc
        edges()
        ellipse.position+=vel
        acc = Vector2D()
    }

    private fun edges() {
        if (ellipse.position.y + ellipse.height > border.rectangle.height + border.rectangle.y && this.vel.y > 0) {
            ellipse.position.y = border.rectangle.height + border.rectangle.y - ellipse.height
            this.vel.y *= -0.9
        }
        if(ellipse.position.x + ellipse.width >  border.rectangle.width + border.rectangle.x && this.vel.x > 0) {
            ellipse.position.x = border.rectangle.width + border.rectangle.x - ellipse.width
            this.vel.x *= -0.9
        }
        if(ellipse.position.x < border.rectangle.x && this.vel.x < 0) {
            ellipse.position.x = border.rectangle.x
            this.vel.x *= -0.9
        }
    }
}