package com.getcapacitor.plugin.privacyscreen

import android.view.WindowManager

public class PrivacyScreen(private val plugin: PrivacyScreenPlugin, config: PrivacyScreenConfig) {
    init {
        if (config.isEnabled) {
            addFlags()
        }
    }

    public fun enable(callback: EnableCallback) {
        plugin.bridge.executeOnMainThread {
            addFlags()
            callback.success()
        }
    }

    public fun disable(callback: DisableCallback) {
        plugin.bridge.executeOnMainThread {
            clearFlags()
            callback.success()
        }
    }

    private fun addFlags() {
        plugin.activity.window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }

    private fun clearFlags() {
        plugin.activity.window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }
}
