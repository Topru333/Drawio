package com.topru.drawio.api

import java.awt.Graphics2D

interface ObjectDrawable {
    fun draw(g: Graphics2D)
}