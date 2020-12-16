package com.qbutton.action

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.ui.awt.RelativePoint
import com.qbutton.factory.FlashlightPopupFactory
import java.awt.Point

class ShowFlashlightPopupAction : DumbAwareAction() {

    private val pointZero: RelativePoint = RelativePoint(Point(0, 0))

    override fun actionPerformed(event: AnActionEvent) {
        FlashlightPopupFactory.createFlashlightPopup().show(pointZero)
    }
}