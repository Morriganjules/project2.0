package org.bedu.project20

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewStub
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.btmMenu)

        //bottomNavigation.setupWithNavController(navController)

        //metodos para funcionalidades NavBar


        val listFragment = ListFragment()
        val carritoFragment = CarritoFragment()
        val perfilFragment = PerfilFragment()


        //bottom = findViewById(R.id.btmMenu)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.listFragment -> {
                    makeCurrentFragment(listFragment)
                    true
                }
                R.id.carritoFragment -> {
                    makeCurrentFragment(carritoFragment)
                    true
                }
                R.id.perfilFragment -> {
                    makeCurrentFragment(perfilFragment)
                    true
                }

            }
            true

        }





    }
    /*metodo para funcionalidades AppBar */


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.buscar -> {Toast.makeText(this, "Opcion inhabilitada", Toast.LENGTH_LONG).show()
            return true}
            R.id.url -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://app.bedu.org/")
                startActivity(intent)

                return true
            }
        }
        return true
    }

    //function para poder generar la transaction en el Bottom navBar

    private fun makeCurrentFragment (fragment: Fragment)= supportFragmentManager.beginTransaction().apply {
        replace(R.id.fragmentContainerMenu, fragment)
        commit()
    }

    fun hideBottomNav() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.btmMenu)
        bottomNavigation.visibility = View.GONE
    }

    fun showBottomNav() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.btmMenu)
        bottomNavigation.visibility = View.VISIBLE
    }


}