package com.iti.android.athleteapp.adapter

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iti.android.athleteapp.R
import com.iti.android.athleteapp.model.Athletes
import android.support.v7.widget.CardView
import android.widget.ImageView
import android.widget.TextView
import com.iti.android.athleteapp.DetailsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.athlete_row.view.*


/**
 * Created by ayman on 2019-04-14.
 */
class AthleteAdapter(val context:Context , val ahletes: List<Athletes>?) : RecyclerView.Adapter<AthleteAdapter.AthleteViewholder>() {
    override fun getItemCount(): Int {
       return ahletes?.size!!
    }

    override fun onBindViewHolder(holder: AthleteViewholder?, position: Int) {
       holder?.bind(ahletes?.get(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AthleteViewholder {
       val view =LayoutInflater.from(context).inflate(R.layout.athlete_row,parent, false)
        return  AthleteViewholder(view)
    }

    class AthleteViewholder (itemView: View) : RecyclerView.ViewHolder(itemView) {



        fun bind(athlete : Athletes){
            itemView.nameText.text=athlete.name
            itemView.briefText.text=athlete.brief
            if (athlete.image!="") {
                Picasso.with(itemView.context).load(athlete.image).into(itemView.itemImage)
            }else{
                itemView.itemImage.visibility=View.GONE
            }

            itemView.cardViewCustomGridId.setOnClickListener{
                val intent=Intent(itemView.context, DetailsActivity::class.java )
                intent.putExtra("athlete", athlete)

                intent.setFlags(FLAG_ACTIVITY_NEW_TASK
                )
                itemView.context.startActivity(intent)
            }
        }
    }
}