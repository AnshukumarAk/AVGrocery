package com.anshu.fooddeliver.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.anshu.fooddeliver.DataBase.SharedPrefHelper
import com.anshu.fooddeliver.Fragments.CategoryFragment
import com.anshu.fooddeliver.Fragments.FavoritesFragment
import com.anshu.fooddeliver.Fragments.HomeFragment
import com.anshu.fooddeliver.R
import com.anshu.fooddeliver.databinding.ActivityMainBinding
import com.anshu.fooddeliver.databinding.ActivitySplashBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())

//        bottomNav = findViewById(R.id.btm_nav) as BottomNavigationView
//        bottomNav.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.homeFragment -> {
//                    loadFragment(HomeFragment())
//                    true
//                }
//
//                R.id.favoritesFragment -> {
//                    loadFragment(FavoritesFragment())
//                    true
//                }
//
//                R.id.categoriesFragment -> {
//                    loadFragment(CategoryFragment())
//                    true
//                }
//                else -> false
//            }
//
//
//        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment, null)
            .commit()
    }
}