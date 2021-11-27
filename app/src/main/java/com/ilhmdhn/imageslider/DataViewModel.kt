package com.ilhmdhn.imageslider

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilhmdhn.imageslider.data.ApiConfig
import com.ilhmdhn.imageslider.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataViewModel: ViewModel() {
    fun getSS(): LiveData<List<ResultsImageItem>> = getSSGame()
    fun getMovie(): LiveData<List<ResultsItemMovie>> = getMovieGame()
}

    fun getSSGame(): LiveData<List<ResultsImageItem>>{
        val ssData = MutableLiveData<List<ResultsImageItem>>()
        val client = ApiConfig.getApiService().getScreenshot()
        client.enqueue(object: Callback<ImageResponse> {
            override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
                val responseBody = response.body()
                ssData.postValue(responseBody?.results)
            }

            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                Log.e("DataViewModel", "onFailure: ${t.message}")
            }
        })
    return ssData
    }

    fun getMovieGame(): LiveData<List<ResultsItemMovie>>{
        val gameMovie = MutableLiveData<List<ResultsItemMovie>>()
        ApiConfig.getApiService().getMovie().enqueue(object:Callback<TrailerResponse>{
            override fun onResponse(call: Call<TrailerResponse>, response: Response<TrailerResponse>) {
                val responseBody = response.body()
                gameMovie.postValue(responseBody?.results)
            }

            override fun onFailure(call: Call<TrailerResponse>, t: Throwable) {
                Log.e("DataViewModel", "onFailure: ${t.message}")
            }
        })

        return gameMovie
    }
