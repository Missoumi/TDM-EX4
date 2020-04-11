package com.example.tdm_td4_exo4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ModuleDetail : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_detail)
        val ind = intent.getIntExtra("IND", 0)
        var title = findViewById<TextView>(R.id.title)
        var prof = findViewById<TextView>(R.id.prof)
        var delay = findViewById<TextView>(R.id.delay)
        title.text = "module: "+resources.getStringArray(R.array.titles)[ind]
        prof.text = "Prof: "+resources.getStringArray(R.array.profs)[ind]
        delay.text = "Duree: "+resources.getStringArray(R.array.delays)[ind]
        prof.setOnClickListener {showProf(ind)}
    }

    fun showProf(ind:Int){
        val intent = Intent(this, ProfDetail::class.java).apply {
            putExtra("IND", ind)
        }
        startActivity(intent)
    }
}
