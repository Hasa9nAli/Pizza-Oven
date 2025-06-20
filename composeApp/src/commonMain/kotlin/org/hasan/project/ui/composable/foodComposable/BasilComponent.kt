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
import pizzaoven.composeapp.generated.resources.Basil_1
import pizzaoven.composeapp.generated.resources.Basil_2
import pizzaoven.composeapp.generated.resources.Basil_3
import pizzaoven.composeapp.generated.resources.Basil_4
import pizzaoven.composeapp.generated.resources.Basil_5
import pizzaoven.composeapp.generated.resources.Basil_6
import pizzaoven.composeapp.generated.resources.Basil_7
import pizzaoven.composeapp.generated.resources.Basil_8
import pizzaoven.composeapp.generated.resources.Basil_9
import pizzaoven.composeapp.generated.resources.Res

@Composable
fun BasilComponent(
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
            resId = Res.drawable.Basil_1,
            targetOffset = 10.dp to -30.dp,
            startOffset = 0.dp to -30.dp,
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Basil_2,
            targetOffset = (-50).dp to (-30).dp,
            startOffset = (0).dp to (-30).dp,
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Basil_3,
            targetOffset = (-30).dp to 10.dp,
            startOffset = (0).dp to 10.dp,
            delay = 300,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Basil_4,
            targetOffset = 40.dp to 50.dp,
            startOffset = (0).dp to 50.dp,
            delay = 400,
            animationSpec = animationSpec,
            visible = isSelected,

        )

        AnimatedImage(
            resId = Res.drawable.Basil_5,
            targetOffset = 15.dp to (-10).dp,
            startOffset = 0.dp to (-10).dp,
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,

        )

        AnimatedImage(
            resId = Res.drawable.Basil_6,
            targetOffset = (-40).dp to (-10).dp,
            startOffset = 0.dp to (-10).dp,
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,

        )

        AnimatedImage(
            resId = Res.drawable.Basil_7,
            targetOffset = 25.dp to 15.dp,
            startOffset = 0.dp to 15.dp,
            delay = 300,
            animationSpec = animationSpec,
            visible = isSelected,

        )

        AnimatedImage(
            resId = Res.drawable.Basil_8,
            targetOffset = (-10).dp to 60.dp,
            startOffset = 0.dp to 60.dp,
            delay = 400,
            animationSpec = animationSpec,
            visible = isSelected,

        )

        AnimatedImage(
            resId = Res.drawable.Basil_9,
            targetOffset = (-15).dp to (-50).dp,
            startOffset = (-15).dp to (-200).dp,
            delay = 500,
            animationSpec = animationSpec,
            visible = isSelected,

        )
    }
}

