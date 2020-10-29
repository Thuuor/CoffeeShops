package com.example.coffeeshops

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class ShopsAdapter (var items: ArrayList<Shops>) : RecyclerView.Adapter<ShopsAdapter.ImageViewHolder>() {
    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imagen: ImageView
        private var tittle: TextView
        private var direccion: TextView
        private var puntuacion: RatingBar
        private var numPuntuacion: TextView
        private var divider: DividerItemDecoration
        private var button: Button

        init {
            imagen = itemView.findViewById(R.id.imageView)
            tittle = itemView.findViewById(R.id.nombreCoffeeShops)
            direccion = itemView.findViewById(R.id.direccionCoffeeShops)
            puntuacion = itemView.findViewById(R.id.ratingBar)
            numPuntuacion = itemView.findViewById(R.id.numberRatingBar)
            button = itemView.findViewById(R.id.button)
            divider = itemView.findViewById(R.id.divider)
        }

        fun bindShop(shop: Shops, onClick: (View) -> Unit) = with(itemView) {
            imagen.setImageResource(shop.imagen)
            tittle.setText(shop.tittle)
            direccion.setText(shop.direccion)

            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ImageViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindShop(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}