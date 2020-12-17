package com.qbutton.flashlight

import com.qbutton.flashlight.ui.FlashlightPanel
import org.junit.Before
import org.junit.Test
import java.awt.Color
import java.awt.event.MouseEvent

class FlashlightPanelTest {

    private var tested: FlashlightPanel = FlashlightPanel()

    @Before
    fun createPanel() {
        tested = FlashlightPanel()
    }

    @Test
    fun flashlightOn() = assertFlashlightOn()

    @Test
    fun flashlightOff() {
        clickOnPanel()
        assertFlashlightOff()
    }

    @Test
    fun flashlightOnAgain() {
        repeat(2) { clickOnPanel() }
        assertFlashlightOn()
    }

    @Test
    fun flashlightOffAgain() {
        repeat(3) { clickOnPanel() }
        assertFlashlightOff()
    }

    private fun assertFlashlightOn() = assert(tested.content.background == Color.white)

    private fun assertFlashlightOff() = assert(tested.content.background == Constants.INTELLIJ_GRAY)

    private fun clickOnPanel() {
        val click = MouseEvent(tested.content, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false)
        tested.content.dispatchEvent(click)
    }
}