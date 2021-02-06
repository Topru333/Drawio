package com.topru.drawio.model.draw

import java.awt.geom.Ellipse2D

class Ellipse(position: Vector2D, size: Vector2D) : Ellipse2D.Double(position.x, position.y, size.x, size.y)