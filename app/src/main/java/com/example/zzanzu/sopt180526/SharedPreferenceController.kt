package com.example.zzanzu.sopt180526

import android.content.Context


// 어느 액티비티에서든 접근가능하도록 만들어놓은 오브젝트 클래스, 오브젝트 안의 내용들은 인스턴스화할 필요없이 바로 접근 가능
object SharedPreferenceController {
    private val USER = "user"
    private val ID = "id"
    private val PWD = "pwd"

    fun setID(context: Context, id: String) {
        // 이 sharedpreference를 만든 사용자만 접근 가능(private)
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(ID, id)
        editor.commit()
    }

    fun getID(context: Context) : String {
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)

        return pref.getString(ID, "") // ID가 저장된게 없으면 ""를 가져옴
    }

    fun setPWD(context: Context, pwd: String) {
        // 이 sharedpreference를 만든 사용자만 접근 가능(private)
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(PWD, pwd)
        editor.commit()
    }

    fun getPWD(context: Context) : String {
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)

        return pref.getString(PWD, "") // ID가 저장된게 없으면 ""를 가져옴
    }

    // sharedpreference를 비워냄
    fun clearSPC(context: Context) {
        val pref = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.clear()
        editor.commit()
    }

}