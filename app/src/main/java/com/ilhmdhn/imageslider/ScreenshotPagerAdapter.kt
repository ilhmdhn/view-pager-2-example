package com.ilhmdhn.imageslider

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ilhmdhn.imageslider.databinding.ImageGameDetailBinding
import com.ilhmdhn.imageslider.model.ResultsImageItem
import java.util.*


class ScreenshotPagerAdapter: RecyclerView.Adapter<ScreenshotPagerAdapter.ListViewHolder>() {

    private var listData = ArrayList<ResultsImageItem>()

    fun setData(newListData: List<ResultsImageItem>?){
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_game_detail, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ImageGameDetailBinding.bind(itemView)
        fun bind(data: ResultsImageItem){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgGame)
            }
        }
    }

    override fun getItemCount(): Int = listData.size
}