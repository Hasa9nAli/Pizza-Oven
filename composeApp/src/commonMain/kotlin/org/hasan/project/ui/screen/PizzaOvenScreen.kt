@file:OptIn(KoinExperimentalAPI::class)

package org.hasan.project.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasan.test.viewModel.PizzaOvenViewModel
import org.hasan.project.ui.composable.FoodClickableBox
import org.hasan.project.ui.composable.PlateSizeSelector
import org.hasan.project.ui.composable.foodComposable.BasilComponent
import org.hasan.project.ui.composable.foodComposable.BroccoliComponent
import org.hasan.project.ui.composable.foodComposable.MushroomComponent
import org.hasan.project.ui.composable.foodComposable.OnionComponent
import org.hasan.project.ui.composable.foodComposable.SausageComponent
import org.hasan.project.ui.theme.SpacerVerticalMedium
import org.hasan.project.ui.theme.SpacerVerticalSmall
import org.hasan.project.ui.theme.largeUnit
import org.hasan.project.ui.theme.mediumUnit
import org.hasan.project.ui.theme.smallUnit
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import pizzaoven.composeapp.generated.resources.Basil_3
import pizzaoven.composeapp.generated.resources.Broccoli_3
import pizzaoven.composeapp.generated.resources.Mushroom_3
import pizzaoven.composeapp.generated.resources.Onion_3
import pizzaoven.composeapp.generated.resources.Plate
import pizzaoven.composeapp.generated.resources.Res
import pizzaoven.composeapp.generated.resources.Sausage_3
import pizzaoven.composeapp.generated.resources.ic_heart_bold
import pizzaoven.composeapp.generated.resources.ic_left_arrow
import pizzaoven.composeapp.generated.resources.mdi_cart_outline

@Composable
fun PizzaOvenScreen() {
    val viewModel: PizzaOvenViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    PizzaOvenScreenContent(
        state = state,
        onChangePlateSize = viewModel::onChangePlateSize,
        onClickSausage = viewModel::onClickSausage,
        onClickMushroom = viewModel::onClickMushroom,
        onClickBroccoli = viewModel::onClickBroccoli,
        onClickBasil = viewModel::onClickBasil,
        onClickOnion = viewModel::onClickOnion,
    )
}


@Composable
fun PizzaOvenScreenContent(
    state: PizzaOvenUIState,
    onChangePlateSize: (Plate) -> Unit,
    onClickMushroom: (Int) -> Unit,
    onClickBroccoli: (Int) -> Unit,
    onClickBasil: (Int) -> Unit,
    onClickSausage: (Int) -> Unit,
    onClickOnion: (Int) -> Unit,
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { state.listOfPlate.size })
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
            .padding(top = mediumUnit)
    ) {
        item {
            TopBarPizzaOven(state.listOfPlate[pagerState.currentPage].name)
        }

        item {
            PlateSection(
                plateSize = state.sizePlate,
                pagerState = pagerState,
                state = state
            )
        }

        item {

            AnimatedContent(
                targetState = pagerState.currentPage,
                transitionSpec = {
                    ((slideInVertically { height -> height / 2 } + fadeIn()).togetherWith(
                        slideOutVertically { height -> -height / 2 } + fadeOut())
                            )
                        .using(SizeTransform(clip = false))
                }
            ) {
                Text(
                    text = state.listOfPlate[pagerState.currentPage].price,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth().padding(top = largeUnit).animateContentSize(
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }

        item {
            PlateSizeSelector(
                selectedSize = state.sizePlate,
                onSizeSelected = { newSize -> onChangePlateSize(newSize) }
            )
        }

        item {
            Text(
                "Customize Your Pizza",
                modifier = Modifier.padding(
                    start = mediumUnit,
                    top = smallUnit,
                    bottom = smallUnit
                ),
                fontWeight = FontWeight(400),
                color = Color(0x99121212)
            )
        }
        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ChooseFood(
                    state = state,
                    onClickMushroom = onClickMushroom,
                    onClickBroccoli = onClickBroccoli,
                    onClickBasil = onClickBasil,
                    onClickSausage = onClickSausage,
                    onClickOnion = onClickOnion,
                    plateNumber = pagerState.currentPage
                )
            }
            SpacerVerticalMedium()
            SpacerVerticalSmall()
        }
        item {

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {


                Button(
                    modifier = Modifier.height(52.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4B3C38),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.mdi_cart_outline),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = "Add to Cart",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color.White
                        )

                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TopBarPizzaOven(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = mediumUnit)
            .padding(bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_left_arrow),
            contentDescription = null,
            tint = Color(0xFF121212),
            modifier = Modifier.clickable { }
        )
        AnimatedContent(
            title,
            transitionSpec = {
                ((fadeIn() + scaleIn()).togetherWith(fadeOut() + scaleOut()))
                    .using(sizeTransform = SizeTransform(clip = false))
            }

        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF121212)
            )
        }

        Icon(
            painter = painterResource(Res.drawable.ic_heart_bold),
            contentDescription = null,
            tint = Color(0xFF121212),
            modifier = Modifier.clickable { }

        )
    }
}

enum class Plate {
    SMALL,
    MEDIUM,
    LARGE
}

@Composable
fun PlateSection(
    state: PizzaOvenUIState,
    plateSize: Plate,
    onClickBasil: (Int) -> Unit = {},
    onClickBroccoli: (Int) -> Unit = {},
    onClickOnion: (Int) -> Unit = {},
    onClickSausage: (Int) -> Unit = {},
    onClickMushroom: (Int) -> Unit = {},

    pagerState: PagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { state.listOfPlate.size }),

    ) {
    Box(Modifier.fillMaxWidth().height(250.dp), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(Res.drawable.Plate),
            null, modifier = Modifier.size(240.dp)
        )
        HorizontalPager(state = pagerState) {

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                val animatedSize by animateDpAsState(
                    targetValue = when (plateSize) {
                        Plate.SMALL -> 180.dp
                        Plate.MEDIUM -> 200.dp
                        Plate.LARGE -> 220.dp
                    },
                    animationSpec = tween(durationMillis = 300)
                )

                Image(
                    painter = painterResource(state.listOfPlate[it].plateImage),
                    contentDescription = null,
                    modifier = Modifier.size(animatedSize)
                )
                AnimatedVisibility(
                    state.listOfPlate[it].isHasMushroom,
                    enter = slideInVertically{ (it / 2  ) - (it/ 2)  } ,
                    exit = scaleOut() + fadeOut()
                ) {
                    MushroomComponent(isSelected = state.listOfPlate[it].isHasMushroom) {
                        onClickMushroom(it)
                    }
                }
                AnimatedVisibility(
                    state.listOfPlate[it].isHasBasil,
                    enter = slideInVertically{ (it / 2  ) - (it/ 2)  } ,
                    exit = scaleOut() + fadeOut()

                ) {
                    BasilComponent(
                        state.listOfPlate[it].isHasBasil
                    ) {
                        onClickBasil(it)
                    }
                }
                AnimatedVisibility(
                    state.listOfPlate[it].isHasBroccoli,
                    enter = slideInVertically{ (it / 2  ) - (it/ 2)  } ,
                    exit = scaleOut() + fadeOut()
                ) {
                    BroccoliComponent(state.listOfPlate[it].isHasBroccoli) {
                        onClickBroccoli(it)
                    }
                }
                AnimatedVisibility(
                    state.listOfPlate[it].isHasOnion,
                    enter = slideInVertically{ (it / 2  ) - (it/ 2)  } ,
                    exit = scaleOut() + fadeOut()
                ) {
                    OnionComponent(
                        isSelected = state.listOfPlate[it].isHasOnion
                    ) {
                        onClickOnion(it)
                    }
                }
                AnimatedVisibility(
                    state.listOfPlate[it].isHasSausage,
                    enter = slideInVertically{ (it / 2  ) - (it/ 2)  } ,
                    exit = scaleOut() + fadeOut()
                ) {
                    SausageComponent(
                        state.listOfPlate[it].isHasSausage,
                    ) {
                        onClickSausage(it)
                    }
                }
            }
        }
    }
}

@Composable
fun ChooseFood(
    state: PizzaOvenUIState,
    plateNumber: Int,
    onClickMushroom: (Int) -> Unit,
    onClickBroccoli: (Int) -> Unit,
    onClickBasil: (Int) -> Unit,
    onClickSausage: (Int) -> Unit,
    onClickOnion: (Int) -> Unit,
) {

    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(vertical = mediumUnit),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(horizontal = mediumUnit)
    ) {

        item {
            FoodClickableBox(
                image = Res.drawable.Basil_3,
                isSelected = state.listOfPlate[plateNumber].isHasBasil
            ) {
                onClickBasil(plateNumber)
            }
        }
        item {

            FoodClickableBox(
                image = Res.drawable.Onion_3,
                isSelected = state.listOfPlate[plateNumber].isHasOnion
            ) {
                onClickOnion(plateNumber)
            }
        }
        item {
            FoodClickableBox(
                image = Res.drawable.Broccoli_3,
                isSelected = state.listOfPlate[plateNumber].isHasBroccoli
            ) {
                onClickBroccoli(plateNumber)
            }
        }
        item {
            FoodClickableBox(
                image = Res.drawable.Mushroom_3,
                isSelected = state.listOfPlate[plateNumber].isHasMushroom
            ) {
                onClickMushroom(plateNumber)
            }
        }

        item {

            FoodClickableBox(
                image = Res.drawable.Sausage_3,
                isSelected = state.listOfPlate[plateNumber].isHasSausage
            ) {
                onClickSausage(plateNumber)
            }
        }


    }
}

