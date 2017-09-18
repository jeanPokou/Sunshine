package com.slack.jeanpokou.sunshine

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.slack.jeanpokou.sunshine.utilities.NetworkUtils
import kotlinx.android.synthetic.main.activity_forecast.*
import org.jetbrains.anko.toast
import java.io.IOException
import java.net.URL

class forecast : AppCompatActivity() {

    private val TAG = forecast::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.forecast,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_refresh -> {
                toast("Refreshing Location Request ")
                // Fetch Weather Request
                FecthWeatherTask().execute("Abidjan")
            }
        }

        return super.onOptionsItemSelected(item)
    }

    /*
    *   AsyncTask for Handling Location Network Request
     */
      inner class FecthWeatherTask : AsyncTask<String,Void,Array<String>>(){

             override fun doInBackground(vararg p0: String?): Array<String> {

                 val location  =  p0[0]

                 location?.let {
                     val weatherRequestUrl : URL? = NetworkUtils.buildUrl(location)
                     weatherRequestUrl?.let {
                         return try {
                             arrayOf(
                                     NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl)
                             )
                         } catch (ex : IOException){
                             //error("ERROR GETTING WEATHER DATA")
                             throw ex
                         }


                     }


                 }

                 return arrayOf()
             }


          override fun onPostExecute(result: Array<String>?) {
              result?.let {

                  result.forEach {
                      tv_weather_data.append(it)
                  }
                  Log.v(TAG, result[0])
              }
              super.onPostExecute(result)
          }


         }




}
