package com.qbutton.dialog

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.util.ui.UIUtil.setEnabled
import java.awt.Color
import java.awt.Cursor
import java.awt.Toolkit
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.Action
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.Border

class FlashlightDialogWrapper : DialogWrapper(false) {

    private lateinit var content: JPanel
    private var flashlightLabel: JLabel? = null

    init {
        init()
        setResizable(false)
        title = "Flashlight"
        addFlashLightListener()
    }

    override fun createSouthPanel() = null

    override fun createContentPaneBorder(): Border? = null

    override fun createActions(): Array<Action> = emptyArray()

    override fun createCenterPanel(): JComponent = content

    fun createUIComponents() {
        content = JPanel().apply {
            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
            preferredSize = Toolkit.getDefaultToolkit().screenSize
        }
    }

    private fun addFlashLightListener() {
        content.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                if (flashlightLabel!!.isEnabled) {
                    setEnabled(flashlightLabel!!, false, false)
                    content.background = Color(60, 63, 65)
                } else {
                    setEnabled(flashlightLabel!!, true, false)
                    content.background = Color.white
                }
            }
        })
    }
}