package org.hasan.project.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.hasan.project.ui.theme.mediumUnit
import org.hasan.project.ui.theme.smallUnit
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun FoodClickableBox(
     image : DrawableResource,
    isSelected: Boolean, onClick: ()-> Unit
){
    Box(
        modifier = Modifier
            .padding(end = mediumUnit)
            .size(64.dp)
            .background(
                color = if (isSelected) Color(0xFFD7FDD7) else Color(0x4DD7FDD7),
                shape = RoundedCornerShape(100)
            )
            .padding(smallUnit)
            .clickable(
                indication = null, interactionSource = remember { MutableInteractionSource() }) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(image), null)
    }
}