package com.natesh.whatherapp.adpater

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natesh.whatherapp.R
import com.natesh.whatherapp.model.Weatherdata
import com.natesh.whatherapp.view.DetailsActivity
import kotlinx.android.synthetic.main.rv_locationchild.view.*
import java.util.ArrayList

class LocationAdapter(private val context: Context) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>() {
    private var list: List<Weatherdata> = ArrayList()
    private val mitemviewListnerforitem: Itemviewlistnerforitem? = null

    fun setLocation(list: List<Weatherdata>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].title
        holder.latlong.text = list[position].latt_long
        mitemviewListnerforitem?.onItemselected(position)

        holder.roorView.setOnClickListener {

            val intent  = Intent(context,DetailsActivity::class.java)
            intent.putExtra("Location",list[position].woeid)
            intent.putExtra("name",list[position].title)
            Log.d("name",""+list[position].title)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rv_locationchild,
                parent,
                false
            )
        )

    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val name = v.tv_locationname!!
        val latlong = v.tv_latlong!!
        val roorView = v.child_root!!

    }
}

interface Itemviewlistnerforitem {

    fun onItemselected(position: Int)
}
