package com.topru.drawio.model.draw

import java.awt.geom.Point2D

class Vector2D(x: kotlin.Double = .0, y: kotlin.Double = .0) : Point2D.Double(x,y) {
    operator fun plus(increment: Vector2D) : Vector2D {
        return Vector2D(x+increment.x, y+increment.y)
    }

    operator fun minus(increment: Vector2D) : Vector2D {
        return Vector2D(x-increment.x, y-increment.y)
    }

    operator fun times(increment: Vector2D) : Vector2D {
        return Vector2D(x*increment.x, y*increment.y)
    }

    fun setMag(m: kotlin.Double) {
        this.normalize()
        this.x*=m
        this.y*=m
    }

    fun mag() : kotlin.Double {
        return Math.pow(Math.pow(x, 2.0) + Math.pow(y , 2.0), 1.0/2.0)
    }

    fun normalize() {
        val mag = this.mag()
        this.x/=mag
        this.y/=mag
    }
}
