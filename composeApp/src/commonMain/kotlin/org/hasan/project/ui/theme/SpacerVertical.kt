package org.hasan.project.ui.theme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SpacerVerticalSmall(){
    Spacer(modifier = Modifier.height(smallUnit))
}

@Composable
fun SpacerVerticalMedium(){
    Spacer(modifier = Modifier.height(mediumUnit))
}
