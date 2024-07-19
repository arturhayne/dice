package br.htech.dice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.htech.dice.model.Dice
import br.htech.dice.model.DieFace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DiceViewModel : ViewModel() {
    private val dice = Dice()
    private val _diceResult = MutableStateFlow(DieFace.ONE)
    val diceResult: StateFlow<DieFace> = _diceResult

    fun rollDice() {
        viewModelScope.launch {
            _diceResult.value = dice.roll()
        }
    }
}
