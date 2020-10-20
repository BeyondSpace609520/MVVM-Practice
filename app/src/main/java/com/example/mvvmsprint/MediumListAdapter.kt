package com.example.mvvmsprint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsprint.model.MovieEntity

class MediumListAdapter: RecyclerView.Adapter<MediumListAdapter.MediumViewHolder>() {
    private var mMovies : List<MovieEntity>

    init {
        mMovies = emptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return MediumViewHolder(view)
    }

    override fun onBindViewHolder(holder: MediumViewHolder, position: Int) {
        val current = mMovies[position]
        holder.title.text = current.title
        holder.year.text = current.year.toString()
    }

    override fun getItemCount(): Int {
        if(mMovies.isNullOrEmpty())
            return 0
        return mMovies.size
    }

    fun setMovies(movies: List<MovieEntity>) {
        mMovies = movies
        notifyDataSetChanged()
    }

    class MediumViewHolder(itemView: View): RecyclerView.ViewHolder(
        itemView
    ) {
        var title: TextView = itemView.findViewById(R.id.title)
        val year: TextView = itemView.findViewById(R.id.title)
    }
}