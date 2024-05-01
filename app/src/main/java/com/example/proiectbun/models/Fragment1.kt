import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectbun.models.Animal
import com.example.proiectbun.R
import com.example.proiectbun.adapters.AdapterListaAnimale
import com.example.proiectbun.models.Fragment2

class Fragment1 : Fragment() {
    private val animals = listOf(
        Animal("Iepure de camp","Europa"),
        Animal("Cerb","Europa"),
        Animal("Caprioara","Europa"),
        Animal("Jderul","Europa"),
        Animal("Ursul brun","Europa"),
        Animal("Pisica salbatica","Europa"),
        Animal("Harciog","Europa"),
        Animal("Nutria","Europa"),
        Animal("Dromader","Africa"),
        Animal("Rinocer","Africa"),
        Animal("Crocodil","Africa"),
        Animal("Hipopotam","Africa"),
        Animal("Zebra","Africa"),
        Animal("Antilopa","Africa"),
        Animal("Gazela","Africa"),
        Animal("Flamingo","Africa"),
        Animal("Paun","Asia"),
        Animal("Cameleon","Asia"),
        Animal("Iguana","Asia"),
        Animal("Cobra","Asia "),
        Animal("Pangolin","Asia"),
        Animal("Camila","Asia"),
        Animal("Ornitorinc","Asia"),
        Animal("Raton","America de Nord"),
        Animal("Papagal","America de Nord"),
        Animal("Castor","America de Nord"),
        Animal("Lenes","America de Nord"),
        Animal("Colibri","America de Nord"),
        Animal("Perus","America de Nord"),
        Animal("Nutria","America de Nord"),
        Animal("Soparla","Australia"),
        Animal("Crocodil","Australia"),
        Animal("Urs panda","Australia"),
        Animal("Elefant","Australia"),
        Animal("Koala","Australia"),
        Animal("Emu","Australia"),
        Animal("Balena ucigasa","Antarctica"),
        Animal("Pinguin","Antarctica"),
        Animal("Foca","Antarctica"),
        Animal("Pasarea Albatros","Antarctica"),
        Animal("Urs polar","Antarctica"),
        Animal("Vulpe polara","Antarctica"),
        Animal("Lei de mare","Antarctica"),
        Animal("Jaguar","America de Sud"),
        Animal("Vidra","America de Sud"),
        Animal("Lama","America de Sud"),
        Animal("Capibara","America de Sud"),
        Animal("Puma","America de Sud"),
        Animal("Sconcs","America de Sud"),

    ).shuffled()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterListaAnimale

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.animal_list_recycler_view)

        adapter = AdapterListaAnimale(animals)

        adapter.setOnItemClickListener(object : AdapterListaAnimale.OnItemClickListener {
            override fun onItemClick(animal: Animal) {
                // Handle item click here
                val bundle = Bundle().apply {
                    putString("nume_animal", animal.name)
                    putString("continent_animal", animal.continent)
                }
                val animalDetailFragment = Fragment2().apply {
                    arguments = bundle
                }
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, animalDetailFragment)
                    .addToBackStack(null)
                    .commit()
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}