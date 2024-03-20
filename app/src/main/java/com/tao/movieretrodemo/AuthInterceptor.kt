package com.tao.movieretrodemo

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val currentRequest = chain.request().newBuilder()
        currentRequest.addHeader("Authorization", "Bearer ${Constants.API_KEY}")
        val newRequest = currentRequest.build()
        return chain.proceed(newRequest)
    }
}