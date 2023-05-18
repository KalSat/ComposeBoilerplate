package com.thoughtworks.composetemplate.common.asyncLoader

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.thoughtworks.composetemplate.ui.theme.BorderShape

private val LOADING_SIZE = 168.dp

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
        Modifier.size(LOADING_SIZE),
        shape = BorderShape.M,
    ) {
        LoadingPlaceholder()
    }
}
