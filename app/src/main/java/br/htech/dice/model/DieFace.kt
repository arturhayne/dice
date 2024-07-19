package br.htech.dice.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class DieFace() : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var number: Int = 0
    var resource: Int = 0
    constructor(number: Int, resource: Int): this() {
        this.number = number
        this.resource = resource
    }
}
