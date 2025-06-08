package com.hasan.test.ui.composable.foodComposable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.hasan.project.theme.largeUnit
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import pizzaoven.composeapp.generated.resources.Res
import pizzaoven.composeapp.generated.resources.Sausage_1
import pizzaoven.composeapp.generated.resources.Sausage_2
import pizzaoven.composeapp.generated.resources.Sausage_3
import pizzaoven.composeapp.generated.resources.Sausage_4
import pizzaoven.composeapp.generated.resources.Sausage_5
import pizzaoven.composeapp.generated.resources.Sausage_6
import pizzaoven.composeapp.generated.resources.Sausage_7
import pizzaoven.composeapp.generated.resources.Sausage_8
import pizzaoven.composeapp.generated.resources.Sausage_9
import kotlin.random.Random


@Composable
fun SausageComponent(
    isSelected: Boolean = true,
    onSelect: () -> Unit = {}
) {
    // Trigger animation on composition
    LaunchedEffect(Unit) {
        onSelect()
    }

    // Common animation spec with slightly bouncier parameters for sausages
    val animationSpec = spring<Dp>(
        dampingRatio = 0.4f,  // Less damping for more bounce
        stiffness = 80f       // Softer stiffness for sausage-like movement
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        // First group of images with staggered animation
        AnimatedImage(
            resId = Res.drawable.Sausage_1,
            targetOffset = 30.dp to -65.dp,
            startOffset = 30.dp to (-200).dp,  // Comes from top
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
            size = largeUnit
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_2,
            targetOffset = -15.dp to -10.dp,
            startOffset = (-200).dp to -10.dp,  // Comes from left
            delay = 150,
            animationSpec = animationSpec,
            visible = isSelected,
            size = largeUnit
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_3,
            targetOffset = 10.dp to 40.dp,
            startOffset = 10.dp to 200.dp,     // Comes from bottom
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
            size = largeUnit
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_4,
            targetOffset = 50.dp to 20.dp,
            startOffset = 200.dp to 20.dp,    // Comes from right
            delay = 250,
            animationSpec = animationSpec,
            visible = isSelected,
            size = largeUnit
        )

        // Second group with different entry points
        AnimatedImage(
            resId = Res.drawable.Sausage_5,
            targetOffset = -50.dp to 10.dp,
            startOffset = -200.dp to 10.dp,    // Comes from left
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
            size = largeUnit
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_6,
            targetOffset = 20.dp to -40.dp,
            startOffset = 20.dp to (-200).dp,  // Comes from top
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
            size = largeUnit
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_7,
            targetOffset = -40.dp to -55.dp,
            startOffset = -40.dp to 200.dp,    // Comes from bottom
            delay = 300,
            animationSpec = animationSpec,
            visible = isSelected,
            size = largeUnit
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_8,
            targetOffset = -10.dp to 60.dp,
            startOffset = 200.dp to 60.dp,    // Comes from right
            delay = 400,
            animationSpec = animationSpec,
            visible = isSelected,
            size = largeUnit
        )

        // Center piece with special animation
        AnimatedImage(
            resId = Res.drawable.Sausage_9,
            targetOffset = 60.dp to 0.dp,
            startOffset = (-200).dp to 0.dp,   // Comes from left with extra distance
            delay = 500,
            animationSpec = spring(
                dampingRatio = 0.3f,
                stiffness = 50f
            ),  // Extra bouncy for the main sausage
            visible = isSelected,
            size = largeUnit * 1.2f  // Slightly larger
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
    size: Dp
) {
    val xOffset by animateDpAsState(
        targetValue = if (visible) targetOffset.first else startOffset.first,
        animationSpec = animationSpec,
        finishedListener = { /* Optional completion callback */ }
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
            targetValue = size,
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
