package com.example.zzanzu.sopt180526

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_sign.*

class SignActivity : AppCompatActivity() {
    lateinit var memberRealm: Realm
    lateinit var memberVO: MemberVO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        init()

        sign_check_btn.setOnClickListener {
            val id = sign_id_et.text.toString()

            // 해당 데이터가 없다면
            if(getMemeberList(id).isEmpty()) {
                insertMemeberList()

                Toast.makeText(this, "가입완료", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "이미 존재하는 id 입니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun init() {
        Realm.init(this)
        memberRealm = Realm.getDefaultInstance()
    }

    // 내가 입력한게 데이터베이스에 있나?
    fun getMemeberList(id: String) : RealmResults<MemberVO> {
        // MemerVO는 상속이 가능한 형태여야함, open
        return memberRealm.where(MemberVO::class.java)
                .equalTo("id", id).findAll()
    }

    // 내가 입력한 것이 데이터베이스에 저장
    fun insertMemeberList() {
        memberVO = MemberVO()
        memberVO.id = sign_id_et.text.toString()
        memberVO.pwd = sign_pw_et.text.toString()

        // 시동, 데이터를 수정 가능한 상태로 만듬
        memberRealm.beginTransaction()
        memberRealm.copyToRealm(memberVO)
        memberRealm.commitTransaction()
    }
}
