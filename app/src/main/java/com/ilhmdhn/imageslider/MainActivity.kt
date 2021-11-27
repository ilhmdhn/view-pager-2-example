package com.ilhmdhn.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.viewpager2.widget.ViewPager2
import com.ilhmdhn.imageslider.databinding.ActivityMainBinding
import me.relex.circleindicator.CircleIndicator2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    private val imageAdapter = ScreenshotPagerAdapter()
    private val videoAdapter = VideoPagerAdapter()

    private lateinit var viewModel: DataViewModel

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this)[DataViewModel::class.java]

        viewModel.getSS().observe(this, {result ->
            imageAdapter.setData(result)
            binding?.indicator?.setViewPager(binding?.viewPagerImage)
        })

        viewModel.getMovie().observe(this, {resultMovie ->
            videoAdapter.setData(resultMovie)
            binding?.gameIndicator?.setViewPager(binding?.viewPagerVideo)
        })

        binding?.viewPagerImage?.adapter = imageAdapter
        binding?.viewPagerVideo?.adapter = videoAdapter
    }
}