package com.example.proiectbun.models
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.proiectbun.R
import com.example.proiectbun.models.Animal
class Fragment2 : Fragment() {
    private lateinit var animal: Animal
    private lateinit var nameTextView: TextView
    private lateinit var continentTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detalii, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            animal = Animal(
                it.getString("nume_animal") ?: "",
                it.getString("continent_animal") ?: ""
            )
        }


        nameTextView = view.findViewById(R.id.nume_animal)
        continentTextView = view.findViewById(R.id.continent_animal)

        nameTextView.text = animal.name
        continentTextView.text = animal.continent

        val backgroundColor = getBackgroundColorForContinent(animal.continent)
        view.setBackgroundColor(backgroundColor)

        val textColor = getTextColorForContinent(animal.continent)
        nameTextView.setTextColor(textColor)
        continentTextView.setTextColor(textColor)
    }

    private fun getBackgroundColorForContinent(continent: String): Int {
        return when (continent) {
            "Europa" -> ContextCompat.getColor(requireContext(), R.color.green)
            "Africa" -> ContextCompat.getColor(requireContext(), R.color.yellow)
            "Asia" -> ContextCompat.getColor(requireContext(), R.color.red)
            "America de Nord" -> ContextCompat.getColor(requireContext(), R.color.brown)
            "America de Sud" -> ContextCompat.getColor(requireContext(), R.color.orange)
            "Australia" -> ContextCompat.getColor(requireContext(), R.color.purple)
            "Antarctica" -> ContextCompat.getColor(requireContext(), R.color.blue)
            else -> Color.WHITE
        }
    }

    private fun getTextColorForContinent(continent: String): Int {
        return when (continent) {
            "Europe" -> ContextCompat.getColor(requireContext(), R.color.white)
            "Africa" -> ContextCompat.getColor(requireContext(), R.color.black)
            "Asia" -> ContextCompat.getColor(requireContext(), R.color.white)
            "North America" -> ContextCompat.getColor(requireContext(), R.color.white)
            "South America" -> ContextCompat.getColor(requireContext(), R.color.black)
            "Australia" -> ContextCompat.getColor(requireContext(), R.color.white)
            "Antarctic" -> ContextCompat.getColor(requireContext(), R.color.white)
            else -> ContextCompat.getColor(requireContext(), R.color.white)
        }
    }
}
