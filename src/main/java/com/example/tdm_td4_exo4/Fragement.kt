package com.example.tdm_td4_exo4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragement.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragement : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_fragement, container, false)
        var title = root.findViewById<TextView>(R.id.title_land)
        var prof = root.findViewById<TextView>(R.id.prenom_land)
        var delay = root.findViewById<TextView>(R.id.delay_land)
        title.text = resources.getStringArray(R.array.titles)[param1]
        prof.text = resources.getStringArray(R.array.profs)[param1]
        delay.text = resources.getStringArray(R.array.delays)[param1]
        var prof_nom = root.findViewById<TextView>(R.id.nom_land)
        prof_nom.text = resources.getStringArray(R.array.profs_nom)[param1]
        var prof_date = root.findViewById<TextView>(R.id.date_land)
        prof_date.text = resources.getStringArray(R.array.profs_date)[param1]
        var prof_image = root.findViewById<ImageView>(R.id.prof_image_land)
        prof_image.setImageResource(resources.obtainTypedArray(R.array.prof_image).getResourceId(param1, -1))
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragement.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            Fragement().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}
