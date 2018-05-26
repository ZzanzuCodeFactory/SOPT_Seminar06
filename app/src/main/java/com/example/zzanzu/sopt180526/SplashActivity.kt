package com.example.zzanzu.sopt180526

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()

        handler.postDelayed({
            // 저장된 ID가 있다면, 이전에 자동로그인 체크했다면
            if(SharedPreferenceController
                            .getID(this) == "") {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", SharedPreferenceController.getID(this))
                startActivity(intent)
                finish()
            }


        }, 3000)
    }
}