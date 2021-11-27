package com.ilhmdhn.imageslider

import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ilhmdhn.imageslider.databinding.VideoGameBinding
import com.ilhmdhn.imageslider.model.ResultsItemMovie
import android.graphics.Bitmap
import java.net.URL


class VideoPagerAdapter: RecyclerView.Adapter<VideoPagerAdapter.ListViewHolder>() {

    private var listData = ArrayList<ResultsItemMovie>()

    fun setData(newListData: List<ResultsItemMovie>?){
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): VideoPagerAdapter.ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.video_game, parent, false))
    }

    override fun onBindViewHolder(holder: VideoPagerAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = VideoGameBinding.bind(itemView)
        fun bind(data: ResultsItemMovie){
            val mediaController = MediaController(itemView.context)
            mediaController.show(5000)
            with(binding){
                videoGame.setMediaController(mediaController)
                videoGame.setVideoURI(Uri.parse(data.dataMovie.jsonMember480))
                videoGame.requestFocus()
                videoGame.seekTo(1)
            }
        }
    }

    override fun getItemCount(): Int = listData.size
}