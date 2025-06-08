package org.hasan.project

import androidx.compose.ui.window.ComposeUIViewController
import com.hasan.test.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App(
    )
}