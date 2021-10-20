package com.hungryshark.lesson1.view.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.hungryshark.lesson1.databinding.ActivitySplashBinding
import com.hungryshark.lesson1.view.activity.main.MainActivity

private const val TIME_OF_LOAD_APP: Long = 3000

class SplashActivity : AppCompatActivity() {

    var handler = Handler()

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, TIME_OF_LOAD_APP)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}