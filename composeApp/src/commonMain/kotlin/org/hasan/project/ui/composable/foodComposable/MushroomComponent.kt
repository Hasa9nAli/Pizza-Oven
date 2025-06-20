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
import org.hasan.project.ui.theme.xLargeUnit
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
    data class Mushroom(
        val resId: DrawableResource,
        val targetOffset: Pair<Dp, Dp>,
        val startOffset: Pair<Dp, Dp>,
        val delay: Int
    )

    val listOfMushroom = listOf(
        Mushroom(Res.drawable.Mushroom_1, 20.dp to (-40).dp, (-400).dp to (-40).dp, 100),
        Mushroom(Res.drawable.Mushroom_2, (-40).dp to (-40).dp, 400.dp to (-40).dp, 200),
        Mushroom(Res.drawable.Mushroom_3, (-40).dp to 40.dp, (-415).dp to 40.dp, 300),
        Mushroom(Res.drawable.Mushroom_4, 50.dp to 20.dp, (-300).dp to 20.dp, 400),
        Mushroom(Res.drawable.Mushroom_5, (-50).dp to 10.dp, (-900).dp to 10.dp, 100),
        Mushroom(Res.drawable.Mushroom_6, 20.dp to (-40).dp, (-500).dp to (-40).dp, 200),
        Mushroom(Res.drawable.Mushroom_7, (-10).dp to 60.dp, (-950).dp to 60.dp, 300),
        Mushroom(Res.drawable.Mushroom_8, (-10).dp to (-60).dp, (-120).dp to (-60).dp, 400),
        Mushroom(Res.drawable.Mushroom_9, (-20).dp to (-20).dp, (-120).dp to (-200).dp, 500)
    )
    val animationSpec = spring<Dp>(
        dampingRatio = 0.5f,
        stiffness = 100f
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        listOfMushroom.forEach {
            AnimatedImage(
                resId = it.resId,
                targetOffset = it.targetOffset,
                startOffset = it.startOffset,
                delay = it.delay,
                animationSpec = animationSpec,
                visible = isSelected,
            )
        }
    }
}

@Composable
fun AnimatedImage(
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
    val sizeAnimatable = remember { Animatable(200.dp, Dp.VectorConverter) }
    val alphaAnimatable = remember { Animatable(0.8f) }
    LaunchedEffect(Unit) {

        sizeAnimatable.animateTo(
            targetValue = 200.dp,
            animationSpec = tween(durationMillis = 100)
        )
        sizeAnimatable.animateTo(
            targetValue = xLargeUnit,
            animationSpec = tween(durationMillis = 110)
        )
        alphaAnimatable.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 110)
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