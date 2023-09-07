package com.example.happeningnow.repos

import com.example.happeningnow.models.NewsResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopStoriesRepository @Inject constructor(): MainRepository() {

    fun getTopStories():Observable<NewsResponse> {
        return RETROFIT_API.TOP_STORIES(API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}