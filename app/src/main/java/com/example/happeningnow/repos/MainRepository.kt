package com.example.happeningnow.repos

import com.example.happeningnow.remote.RetrofitApi
import com.example.happeningnow.remote.RetrofitClient


open class MainRepository {

    companion object {

        val API_KEY = "WkroajQS0QZQwUG3z2Li5JSZJM9Pr7Jo"
        val RETROFIT_API = RetrofitClient.getClient().create(RetrofitApi::class.java)

    }
}