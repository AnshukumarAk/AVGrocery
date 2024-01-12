package com.anshu.fooddeliver.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anshu.fooddeliver.R
import com.anshu.fooddeliver.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
     private lateinit var binding: ActivitySplashBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lottie.setAnimation(R.raw.foodsplash)
        binding.lottie.loop(true)
        binding.lottie.playAnimation()

    }
}