package br.htech.dice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.htech.dice.model.DieFace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class DiceViewModel : ViewModel() {
    private val repository = DiceRepository()
    private val _diceResult = MutableStateFlow(DieFace(0, 0))
    val diceResult: StateFlow<DieFace> = _diceResult

    init {
        viewModelScope.launch {
            repository.insertDie(DieFace(1, R.drawable.dice_1))
            repository.insertDie(DieFace(2, R.drawable.dice_2))
            repository.insertDie(DieFace(3, R.drawable.dice_3))
            repository.insertDie(DieFace(4, R.drawable.dice_4))
            repository.insertDie(DieFace(5, R.drawable.dice_5))
            repository.insertDie(DieFace(6, R.drawable.dice_6))
        }
        rollDice()
    }

    fun rollDice() {
        viewModelScope.launch {
            _diceResult.value = repository.getDieFaceByNumber(Random.nextInt(1,6))!!
        }
    }
}
