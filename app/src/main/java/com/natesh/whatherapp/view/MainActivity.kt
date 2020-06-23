package com.natesh.whatherapp.view

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.natesh.whatherapp.R
import com.natesh.whatherapp.adpater.Itemviewlistnerforitem
import com.natesh.whatherapp.adpater.LocationAdapter
import com.natesh.whatherapp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Itemviewlistnerforitem {


    private lateinit var viewModel: MainActivityViewModel
    private lateinit var  adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)


        iv_serchview_btn.setOnClickListener {

            if(ed_search.text!!.isNotEmpty())
            viewModel.SearchLocation(ed_search.text.toString())

        }

        viewModel.changestateProgress()

        viewModel.ShowProgress.observe(this, Observer {

            if(it)
                appprogressbar.visibility = VISIBLE
             else
                appprogressbar.visibility = GONE
        })

        viewModel.locationList.observe(this, Observer {
          adapter.setLocation(it)
        })

        adapter = LocationAdapter(this)
        re_serch.adapter = adapter

    }

    override fun onItemselected(position: Int) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show()
        Log.d("position",""+position)
    }
}