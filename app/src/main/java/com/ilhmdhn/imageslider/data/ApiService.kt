package com.ilhmdhn.imageslider.data

import com.ilhmdhn.imageslider.model.ImageResponse
import com.ilhmdhn.imageslider.model.TrailerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{id}/screenshots")
    fun getScreenshot(
        @Path("id") id: Int = 3498,
        @Query("key") key: String = "98079ded05f849ae95c78ca9655572ae"
    ): Call<ImageResponse>

    @GET("{id}/movies")
    fun getMovie(
        @Path("id") id: Int = 3498,
        @Query("key") key: String = "98079ded05f849ae95c78ca9655572ae"
    ): Call<TrailerResponse>
}