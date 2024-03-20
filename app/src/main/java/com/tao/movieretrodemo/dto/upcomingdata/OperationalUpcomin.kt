package com.tao.movieretrodemo.upcomingdata

interface OperationalUpcomin{

    fun onSuccessUp(upcomingResponse: UpcomingResponse)
    fun onFailureUp(message: String)
}