package com.example.emptyactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.emptyactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener{

            when(it.itemId){
                R.id.home_icon -> replaceFragment(HomeFragment())
                R.id.profile_icon -> replaceFragment(ProfileFragment())
                R.id.settings_icon -> replaceFragment(SettingsFragment())
                else ->{

                }
            }
            true

        }

    }
    fun navigateToNextPage(view: View){
        val intent = Intent(this, ProfileFragment::class.java)
        startActivity(intent)
    }
   private fun replaceFragment(fragment: Fragment){
       val fragmentManager = supportFragmentManager
       val fragmentTransaction = fragmentManager.beginTransaction()
       fragmentTransaction.replace(R.id.frameLayout, fragment)
       fragmentTransaction.commit()
   }
}