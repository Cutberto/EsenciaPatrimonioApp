package com.example.escenciapatrimoniotramites.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.escenciapatrimoniotramites.Fragmentos.*
import com.example.escenciapatrimoniotramites.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    val TAG : String = "MainActivity"

    lateinit var btnLogOut : Button
    lateinit var bottomNav : BottomNavigationView
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Se definen los fragmentos de las pestañas
        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val searchFragment = SearchFragment()
        val contactsFragment = ContactsFragment()
        val donationsFragment = DonationsFragment()


        // Se encuentran los componentes de la pantalla
        //btnLogOut = findViewById(R.id.btnLogOut)
        bottomNav = findViewById(R.id.bottomNavigation)

        /*btnLogOut.setOnClickListener {
            ParseUser.logOut()
            goLoginActivity()
        }*/

        openFragment(homeFragment)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home ->{
                    Log.i("openfragment","cargando homefragment")
                    openFragment(homeFragment)
                    true
                }
                R.id.action_search ->{
                    openFragment(searchFragment)
                    true
                }
                R.id.action_contacts -> {
                    openFragment(contactsFragment)
                    true
                }
                R.id.action_profile ->{
                    openFragment(profileFragment)
                    true
                }
                R.id.action_donation ->{
                    openFragment(donationsFragment)
                    true
                }
                else -> {
                    openFragment(homeFragment)
                    true
                }
            }
        }
    }

    private fun goLoginActivity() {
        Log.i(TAG, "Entered goMainActivity")
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finishAffinity() // Cierra todas las ventanas anteriores
    }

    private fun openFragment(fragmnt: Fragment) {
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.flContainer, fragmnt)
        frag.commit()
    }
    private fun onListItemClick(position: Int) {
        Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show()
    }
}

