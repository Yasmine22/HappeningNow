package com.example.happeningnow.repos

import com.example.happeningnow.models.NewsResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MostViewedRepository @Inject constructor() : MainRepository() {

    fun getMostViewed(): Observable<NewsResponse> {
        return RETROFIT_API.MOST_VIEWED(API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}