package com.slack.jeanpokou.sunshine.utilities

import android.net.Uri
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

object NetworkUtils {

    private val TAG = NetworkUtils::class.java.simpleName

    //private val DYNAMIC_WEATHER_URL = "https://andfun-weather.udacity.com/weather"
    private val JEANPOKOU_OPENWEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast"

    private val FORECAST_BASE_URL = JEANPOKOU_OPENWEATHER_URL

    /*
     * NOTE: These values only effect responses from OpenWeatherMap, NOT from the fake weather
     * server. They are simply here to allow us to teach you how to build a URL if you were to use
     * a real API.If you want to connect your app to OpenWeatherMap's API, feel free to! However,
     * we are not going to show you how to do so in this course.
     */

    /* The format we want our API to return */
    private val format = "json"
    /* The units we want our API to return */
    private val units = "metric"
    /* The number of days we want our API to return */
    private val numDays = 14
    /* APIKEY for Open Weather Data*/
    private val APIKEY= "35e5a76f59f2f5c1d6e4ba7939944535"

    internal val QUERY_PARAM = "q"
    internal val LAT_PARAM = "lat"
    internal val LON_PARAM = "lon"
    internal val FORMAT_PARAM = "mode"
    internal val UNITS_PARAM = "units"
    internal val DAYS_PARAM = "cnt"
    internal val API_ID = "APPID"




    /**
     * Builds the URL used to talk to the weather server using a location. This location is based
     * on the query capabilities of the weather provider that we are using.
     *
     * @param locationQuery The location that will be queried for.
     * @return The URL to use to query the weather server.
     */
    @Throws (MalformedURLException::class)
    fun buildUrl(locationQuery: String): URL {
        val uri = Uri.parse(FORECAST_BASE_URL)
                .buildUpon()
                .appendQueryParameter(QUERY_PARAM, locationQuery)
                .appendQueryParameter(API_ID, APIKEY)
                .appendQueryParameter(FORMAT_PARAM, format)
                .appendQueryParameter(UNITS_PARAM, units)
                .appendQueryParameter(DAYS_PARAM, numDays.toString())
                .build()


         return try {
             Log.v(TAG, uri.toString())
             getURL(uri.toString())
        } catch (ex: MalformedURLException) {
             error( "Error building location url")
        }
    }


    private  fun getURL (url : String ) : URL {
        return  URL(url)
    }

    /**
     * Builds the URL used to talk to the weather server using latitude and longitude of a
     * location.
     *
     * @param lat The latitude of the location
     * @param lon The longitude of the location
     * @return The Url to use to query the weather server.
     */
    fun buildUrl(lat: Double?, lon: Double?): URL? {
        /** This will be implemented in a future lesson  */
        return null
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url: URL): String {
        val connection = url.openConnection() as HttpURLConnection
        return connection.inputStream.bufferedReader().use {
            it.readText()
        }
    }
}




