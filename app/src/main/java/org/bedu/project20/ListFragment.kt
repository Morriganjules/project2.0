package org.bedu.project20

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        setUpRecyclerView(view)



       //val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        //recycler.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        //FORMA PREVIA DE HACERLO PERO QUE EJECUTABA LA ACCION DESDE EL RECYCLER

        /*val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val FragmentManager = requireFragmentManager()
        recycler.adapter = RecyclerAdapter(getProducts(requireActivity()), FragmentManager)*/


        return view
    }

    //funciones para acceder al JSON

    private fun getJsonDataFromAsset(context: Context, fileName: String = "ListProduct.json"): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getProducts(context: Context): List<Product> {
        val jsonString = getJsonDataFromAsset(context)
        val listProductType = object : TypeToken<List<Product>>() {}.type
        return Gson().fromJson(jsonString, listProductType)
    }

    private fun setUpRecyclerView(view : View) {
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val rAdapter = RecyclerAdapter(getProducts(requireContext())) { product ->
            val action = ListFragmentDirections.actionListFragmentToDescriptionFragment(product)
            findNavController().navigate(action)
        }
        recycler.adapter = rAdapter
    }
}