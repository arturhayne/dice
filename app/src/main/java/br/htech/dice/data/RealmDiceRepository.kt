package br.htech.dice.data

import br.htech.dice.model.DieFace
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RealmDiceRepository @Inject constructor() : DiceRepository {
    private val realm: Realm

    init {
        val config = RealmConfiguration.create(schema = setOf(DieFace::class))
        realm = Realm.open(config)
    }

    override fun insertDie(dieFace: DieFace) {
        realm.writeBlocking {
            copyToRealm(dieFace)
        }
    }

    override fun getDieFaceByNumber(number: Int): DieFace? {
        return realm.query<DieFace>("number == $0", number).first().find()
    }
}
