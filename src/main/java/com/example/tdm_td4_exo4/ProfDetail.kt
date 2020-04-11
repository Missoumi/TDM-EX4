package com.example.tdm_td4_exo4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfDetail : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prof_detail)
        val ind = intent.getIntExtra("IND", 0)
        var prof_nom = findViewById<TextView>(R.id.prof_nom)
        prof_nom.text = "Nom: "+resources.getStringArray(R.array.profs_nom)[ind]
        var prof_prenom = findViewById<TextView>(R.id.prof_prenom)
        prof_prenom.text = "Prenom: "+resources.getStringArray(R.array.profs)[ind]
        var prof_date = findViewById<TextView>(R.id.prof_date)
        prof_date.text = "date de naissance: "+resources.getStringArray(R.array.profs_date)[ind]
        var prof_image = findViewById<ImageView>(R.id.prof_image)
        prof_image.setImageResource(resources.obtainTypedArray(R.array.prof_image).getResourceId(ind, -1))
    }
}
