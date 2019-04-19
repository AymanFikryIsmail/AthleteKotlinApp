package com.iti.android.athleteapp.networkmanager

import com.iti.android.athleteapp.model.AthleteResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ayman on 2019-04-10.
 */
interface ApiInterface {

    @GET("MohamedWael/1406437f14e9a769a3a572a78906388f/raw/5be50e67c96c5ed1da9fe6344d2dd7befef0ba25/")
    fun getAthletes():Call<AthleteResponse>

    companion object {

        fun createApi():ApiInterface{
            val retrofit= Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://gist.githubusercontent.com/").build()

            return retrofit.create(ApiInterface::class.java)

        }
    }
}