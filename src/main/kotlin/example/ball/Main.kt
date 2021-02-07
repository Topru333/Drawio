package example.ball

import com.topru.drawio.Scene
import com.topru.drawio.jframe.Frame
import com.topru.drawio.model.forms.Vector2D

fun main(args: Array<String>) {
    val width = 1000
    val height = 1000
    val scene: Scene = Scene()
    val frame: Frame = Frame(width,height);
    frame.add(scene.painter)
    val border = Border()
    val ball = Ball(Vector2D(width / 2.0, height / 2.0),border)
    scene.addToScene(ball)
    scene.addToScene(border)
}