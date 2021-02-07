package com.topru.drawio.model.forms

import java.awt.geom.Ellipse2D

class Ellipse(position: Vector2D, size: Vector2D) : Ellipse2D.Double(position.x, position.y, size.x, size.y) {
    var position: Vector2D
        get() {return Vector2D(x,y)}
        set(pos: Vector2D) {
            this.x = pos.x
            this.y = pos.y
        }
}