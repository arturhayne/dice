package br.htech.dice.model

class Dice {
    fun roll(): DieFace {
        return DieFace.values().random()
    }
}
