package com.tao.movieretrodemo

import com.tao.movieretrodemo.poulardata.PopularResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.GET_POPULAR_END_POINT)
    fun getPopular(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("api_key") api_key: String
    ): Call<PopularResponse>
}