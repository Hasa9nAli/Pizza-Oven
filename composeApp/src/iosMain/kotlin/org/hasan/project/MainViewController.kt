package org.hasan.project

import androidx.compose.ui.window.ComposeUIViewController
import org.hasan.project.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App(
    )
}