package com.qbutton.ui

import Constants
import com.intellij.util.ui.UIUtil.setEnabled
import java.awt.Color
import java.awt.Cursor
import java.awt.Toolkit
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JLabel
import javax.swing.JPanel

class FlashlightPanel {

    lateinit var content: JPanel
    private var flashlightLabel: JLabel? = null

    init {
        addFlashLightListener()
    }

    fun createUIComponents() {
        content = JPanel().apply {
            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
            preferredSize = Toolkit.getDefaultToolkit().screenSize
        }
    }

    fun resetState(): Boolean {
        setEnabled(flashlightLabel!!, true, false)
        content.background = Color.white

        return true
    }

    private fun addFlashLightListener() {
        content.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                if (flashlightLabel!!.isEnabled) {
                    darken()
                } else {
                    resetState()
                }
            }
        })
    }

    private fun darken() {
        setEnabled(flashlightLabel!!, false, false)
        content.background = Constants.INTELLIJ_GRAY
    }
}