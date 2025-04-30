package com.example.midterm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        if (savedInstanceState == null) {
            loadFragment(CalendarFragment())
        }


        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_calendar -> {
                    loadFragment(CalendarFragment())
                    true
                }
                R.id.nav_frame -> {
                    loadFragment(FrameFragment())
                    true
                }
                R.id.nav_layer -> {
                    loadFragment(LayerFragment())
                    true
                }
                R.id.nav_note -> {
                    loadFragment(NoteFragment())
                    true
                }
                R.id.nav_receipt -> {
                    loadFragment(First())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}
