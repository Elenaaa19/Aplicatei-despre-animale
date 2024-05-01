package com.example.proiectbun.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectbun.R
import com.example.proiectbun.models.Animal

class AdapterListaAnimale (private val animals: List<Animal>) :
    RecyclerView.Adapter<AdapterListaAnimale.AnimalViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(animal: Animal)
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position])
    }

    override fun getItemCount() = animals.size

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nume_animal)
        private val continentTextView: TextView = itemView.findViewById(R.id.continent_animal)

        fun bind(animal: Animal) {
            val layoutResourceId = getLayoutResourceForContinent(animal.continent)
            val inflater = LayoutInflater.from(itemView.context)
            val layout = inflater.inflate(layoutResourceId, null) as LinearLayout
            val nameTextView: TextView = layout.findViewById(R.id.nume_animal)
            val continentTextView: TextView = layout.findViewById(R.id.continent_animal)

            nameTextView.text = animal.name
            continentTextView.text = animal.continent

            (itemView as LinearLayout).removeAllViews()
            (itemView as LinearLayout).addView(layout)
        }


        private fun getLayoutResourceForContinent(continent: String): Int {
            return when (continent) {
                "Europe" -> R.layout.item_animal_europa
                "Africa" -> R.layout.item_animal_africa
                "Asia" -> R.layout.item_animal_asia
                "America de Nord" -> R.layout.item_animal_americadenord
                "America de Sud" -> R.layout.item_animal_americadesud
                "Australia" -> R.layout.item_animal_australia
                "Antarctica" -> R.layout.item_animal_antarctica
                else -> R.layout.item_animal_europa
            }
        }
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val animal = animals[position]
                    itemClickListener?.onItemClick(animal)
                }
            }
        }
    }
}
