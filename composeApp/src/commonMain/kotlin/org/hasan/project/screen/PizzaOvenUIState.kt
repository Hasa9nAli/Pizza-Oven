package org.hasan.project.screen

import org.jetbrains.compose.resources.DrawableResource
import pizzaoven.composeapp.generated.resources.Bread_1
import pizzaoven.composeapp.generated.resources.Bread_2
import pizzaoven.composeapp.generated.resources.Bread_3
import pizzaoven.composeapp.generated.resources.Bread_4
import pizzaoven.composeapp.generated.resources.Bread_5
import pizzaoven.composeapp.generated.resources.Res


data class PizzaOvenUIState(
    val sizePlate: Plate = Plate.SMALL,
    val listOfPlate: List<PlateUIState> = listOf(
        PlateUIState(
            name = "Cheese Pizza",
            price = "17$",
            plateImage = Res.drawable.Bread_1
        ),
        PlateUIState(
            name = "Pepperoni Pizza",
            price = "19$",
            plateImage = Res.drawable.Bread_2
        ),
        PlateUIState(
            name = "Veggie Pizza",
            price = "18$",
            plateImage = Res.drawable.Bread_3
        ),
        PlateUIState(
            name = "Pizza paste",
            price = "20$",
            plateImage = Res.drawable.Bread_4
        ),
        PlateUIState(
            name = "Pizza paste",
            price = "5$",
            plateImage = Res.drawable.Bread_5
        ),

        ),
)

data class PlateUIState(
    val name: String = "Pizza",
    val price: String = "17$",
    val plateImage: DrawableResource = Res.drawable.Bread_1,
    val isHasMushroom: Boolean = false,
    val isHasOnion: Boolean = false,
    val isHasBasil: Boolean = false,
    val isHasBroccoli: Boolean = false,
    val isHasSausage: Boolean = false,
)

