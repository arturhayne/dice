package br.htech.dice.data

import br.htech.dice.model.DieFace

interface DiceRepository {
    fun insertDie(dieFace: DieFace)
    fun getDieFaceByNumber(number: Int): DieFace?
}