package com.example.appfutbolperu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfutbolperu.R
import com.example.appfutbolperu.models.Team
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.prototype_team.view.*

class TeamAdapter(val teams: List<Team>, val context: Context, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val ivLogo = view.ivLogo
        val tvName = view.tvName
        val cvTeam = view.cvTeam
    }

    interface OnItemClickListener {
        fun onItemClicked(team: Team)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.prototype_team, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamAdapter.ViewHolder, position: Int) {
        val team = teams[position]
        holder.tvName.text = team.name

        val picBuilder = Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(team.logo).into(holder.ivLogo)

        holder.cvTeam.setOnClickListener {
            itemClickListener.onItemClicked(team)
        }
    }
}