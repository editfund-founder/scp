package io.github.codehasan.colorpicker.services

object ColorWebhookHelper {
    private const val DEFAULT_BASE_URL = "http://192.168.100.8/api"

    fun buildUrl(x: Int, y: Int, rgb: String): String {
        val normalizedRgb = rgb.replace(" ", "")
        return "$DEFAULT_BASE_URL/$x/$y/$normalizedRgb"
    }

    fun shouldSendUpdate(lastReportedRgb: String?, currentRgb: String): Boolean {
        return lastReportedRgb == null || lastReportedRgb != currentRgb
    }
}
