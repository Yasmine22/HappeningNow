package com.example.happeningnow.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.happeningnow.models.NewsModel
import com.example.happeningnow.models.NewsResponse
import com.example.happeningnow.repos.TopStoriesRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class TopStoriesViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var repository: TopStoriesRepository
    var topStories:MutableLiveData<List<NewsModel>> = MutableLiveData()
    var errorMessage:MutableLiveData<String> = MutableLiveData()
    fun getTopStories() {

        val result = repository.getTopStories().subscribe(object : Observer<NewsResponse> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(newsAPIResponse: NewsResponse) {

                topStories.value = newsAPIResponse.results

            }

            override fun onError(e: Throwable) {

                errorMessage.value = e.message
            }

            override fun onComplete() {
            }
        })
    }
}