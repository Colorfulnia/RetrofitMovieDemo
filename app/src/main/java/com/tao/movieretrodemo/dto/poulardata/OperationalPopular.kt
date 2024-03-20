package com.tao.movieretrodemo.poulardata

interface OperationalPopular {

    fun onSuccessPop(popular: PopularResponse)
    fun onFailurePop(message: String)

}