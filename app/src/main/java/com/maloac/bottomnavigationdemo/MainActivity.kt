package com.maloac.bottomnavigationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.maloac.bottomnavigationdemo.databinding.ActivityMainBinding
import com.maloac.bottomnavigationdemo.fragments.HomeFragment
import com.maloac.bottomnavigationdemo.fragments.MessageFragment
import com.maloac.bottomnavigationdemo.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val messageFragment = MessageFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.miHome -> {
                    setCurrentFragment(homeFragment)
                    true
                }
                R.id.miMessage -> {
                    setCurrentFragment(messageFragment)
                    true
                }
                R.id.miProfile -> {
                    setCurrentFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}