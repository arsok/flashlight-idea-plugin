package com.qbutton.flashlight.ui

import com.intellij.util.ui.UIUtil.setEnabled
import com.qbutton.flashlight.Constants.INTELLIJ_GRAY
import java.awt.Color
import java.awt.Cursor
import java.awt.Toolkit
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JLabel
import javax.swing.JPanel

class FlashlightPanel {

    private var flashlightLabel: JLabel? = null

    lateinit var content: JPanel

    init {
        addFlashLightListener()
    }

    fun createUIComponents() {
        content = JPanel().apply {
            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
            preferredSize = Toolkit.getDefaultToolkit().screenSize
            background = INTELLIJ_GRAY
        }
    }

    fun darken(): Boolean {
        setEnabled(flashlightLabel!!, false, false)
        content.background = INTELLIJ_GRAY

        return true
    }

    private fun addFlashLightListener() {
        content.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                if (flashlightLabel!!.isEnabled) {
                    darken()
                } else {
                    lighten()
                }
            }
        })
    }

    private fun lighten() {
        setEnabled(flashlightLabel!!, true, false)
        content.background = Color.white
    }
}