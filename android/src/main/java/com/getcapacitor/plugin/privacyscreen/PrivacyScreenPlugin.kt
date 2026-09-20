package com.getcapacitor.plugin.privacyscreen

import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "PrivacyScreen")
public class PrivacyScreenPlugin : Plugin() {
    private lateinit var implementation: PrivacyScreen

    override fun load() {
        implementation = PrivacyScreen(this, getPrivacyScreenConfig())
    }

    @PluginMethod
    public fun enable(call: PluginCall) {
        implementation.enable { call.resolve() }
    }

    @PluginMethod
    public fun disable(call: PluginCall) {
        implementation.disable { call.resolve() }
    }

    private fun getPrivacyScreenConfig(): PrivacyScreenConfig {
        val privacyScreenConfig = PrivacyScreenConfig()
        privacyScreenConfig.isEnabled = config.getBoolean("enable", privacyScreenConfig.isEnabled)
        return privacyScreenConfig
    }
}
