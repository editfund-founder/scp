package io.github.codehasan.colorpicker.services

import java.io.File
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ColorWebhookHelperTest {
    @Test
    fun buildUrl_formatsPathCorrectly() {
        val url = ColorWebhookHelper.buildUrl(x = 120, y = 240, rgb = "255,128,64")
        assertEquals("http://192.168.100.8/api/120/240/255,128,64", url)
    }

    @Test
    fun shouldSendUpdate_returnsTrueWhenColorChanges() {
        assertTrue(ColorWebhookHelper.shouldSendUpdate(null, "255,128,64"))
        assertTrue(ColorWebhookHelper.shouldSendUpdate("255,128,64", "10,20,30"))
    }

    @Test
    fun manifest_allowsCleartextTrafficForWebhook() {
        val manifestPath = File("app/src/main/AndroidManifest.xml")
        val manifestText = manifestPath.readText()

        assertTrue(
            manifestText.contains("android:usesCleartextTraffic=\"true\"") ||
                manifestText.contains("android:networkSecurityConfig")
        )
    }
}
