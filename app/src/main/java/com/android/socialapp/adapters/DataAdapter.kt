package com.android.socialapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.socialapp.R
import com.android.socialapp.models.Body
import com.android.socialapp.models.Channels
import com.android.socialapp.models.Socials

class DataAdapter(var type: Int, var body: Body) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.ui_cell,parent,false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        if (type==0){
            holder.itemtitle?.text = body.channels[position].name
        }else{
            holder.itemtitle?.text = body.socials[position].name
        }
    }

    override fun getItemCount(): Int {
        return if (type==0) body.channels.size else body.socials.size
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         var itemLogo: ImageView? = null
         var itemtitle : TextView? = null
        init {
            itemLogo = itemView.findViewById(R.id.platformIcon)
            itemtitle = itemView.findViewById(R.id.platformTitle)

        }
    }

}
