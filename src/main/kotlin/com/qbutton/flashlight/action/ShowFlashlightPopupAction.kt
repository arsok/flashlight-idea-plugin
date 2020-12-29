package com.qbutton.flashlight.action

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.qbutton.flashlight.Constants
import com.qbutton.flashlight.factory.FlashlightPopupFactory

class ShowFlashlightPopupAction : DumbAwareAction() {

    override fun actionPerformed(event: AnActionEvent) {
        FlashlightPopupFactory.createFlashlightPopup().show(Constants.POINT_ZERO)
    }
}