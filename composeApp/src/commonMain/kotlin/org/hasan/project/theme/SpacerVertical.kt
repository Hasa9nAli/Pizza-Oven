package com.hasan.test.ui.theme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.hasan.project.theme.largeUnit
import org.hasan.project.theme.mediumUnit
import org.hasan.project.theme.smallUnit
import org.hasan.project.theme.tinyUnit
import org.hasan.project.theme.xLargeUnit
import org.hasan.project.theme.xSmallUnit
import org.hasan.project.theme.xxxLargeUnit

@Composable
fun SpacerVerticalTiny(){
    Spacer(modifier = Modifier.height(tinyUnit))
}

@Composable
fun SpacerVerticalSmall(){
    Spacer(modifier = Modifier.height(smallUnit))
}

@Composable
fun SpacerVerticalXSmall(){
    Spacer(modifier = Modifier.height(xSmallUnit))
}

@Composable
fun SpacerVerticalMedium(){
    Spacer(modifier = Modifier.height(mediumUnit))
}

@Composable
fun SpacerVerticalLarge(){
    Spacer(modifier = Modifier.height(largeUnit))
}
@Composable
fun SpacerVerticalXLarge(){
    Spacer(modifier = Modifier.height(xLargeUnit))
}

@Composable
fun SpacerVerticalXXXLarge(){
    Spacer(modifier = Modifier.height(xxxLargeUnit))
}