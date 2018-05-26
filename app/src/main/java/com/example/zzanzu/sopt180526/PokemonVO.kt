package com.example.zzanzu.sopt180526

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class PokemonVO : RealmObject() {
    @PrimaryKey
    var name : String = "" // main key!
    var num : Int = 0
    var user : String = ""
    var type : String = ""
}