package com.slack.jeanpokou.sunshine.data

import android.content.Context


object  SunshinePreferences {

    // Human Readable string for location
     val PREF_CITY_NAME = "city_name"

    val PREF_COORD_LAT = "coord_lat"
    val PREF_COORD_LONG = "coord_long"

    private  val DEFAULT_WEATHER_LOCATION = "94043, USA"
    private val DEFAULT_WEATHER_COORDINATES = arrayOf(37.4284,122.0724)

    private val DEFAULT_MAP_LOCATION = "1600 Amphitheatre Parkway, Mountain View, CA 94043"


    fun setLocationDetails(ctx: Context, cityName:String, lat: Double, lon:Double) {


    }





}
