package com.hasan.test.ui.composable.boxes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BlurryTextBox(
    text: String,
    isClicked: Boolean = true,
    onClick: () -> Unit,
) {

        Box(
            modifier = Modifier
                .then(
                    if (isClicked) Modifier.shadow(
                        12.dp,
                        shape = CircleShape,
                        clip = false
                    ) else Modifier.shadow(0.dp)
                )
                .background(
                    if (isClicked) Color.White else Color.Transparent,
                    CircleShape
                )
                .size(36.dp)

                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }) {
                    onClick()
                }
            ,
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = text,
                color = if (isClicked) Color(0xFF121212) else Color(0xCC121212)
            )
        }

}
