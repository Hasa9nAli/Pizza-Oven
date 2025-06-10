package org.hasan.project.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import org.hasan.project.ui.screen.Plate
import org.hasan.project.ui.theme.mediumFontSize

@Composable
fun PlateSizeSelector(
    modifier: Modifier = Modifier,
    selectedSize: Plate,
    onSizeSelected: (Plate) -> Unit,
    verticalPadding: Dp = 24.dp
) {
    val selectedIndex = when (selectedSize) {
        Plate.SMALL -> 0
        Plate.MEDIUM -> 1
        Plate.LARGE -> 2
    }

    val animatedPosition by animateFloatAsState(
        targetValue = selectedIndex.toFloat(),
        animationSpec = tween(durationMillis = 300),
        label = "backgroundAnimation"
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = verticalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .height(48.dp)
        ) {
            Card (
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .offset(x = animatedPosition * 48.dp)
                    .padding(4.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(100)
                    ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 8.dp,
                    hoveredElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(100)
            ){}

            Row {
                PlateOption("S", selectedSize == Plate.SMALL) { onSizeSelected(Plate.SMALL) }
                PlateOption("M", selectedSize == Plate.MEDIUM) { onSizeSelected(Plate.MEDIUM) }
                PlateOption("L", selectedSize == Plate.LARGE) { onSizeSelected(Plate.LARGE) }
            }
        }
    }
}

@Composable
private fun PlateOption(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clickable (interactionSource = remember{ MutableInteractionSource() }, indication = null){
                onClick()
            }

        ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) MaterialTheme.colorScheme.onPrimary
            else MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.titleMedium,
            fontSize = mediumFontSize,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}
