package org.hasan.project.ui.composable.foodComposable

import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pizzaoven.composeapp.generated.resources.Onion_1
import pizzaoven.composeapp.generated.resources.Onion_2
import pizzaoven.composeapp.generated.resources.Onion_3
import pizzaoven.composeapp.generated.resources.Onion_4
import pizzaoven.composeapp.generated.resources.Onion_5
import pizzaoven.composeapp.generated.resources.Onion_6
import pizzaoven.composeapp.generated.resources.Onion_7
import pizzaoven.composeapp.generated.resources.Onion_8
import pizzaoven.composeapp.generated.resources.Onion_9
import pizzaoven.composeapp.generated.resources.Res


@Composable
fun OnionComponent(
    isSelected: Boolean = true,
    onSelect: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        onSelect()
    }

    val animationSpec = spring<Dp>(
        dampingRatio = 0.5f,
        stiffness = 100f
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        AnimatedImage(
            resId = Res.drawable.Onion_1,
            targetOffset = 25.dp to (-25).dp,
            startOffset = 0.dp to (-25).dp,
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Onion_2,
            targetOffset = 0.dp to 0.dp,
            startOffset = 0.dp to 0.dp,
            delay = 150,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Onion_3,
            targetOffset = 10.dp to 40.dp,
            startOffset = 0.dp to 40.dp,
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Onion_4,
            targetOffset = 50.dp to 20.dp,
            startOffset = 0.dp to 20.dp,
            delay = 250,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Onion_5,
            targetOffset = (-50).dp to 10.dp,
            startOffset = 0.dp to 10.dp,
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Onion_6,
            targetOffset = 20.dp to -40.dp,
            startOffset = 0.dp to -40.dp,
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Onion_7,
            targetOffset = (-40).dp to (-55).dp,
            startOffset = 0.dp to (-55).dp,
            delay = 300,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Onion_8,
            targetOffset = (-10).dp to 60.dp,
            startOffset = 0.dp to 60.dp,
            delay = 400,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Onion_9,
            targetOffset = 60.dp to 0.dp,
            startOffset = 60.dp to (-150).dp,
            delay = 500,
            animationSpec = animationSpec,
            visible = isSelected,
        )
    }
}
