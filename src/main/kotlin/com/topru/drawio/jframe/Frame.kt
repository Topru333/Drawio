package com.topru.drawio.jframe

import java.awt.GridLayout
import javax.swing.JFrame

class Frame(width: Int, height: Int) : JFrame() {

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(width, height)
        isResizable = false
        title = "Graphics"

        setLocationRelativeTo(null)
        layout = GridLayout(1, 1, 0, 0)
        isVisible = true
    }
}