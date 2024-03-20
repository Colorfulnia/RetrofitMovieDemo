package com.tao.movieretrodemo.nowplayingdata

data class NowplayingResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)