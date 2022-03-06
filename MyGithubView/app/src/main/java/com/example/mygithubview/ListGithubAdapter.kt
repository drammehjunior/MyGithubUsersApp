package com.example.mygithubview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListGithubAdapter(private val listGithub: ArrayList<Github>): RecyclerView.Adapter<ListGithubAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_githubuser, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username, photo) = listGithub[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvUsername.text = username
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listGithub[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int = listGithub.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Github)
    }
}