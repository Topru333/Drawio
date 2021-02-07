package com.topru.drawio.api

import com.topru.drawio.model.forms.Vector2D

interface ObjectPhysics {
    fun applyForce(vector: Vector2D)
}