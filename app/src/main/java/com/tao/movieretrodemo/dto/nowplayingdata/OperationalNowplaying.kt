package com.tao.movieretrodemo.nowplayingdata

interface OperationalNowplaying {
    fun onSuccessNow(nowplayingResponse: NowplayingResponse)
    fun onFailureNow(message: String)
}