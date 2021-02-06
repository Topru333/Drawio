package com.topru.drawio.model.scene

open class SceneObject() {

    init {
        start()
    }

    open fun start() {
        println("Created $this")
    }

    open fun update() {

    }
}