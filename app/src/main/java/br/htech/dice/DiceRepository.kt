package br.htech.dice

import br.htech.dice.model.DieFace
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query

class DiceRepository {
    private val realm: Realm

    init {
        val config = RealmConfiguration.create(schema = setOf(DieFace::class))
        realm = Realm.open(config)
    }

    fun insertDie(dieFace: DieFace) {
        realm.writeBlocking {
            copyToRealm(dieFace)
        }
    }

    fun getDieFaceByNumber(number: Int): DieFace? {
        return realm.query<DieFace>("number == $0", number).first().find()
    }
}
