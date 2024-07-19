package br.htech.dice.model

import br.htech.dice.R

enum class DieFace(val number: Int, val resource: Int) {
    ONE(1, R.drawable.dice_1),
    TWO(2, R.drawable.dice_2),
    THREE(3, R.drawable.dice_3),
    FOUR(4, R.drawable.dice_4),
    FIVE(5, R.drawable.dice_5),
    SIX(6, R.drawable.dice_6);
}
