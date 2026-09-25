package com.getcapacitor.plugin.privacyscreen

import android.os.Looper
import android.view.WindowManager

public class PrivacyScreen(private val plugin: PrivacyScreenPlugin, config: PrivacyScreenConfig) {
    init {
        if (config.isEnabled) {
            addFlags()
        }
    }

    public fun enable(callback: EnableCallback) {
        onMainThread {
            addFlags()
            callback.success()
        }
    }

    public fun disable(callback: DisableCallback) {
        onMainThread {
            clearFlags()
            callback.success()
        }
    }

    /**
     * Runs [block] right away on the main thread, and posts it to the main thread from any other thread.
     * PrivacyScreenPlugin calls from the main thread, so what changing the window throws rejects its call.
     */
    private inline fun onMainThread(crossinline block: () -> Unit) {
        if (Looper.getMainLooper().isCurrentThread) {
            block()
        } else {
            plugin.bridge.executeOnMainThread { block() }
        }
    }

    private fun addFlags() {
        plugin.activity.window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }

    private fun clearFlags() {
        plugin.activity.window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }
}
