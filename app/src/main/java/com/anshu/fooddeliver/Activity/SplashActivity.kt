package com.anshu.fooddeliver.Activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.anshu.fooddeliver.DataBase.SharedPrefHelper
import com.anshu.fooddeliver.R
import com.anshu.fooddeliver.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding;
    private lateinit var sharedPrefHelper: SharedPrefHelper
    private var checkLogin: String = ""
    private val splashPreLength = 5000
    private val REQUEST = 112
    var ret = false
    private lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefHelper = SharedPrefHelper(this)

        binding.lottie.setAnimation(R.raw.foodsplash)
        binding.lottie.loop(true)
        binding.lottie.playAnimation()

        val permissions = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,
        )

        if (!hasPermissions(this, permissions)) {
            ActivityCompat.requestPermissions(this, permissions,  REQUEST)
        } else {
            callNextActivity()
        }
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("TAG", "@@@ PERMISSIONS grant")
                    callNextActivity()
                } else {
                    Log.d("TAG", "@@@ PERMISSIONS Denied")
                    Toast.makeText(this, "PERMISSIONS Denied", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun hasPermissions(context: Context?, permissions: Array<String>?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

    private fun callNextActivity() {
        checkLogin = sharedPrefHelper.getString("isLogin", "")!!
        Handler().postDelayed({
            if (checkLogin == "Yes") {
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            } else {
                sharedPrefHelper.setBoolean("SplashDownload", true)
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            }
        }, splashPreLength.toLong())
    }
}
