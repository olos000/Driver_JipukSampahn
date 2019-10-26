package com.andronity.driver_jipuksampah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.andronity.driver_jipuksampah.Fragment.HandleFragment
import com.andronity.driver_jipuksampah.Fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home_driver.*



class HomeDriver : AppCompatActivity() {


    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_history -> {
                    val fragment = HandleFragment()
                    addFragment(fragment)
                    setSupportActionBar(toolbar)
                    val actionBar = supportActionBar
                    actionBar!!.title = "ayoo berlangganan"
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {

                    val fragment = ProfileFragment()
                    addFragment(fragment)
                    setSupportActionBar(toolbar)
                    val actionBar = supportActionBar
                    actionBar!!.title = "Profil"
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_driver)
        viewpager_main.adapter = MyPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)







        


    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,fragment)
            .commit()

    }

}