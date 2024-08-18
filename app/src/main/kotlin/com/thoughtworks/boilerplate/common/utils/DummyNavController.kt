package com.thoughtworks.boilerplate.common.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import java.io.PrintWriter
import java.io.StringWriter

@SuppressLint("StaticFieldLeak")
val sDummyNavController: NavController = DummyNavController(Application())

private class DummyNavController(context: Context) : NavController(context) {

    override fun handleDeepLink(intent: Intent?): Boolean {
        printStackTrace("handleDeepLink")
        return false
    }

    override fun navigate(
        request: NavDeepLinkRequest,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ) {
        printStackTrace("navigate")
    }

    override fun navigate(
        @IdRes resId: Int,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ) {
        printStackTrace("navigate")
    }

    override fun navigateUp(): Boolean {
        printStackTrace("navigateUp")
        return false
    }

    override fun popBackStack(): Boolean {
        printStackTrace("popBackStack")
        return false
    }

    override fun popBackStack(
        destinationId: Int,
        inclusive: Boolean,
        saveState: Boolean
    ): Boolean {
        printStackTrace("popBackStack")
        return false
    }

    companion object {
        private const val TAG = "DummyNavController"

        @Suppress("NOTHING_TO_INLINE")
        private inline fun printStackTrace(methodName: String) {
            val sw = StringWriter()
            Throwable().printStackTrace(PrintWriter(sw))
            Log.e(TAG, "[$methodName] NavController is not ready.\n$sw")
        }
    }
}
