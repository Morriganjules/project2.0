package org.bedu.project20

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException





class MainActivity : AppCompatActivity() {
    private val listFragment = ListFragment()
    private val carritoFragment = CarritoFragment()
    private val perfilFragment = PerfilFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(listFragment)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.btmMenu)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> replaceFragment(listFragment)
                R.id.carritoFragment -> replaceFragment(carritoFragment)
                R.id.perfilFragment -> replaceFragment(perfilFragment)

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

    private fun replaceFragment(fragment:Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerMenu, fragment)
            transaction.commit()
        }

    }


}