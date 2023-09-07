package com.example.happeningnow.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.happeningnow.models.NewsModel
import com.example.happeningnow.models.NewsResponse
import com.example.happeningnow.repos.MostViewedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MostViewedViewModel @Inject constructor() : ViewModel() {
    @Inject lateinit var repository: MostViewedRepository
    val mostViewedNews = MutableLiveData<List<NewsModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getMostViewed(){
       val result = repository.getMostViewed().subscribe(object : Observer<NewsResponse> {
           override fun onSubscribe(d: Disposable) {
           }

           override fun onNext(newsAPIResponse: NewsResponse) {

               mostViewedNews.value = newsAPIResponse.results

           }

           override fun onError(e: Throwable) {

               errorMessage.value = e.message
           }

           override fun onComplete() {
           }
    })
    }

}