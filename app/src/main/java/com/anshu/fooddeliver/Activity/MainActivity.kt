package com.anshu.fooddeliver.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.anshu.fooddeliver.DataBase.SharedPrefHelper
import com.anshu.fooddeliver.Fragments.CategoryFragment
import com.anshu.fooddeliver.Fragments.FavoritesFragment
import com.anshu.fooddeliver.Fragments.HomeFragment
import com.anshu.fooddeliver.Fragments.RecipesFragment
import com.anshu.fooddeliver.R
import com.anshu.fooddeliver.databinding.ActivityMainBinding
import com.anshu.fooddeliver.databinding.ActivitySplashBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import me.ibrahimsn.lib.NiceBottomBar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    lateinit var bottomNav : BottomNavigationView
   private lateinit var bottomBar: NiceBottomBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomBar = findViewById<NiceBottomBar>(R.id.bottomBar)

        // Set the initial fragment
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        binding.bottomBar.onItemSelected = {
            when (it) {
                0 -> loadFragment(HomeFragment())
                1 -> loadFragment(FavoritesFragment())
                2 -> loadFragment(CategoryFragment())
                3 -> loadFragment(RecipesFragment())
            }

        }




    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment, null)
            .commit()
    }
}