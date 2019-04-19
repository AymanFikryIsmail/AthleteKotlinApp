package com.iti.android.athleteapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import com.iti.android.athleteapp.adapter.AthleteAdapter
import com.iti.android.athleteapp.model.AthleteResponse
import com.iti.android.athleteapp.networkmanager.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.support.v7.widget.LinearLayoutManager



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }
    fun getData() {

        var apiCall=ApiInterface.createApi()
        apiCall.getAthletes().enqueue(object : Callback<AthleteResponse> {
            override fun onResponse(call: Call<AthleteResponse>?, response: Response<AthleteResponse>?) {
                val result= response?.body()?.athletes
                val mLayoutManager = LinearLayoutManager(this@MainActivity)

                val adapter= AthleteAdapter(applicationContext, result!!)
                recycler_view.layoutManager = mLayoutManager
                recycler_view.adapter = adapter

            }

            override fun onFailure(call: Call<AthleteResponse>?, t: Throwable?) {
                Toast.makeText(applicationContext,"error",Toast.LENGTH_LONG).show()
            }
        }



        )


    }


}
