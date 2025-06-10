package org.hasan.project.ui.composable.foodComposable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
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

@Composable
private fun AnimatedImage(
    resId: DrawableResource,
    targetOffset: Pair<Dp, Dp>,
    startOffset: Pair<Dp, Dp>,
    delay: Int,
    animationSpec: AnimationSpec<Dp>,
    visible: Boolean,
) {
    val xOffset by animateDpAsState(
        targetValue = if (visible) targetOffset.first else startOffset.first,
        animationSpec = animationSpec,
    )

    val yOffset by animateDpAsState(
        targetValue = if (visible) targetOffset.second else startOffset.second,
        animationSpec = tween(delay)
        )
    val sizeAnimatable = remember { Animatable(100.dp, Dp.VectorConverter) }
    val alphaAnimatable = remember { Animatable(0.8f) }
    LaunchedEffect(Unit) {

            sizeAnimatable.animateTo(
                targetValue = 200.dp,
                animationSpec = tween(durationMillis = 300)
            )

            sizeAnimatable.animateTo(
                targetValue = 24.dp,
                animationSpec = tween(durationMillis = 300)
            )

        alphaAnimatable.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 300)
            )

    }

    Image(
        painter = painterResource(resId),
        contentDescription = null,
        modifier = Modifier
            .size(sizeAnimatable.value)
            .offset(x = xOffset, y = yOffset)
            .alpha(alphaAnimatable.value)
    )
}