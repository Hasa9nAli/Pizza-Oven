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
import pizzaoven.composeapp.generated.resources.Mushroom_1
import pizzaoven.composeapp.generated.resources.Mushroom_2
import pizzaoven.composeapp.generated.resources.Mushroom_3
import pizzaoven.composeapp.generated.resources.Mushroom_4
import pizzaoven.composeapp.generated.resources.Mushroom_5
import pizzaoven.composeapp.generated.resources.Mushroom_6
import pizzaoven.composeapp.generated.resources.Mushroom_7
import pizzaoven.composeapp.generated.resources.Mushroom_8
import pizzaoven.composeapp.generated.resources.Mushroom_9
import pizzaoven.composeapp.generated.resources.Res


@Composable
fun MushroomComponent(
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
            resId = Res.drawable.Mushroom_1,
            targetOffset = 20.dp to (-40).dp,
            startOffset = (-400).dp to (-40).dp,
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
               
        )

        AnimatedImage(
            resId = Res.drawable.Mushroom_2,
            targetOffset = (-40).dp to (-40).dp,
            startOffset = 400.dp to (-40).dp,
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
               
        )

        AnimatedImage(
            resId = Res.drawable.Mushroom_3,
            targetOffset = (-40).dp to 40.dp,
            startOffset = (-415).dp to 40.dp,
            delay = 300,
            animationSpec = animationSpec,
            visible = isSelected,
               
        )

        AnimatedImage(
            resId = Res.drawable.Mushroom_4,
            targetOffset = 50.dp to 20.dp,
            startOffset = (-300).dp to 20.dp,
            delay = 400,
            animationSpec = animationSpec,
            visible = isSelected,
               
        )

        AnimatedImage(
            resId = Res.drawable.Mushroom_5,
            targetOffset = (-50).dp to 10.dp,
            startOffset = (-900).dp to 10.dp,
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
               
        )

        AnimatedImage(
            resId = Res.drawable.Mushroom_6,
            targetOffset = 20.dp to (-40).dp,
            startOffset = (-500).dp to (-40).dp,
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
               
        )

        AnimatedImage(
            resId = Res.drawable.Mushroom_7,
            targetOffset = (-10).dp to 60.dp,
            startOffset = (-950).dp to 60.dp,
            delay = 300,
            animationSpec = animationSpec,
            visible = isSelected,
               
        )

        AnimatedImage(
            resId = Res.drawable.Mushroom_8,
            targetOffset = (-10).dp to (-60).dp,
            startOffset = (-120).dp to (-60).dp,
            delay = 400,
            animationSpec = animationSpec,
            visible = isSelected,
              
        )

        AnimatedImage(
            resId = Res.drawable.Mushroom_9,
            targetOffset = (-20).dp to (-20).dp,
            startOffset = (-120).dp to (-200).dp,
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