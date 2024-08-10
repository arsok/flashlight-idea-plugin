package com.qbutton.flashlight.factory

import com.intellij.icons.AllIcons
import com.intellij.openapi.ui.popup.*
import com.qbutton.flashlight.Constants
import com.qbutton.flashlight.ui.FlashlightPanel


object FlashlightPopupFactory {

    private val flashlightPanel = FlashlightPanel()
    private val titleIcon = ActiveIcon(AllIcons.Actions.IntentionBulb)
    private val cancelButton = IconButton(Constants.CLOSE_TOOLTIP, AllIcons.Actions.Cancel)
    private val popupBuilder = createFlashlightPopupBuilder()

    fun createFlashlightPopup(): JBPopup {
        return popupBuilder.createPopup()
    }

    private fun createFlashlightPopupBuilder(): ComponentPopupBuilder {
        return JBPopupFactory.getInstance().createComponentPopupBuilder(flashlightPanel.content, null)
            .setTitle(Constants.POPUP_TITLE)
            .setTitleIcon(titleIcon)
            .setCancelButton(cancelButton)
            .setCancelCallback(flashlightPanel::darken)
            .setCancelKeyEnabled(true)
            .setCancelOnClickOutside(true)
            .setRequestFocus(true)
    }
}