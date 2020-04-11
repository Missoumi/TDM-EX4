package com.example.tdm_td4_exo4

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val day_1 = resources.getStringArray(R.array.day_1)
        val day_2 = resources.getStringArray(R.array.day_2)
        val day_3 = resources.getStringArray(R.array.day_3)
        val days = arrayOf(day_1, day_2, day_3)
        val orient:Int = resources.configuration.orientation
        val size = resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
        val main_layout: LinearLayout = findViewById(R.id.main_layout)
        val day_1_ind = resources.getIntArray(R.array.day_1_ind)
        val day_2_ind = resources.getIntArray(R.array.day_2_ind)
        val day_3_ind = resources.getIntArray(R.array.day_3_ind)
        val days_ind = arrayOf(day_1_ind, day_2_ind, day_3_ind)
        for (i in 0..2){
            val emp = days[i]
            val emp_ind = days_ind[i]
            var textView: TextView = TextView(this)
            textView.text = emp[0]
            textView.setTextColor(Color.parseColor("blue"))
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28F)
            main_layout.addView(textView)
            val n = emp.size-1
            for (j in 1..n){
                var textView: TextView = TextView(this)
                textView.text = emp[j]
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22F)
                main_layout.addView(textView)
                if (orient == Configuration.ORIENTATION_LANDSCAPE){
                    textView.setOnClickListener {handleClickLand(emp_ind[j-1])}
                }
                else {
                    if (Configuration.SCREENLAYOUT_SIZE_NORMAL==size){
                        textView.setOnClickListener {handleClickLand(emp_ind[j-1])}
                    }
                    else {
                        textView.setOnClickListener {handleClick(emp_ind[j-1])}
                    }

                }

            }
        }



    }

    fun handleClick(ind:Int){
        val intent = Intent(this, ModuleDetail::class.java).apply {
            putExtra("IND", ind)
        }
        startActivity(intent)
    }
    fun handleClickLand(ind:Int){
        val transaction = manager.beginTransaction()
        val fragement = Fragement.newInstance(ind)
        transaction.replace(R.id.right_layout_land, fragement)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
