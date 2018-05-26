package com.example.zzanzu.sopt180526

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class PokemonVO : RealmObject() {
    @PrimaryKey
    var name : String = ""
    var num : Int = 0
    var user : String = ""
    var type : String = ""
}