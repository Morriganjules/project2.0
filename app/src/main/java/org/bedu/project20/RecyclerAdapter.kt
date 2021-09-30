package org.bedu.project20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RecyclerAdapter(val products : List<Product>, fm: FragmentManager) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.nameProduct)
        val rate = view.findViewById<RatingBar>(R.id.ratingBar)
        val stock = view.findViewById<TextView>(R.id.stock)
        val imagen = view.findViewById<ImageView>(R.id.imgProduct)
        val precio = view.findViewById<TextView>(R.id.precio)
        var descripcion: String = ""

        fun bind (producto: Product){
            title.text = producto.title
            rate.rating = producto.rate
            stock.text = producto.category
            precio.text = "\$ ${producto.price.toString()}"
            Picasso.get().load(producto.image).into(imagen)
            descripcion = producto.description

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_product_recycler,parent,false)



        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        val action: NavDirections = ListFragmentDirections.actionListFragmentToDescriptionFragment(product)

        holder.itemView.setOnClickListener{view ->
            view.findNavController().navigate(action)
        }
    }

}