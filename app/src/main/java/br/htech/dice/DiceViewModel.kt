package br.htech.dice

import androidx.lifecycle.ViewModel
import br.htech.dice.data.DiceRepository
import br.htech.dice.model.DieFace
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class DiceViewModel @Inject constructor(
    private val repository: DiceRepository
) : ViewModel() {
    private val _diceResult = MutableStateFlow(DieFace(0, 0))
    val diceResult: StateFlow<DieFace> = _diceResult

    init {
        repository.insertDie(DieFace(1, R.drawable.dice_1))
        repository.insertDie(DieFace(2, R.drawable.dice_2))
        repository.insertDie(DieFace(3, R.drawable.dice_3))
        repository.insertDie(DieFace(4, R.drawable.dice_4))
        repository.insertDie(DieFace(5, R.drawable.dice_5))
        repository.insertDie(DieFace(6, R.drawable.dice_6))
        rollDice()
    }

    fun rollDice() {
        _diceResult.value = repository.getDieFaceByNumber(Random.nextInt(1,6))!!
    }
}
