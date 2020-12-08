package com.qbutton.action

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.qbutton.dialog.FlashlightDialogWrapper

class ShowFlashlightDialogAction : DumbAwareAction() {

    override fun actionPerformed(event: AnActionEvent) {
        FlashlightDialogWrapper().show()
    }
}