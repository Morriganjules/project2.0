package org.bedu.project20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class DescriptionFragment : Fragment() {

    private val args by navArgs<DescriptionFragmentArgs>()
    private lateinit var title: TextView
    private lateinit var rate: RatingBar
    private lateinit var category: TextView
    private lateinit var imagen : ImageView
    private lateinit var price : TextView
    private lateinit var descripcion : TextView
    private lateinit var  precioCuotas :TextView
    private lateinit var btnCarrito: Button
    private val action: NavDirections = DescriptionFragmentDirections.actionDescriptionFragmentToCarritoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.description_recycler, container, false)
        view.findViewById<TextView>(R.id.nameProduct).text = args.product.title
        view.findViewById<RatingBar>(R.id.ratingBar).rating = args.product.rate
        view.findViewById<TextView>(R.id.stock).text = args.product.category
        view.findViewById<TextView>(R.id.precio).text = "$ ${args.product.price}"
        view.findViewById<TextView>(R.id.descripcion).text = args.product.description
        view.findViewById<TextView>(R.id.precioCuotas).text = args.product.price.toString()
        imagen = view.findViewById(R.id.imgProducto)
        Picasso.get().load(args.product.image).into(imagen)
        btnCarrito = view.findViewById(R.id.btnCarrito)
        btnCarrito.setOnClickListener{ findNavController().navigate(action)}

        return view
    }


}