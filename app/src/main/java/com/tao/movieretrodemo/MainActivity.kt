package com.tao.movieretrodemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tao.movieretrodemo.databinding.ActivityMainBinding
import com.tao.movieretrodemo.poulardata.PopularResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)

        apiService = RetrofitBuilder.getRetrofit().create(ApiService::class.java)
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        apiService.getPopular("en-US", 1, Constants.API_KEY).enqueue(object : Callback<PopularResponse> {
            override fun onResponse(call: Call<PopularResponse>, response: Response<PopularResponse>) {
                if (response.isSuccessful) {
                    val movies = response.body()?.results ?: emptyList()
                    binding.moviesRecyclerView.adapter = MoviesAdapter(movies)
                }
            }

            override fun onFailure(call: Call<PopularResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}

