package com.slack.jeanpokou.sunshine

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.find

class ForecastAdapter( private  val mWeatherData:Array<String>?): RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>(){


    // Happen when a new item is added to the RecyclerView
    override fun onBindViewHolder(holder: ForecastViewHolder?, position: Int) {
        holder?.bind(position)
    }

    override fun getItemCount(): Int {
        return  mWeatherData?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ForecastViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class  ForecastViewHolder (itemView : View, private val mWeatherTextView: TextView = itemView.find<TextView>(R.id.tv_weather_data)) : RecyclerView.ViewHolder(itemView) {
        fun bind( position: Int) {
            with(mWeatherTextView) {
                text = mWeatherData?.get(position) ?: "ERROR"
            }
        }

    }

}