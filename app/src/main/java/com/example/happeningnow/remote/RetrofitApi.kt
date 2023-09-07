package com.example.happeningnow.remote

import com.example.happeningnow.models.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
    @GET(Urls.TOP_STORIES)
    fun TOP_STORIES(@Query("api-key") apiKey:String): Observable<NewsResponse>

    @GET(Urls.MOST_VIEWED)
    fun MOST_VIEWED(@Query("api-key") apiKey:String):Observable<NewsResponse>
}