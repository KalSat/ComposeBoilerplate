package com.thoughtworks.boilerplate.common.asyncLoader

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.thoughtworks.boilerplate.ui.theme.BorderShape
import com.thoughtworks.boilerplate.ui.theme.Size

@Composable
fun LoadingPopup(onBackPressed: () -> Unit) {
    Dialog(
        onDismissRequest = onBackPressed,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        ),
    ) {
        LoadingDialogContent()
    }
}

@Composable
fun LoadingDialogContent() {
    Surface(
        Modifier.size(Size.Largest),
        shape = BorderShape.M,
    ) {
        LoadingPlaceholder()
    }
}
