package com.example.zzanzu.sopt180526

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var memberRealm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        login_login_btn.setOnClickListener {
            val id = login_id_et.text.toString()
            val pwd = login_pw_et.text.toString()

            if(getMemeberList(id).isEmpty()) {
                Toast.makeText(this, "존재하는 id가 없습니다", Toast.LENGTH_SHORT).show()
            } else {
                if(login_auto_chk.isChecked) {
                    SharedPreferenceController
                            .setID(this, id)
                    SharedPreferenceController
                            .setPWD(this, pwd)
                }
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", id)

                startActivity(intent)
                finish()
            }
        }

        login_sign_btn.setOnClickListener {
            startActivity(Intent(this, SignActivity::class.java))
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
}