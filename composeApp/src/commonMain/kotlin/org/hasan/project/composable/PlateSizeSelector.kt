package org.hasan.project.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hasan.test.ui.composable.boxes.BlurryTextBox
import org.hasan.project.screen.Plate

@Composable
fun PlateSizeSelector(
    modifier: Modifier = Modifier,
    selectedSize: Plate,
    onSizeSelected: (Plate) -> Unit,
    verticalPadding: Dp = 24.dp
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = verticalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        BlurryTextBox(
            text = "S",
            isClicked = selectedSize == Plate.SMALL,
            onClick = { onSizeSelected(Plate.SMALL) }
        )
        BlurryTextBox(
            text = "M",
            isClicked = selectedSize == Plate.MEDIUM,
            onClick = { onSizeSelected(Plate.MEDIUM) }
        )
        BlurryTextBox(
            text = "L",
            isClicked = selectedSize == Plate.LARGE,
            onClick = { onSizeSelected(Plate.LARGE) }
        )
    }
}
