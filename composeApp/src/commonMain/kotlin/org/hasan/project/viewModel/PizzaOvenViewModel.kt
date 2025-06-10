package com.hasan.test.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.hasan.project.ui.screen.PizzaOvenUIState
import org.hasan.project.ui.screen.Plate
import org.koin.core.component.KoinComponent

class PizzaOvenViewModel: ViewModel(), KoinComponent {

    private val _state = MutableStateFlow(PizzaOvenUIState())
    val state = _state.asStateFlow()

    fun onChangePlateSize(size: Plate){
        _state.value =  _state.value.copy(sizePlate = size)
    }

    fun onClickMushroom(indexPlate: Int) {
        if (indexPlate !in _state.value.listOfPlate.indices) return

        val newList = _state.value.listOfPlate.toMutableList().apply {
            this[indexPlate] = this[indexPlate].copy(
                isHasMushroom = !this[indexPlate].isHasMushroom
            )
        }.toList()

        _state.value = _state.value.copy(listOfPlate = newList)
    }

    fun onClickBroccoli(indexPlate: Int){
        if (indexPlate !in _state.value.listOfPlate.indices) return

        val newList = _state.value.listOfPlate.toMutableList().apply {
            this[indexPlate] = this[indexPlate].copy(
                isHasBroccoli = !this[indexPlate].isHasBroccoli
            )
        }.toList()

        _state.value = _state.value.copy(listOfPlate = newList)
    }

    fun onClickBasil(indexPlate: Int){
        if (indexPlate !in _state.value.listOfPlate.indices) return

        val newList = _state.value.listOfPlate.toMutableList().apply {
            this[indexPlate] = this[indexPlate].copy(
                isHasBasil = !this[indexPlate].isHasBasil
            )
        }.toList()

        _state.value = _state.value.copy(listOfPlate = newList)
    }

    fun onClickSausage(indexPlate: Int){
        if (indexPlate !in _state.value.listOfPlate.indices) return

        val newList = _state.value.listOfPlate.toMutableList().apply {
            this[indexPlate] = this[indexPlate].copy(
                isHasSausage = !this[indexPlate].isHasSausage
            )
        }.toList()

        _state.value = _state.value.copy(listOfPlate = newList)
    }
    fun onClickOnion(indexPlate: Int){
        if (indexPlate !in _state.value.listOfPlate.indices) return

        val newList = _state.value.listOfPlate.toMutableList().apply {
            this[indexPlate] = this[indexPlate].copy(
                isHasOnion = !this[indexPlate].isHasOnion
            )
        }.toList()

        _state.value = _state.value.copy(listOfPlate = newList)
    }

}
