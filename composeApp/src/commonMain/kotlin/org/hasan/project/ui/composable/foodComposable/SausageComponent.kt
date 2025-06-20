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


@Composable
fun SausageComponent(
    isSelected: Boolean = true,
    onSelect: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        onSelect()
    }

    val animationSpec = spring<Dp>(
        dampingRatio = 0.4f,
        stiffness = 80f
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        AnimatedImage(
            resId = Res.drawable.Sausage_1,
            targetOffset = 30.dp to (-65).dp,
            startOffset = 30.dp to (-200).dp,
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_2,
            targetOffset = (-15).dp to (-10).dp,
            startOffset = (-200).dp to (-10).dp,
            delay = 150,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_3,
            targetOffset = 10.dp to 40.dp,
            startOffset = 10.dp to 200.dp,
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_4,
            targetOffset = 50.dp to 20.dp,
            startOffset = 200.dp to 20.dp,
            delay = 250,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_5,
            targetOffset = (-50).dp to 10.dp,
            startOffset = (-200).dp to 10.dp,
            delay = 100,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_6,
            targetOffset = 20.dp to (-40).dp,
            startOffset = 20.dp to (-200).dp,
            delay = 200,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_7,
            targetOffset = (-40).dp to (-55).dp,
            startOffset = (-40).dp to 200.dp,
            delay = 300,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_8,
            targetOffset = -10.dp to 60.dp,
            startOffset = 200.dp to 60.dp,
            delay = 400,
            animationSpec = animationSpec,
            visible = isSelected,
        )

        AnimatedImage(
            resId = Res.drawable.Sausage_9,
            targetOffset = 60.dp to 0.dp,
            startOffset = (-200).dp to 0.dp,
            delay = 500,
            animationSpec = spring(
                dampingRatio = 0.3f,
                stiffness = 50f
            ),
            visible = isSelected,
        )
    }
}

//@Composable
//private fun AnimatedImage(
//    resId: DrawableResource,
//    targetOffset: Pair<Dp, Dp>,
//    startOffset: Pair<Dp, Dp>,
//    delay: Int,
//    animationSpec: AnimationSpec<Dp>,
//    visible: Boolean,
//    size: Dp
//) {
//    val xOffset by animateDpAsState(
//        targetValue = if (visible) targetOffset.first else startOffset.first,
//        animationSpec = animationSpec,
//        finishedListener = { /* Optional completion callback */ }
//    )
//
//    val yOffset by animateDpAsState(
//        targetValue = if (visible) targetOffset.second else startOffset.second,
//        animationSpec = tween(delay)
//    )
//
//    val sizeAnimatable = remember { Animatable(200.dp, Dp.VectorConverter) }
//    val alphaAnimatable = remember { Animatable(0.8f) }
//
//    LaunchedEffect(Unit) {
//        sizeAnimatable.animateTo(
//            targetValue = 200.dp,
//            animationSpec = tween(durationMillis = 100)
//        )
//        sizeAnimatable.animateTo(
//            targetValue = size,
//            animationSpec = tween(durationMillis = 110)
//        )
//        alphaAnimatable.animateTo(
//            targetValue = 1f,
//            animationSpec = tween(durationMillis = 110)
//        )
//    }
//
//    Image(
//        painter = painterResource(resId),
//        contentDescription = null,
//        modifier = Modifier
//            .size(sizeAnimatable.value)
//            .offset(x = xOffset, y = yOffset)
//            .alpha(alphaAnimatable.value)
//    )
//}
