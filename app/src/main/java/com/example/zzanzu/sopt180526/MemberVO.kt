package com.example.zzanzu.sopt180526

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MemberVO : RealmObject() {
    @PrimaryKey
    var id : String = ""
    var pwd : String = ""
}