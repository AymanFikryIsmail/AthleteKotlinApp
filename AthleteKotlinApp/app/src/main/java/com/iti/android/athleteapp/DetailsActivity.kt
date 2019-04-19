package com.iti.android.athleteapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.iti.android.athleteapp.model.Athletes
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.athlete_row.view.*


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val i = intent
        val athlete = i.getSerializableExtra("athlete") as Athletes
        nameText.text=athlete.name
        briefText.text=athlete.brief
        if (athlete.image!="") {
            Picasso.with(this@DetailsActivity).load(athlete.image).into(itemImage)
        }else{
            itemImage.visibility= View.GONE
        }

    }
}
