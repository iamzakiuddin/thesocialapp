package com.android.socialapp.adapters

import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.net.Uri
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
import com.bumptech.glide.Glide

class DataAdapter(var context: Context, var type: Int, var body: Body) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.ui_cell,parent,false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        if (type==0){
            holder.itemtitle?.text = body.channels[position].name
            holder.itemLogo?.let {
                Glide.with(holder.itemView).load(body.channels[position].icon).placeholder(R.mipmap.ic_launcher).centerInside().into(
                    it
                )
            }
            holder.itemView.setOnClickListener {
                openApp(body.channels[position].packagedNameAndroid,body.channels[position].url)
            }
        }else{
            holder.itemtitle?.text = body.socials[position].name
            holder.itemLogo?.let {
                Glide.with(holder.itemView).load(body.socials[position].icon).placeholder(R.mipmap.ic_launcher).centerInside().into(
                    it
                )
            }
            holder.itemView.setOnClickListener {
                openApp(body.socials[position].packagedNameAndroid,body.socials[position].url)
            }
        }
    }

    private fun openApp(packagedNameAndroid: String?, url: String?) {
        if (packagedNameAndroid!=null){
            val appsInfoList = context.packageManager.getInstalledApplications(0)
            if (!appsInfoList.isNullOrEmpty()){
                if (isAppInstalled(appsInfoList,packagedNameAndroid)){
                    context.startActivity(context.packageManager.getLaunchIntentForPackage(packagedNameAndroid))
                }else{
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                }
            }
        } else if(url!=null){
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }

    private fun isAppInstalled(appsInfoList: List<ApplicationInfo>,packagedNameAndroid: String?) : Boolean{
        for ( appInfo in appsInfoList){
            if (appInfo.packageName.contentEquals(packagedNameAndroid)){
                return true
            }
        }
        return false
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
