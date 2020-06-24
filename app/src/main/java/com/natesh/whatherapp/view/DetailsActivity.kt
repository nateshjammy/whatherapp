package com.natesh.whatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.natesh.whatherapp.R
import com.natesh.whatherapp.viewmodel.DetailsActivityViewModel
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.rv_locationchild.*

class DetailsActivity : AppCompatActivity() {


    private lateinit var Viewmodel : DetailsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        Viewmodel = ViewModelProviders.of(this).get(DetailsActivityViewModel::class.java)

       if(intent.hasExtra("name")){
           location_name.text = intent.getStringExtra("name")
        }
        if(intent.hasExtra("Location")){
            val location = intent.getIntExtra("Location",0)
            if(location > 0)

             Viewmodel.getweather(location)
        }

        Viewmodel.showProcess.observe(this, Observer {

            if(it)
                detailspprogressbar.visibility = VISIBLE
            else
                detailspprogressbar.visibility = GONE

        })

        Viewmodel.response.observe(this, Observer {

            if(it != null){
                location_temp.text = it.consolidated_weather[0].the_temp.toString()
            }
        })

    }
}