package com.challenger.jokes_challenger_api_clean_archichecture.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenger.domain.models.Joke
import com.challenger.domain.usercases.GetJokes
import com.challenger.jokes_challenger_api_clean_archichecture.utils.OpenForTesting
import com.challenger.jokes_challenger_api_clean_archichecture.utils.Resource
import com.google.gson.JsonParser
import io.reactivex.observers.DisposableSingleObserver
import retrofit2.HttpException

private const val TAG = "JokesViewModel"

@OpenForTesting
class JokesViewModel(private val getJokesUseCase: GetJokes) : ViewModel() {
    private val _get_jokes_random = MutableLiveData<Resource<List <Joke>>>()
    val get_jokes_random = _get_jokes_random


    fun getJokes(numJokes: Int, exclude:String) {
        _get_jokes_random.postValue(Resource.Loading())
        getJokesUseCase.execute(JokesSubscriber(), numJokes, exclude)
    }

    private inner class JokesSubscriber : DisposableSingleObserver< List <Joke>>() {
        override fun onSuccess(joke: List <Joke>) {
            _get_jokes_random.postValue(Resource.Success(joke))
            Log.i(TAG, "REQUEST WAS SUCCESS")
        }

        override fun onError(e: Throwable) {
            _get_jokes_random.postValue(Resource.Error(e.message))
            Log.i(TAG, "ERROR DURING THE REQUEST: ${e.message}")
        }

    }

    override fun onCleared() {
        super.onCleared()
        getJokesUseCase.dispose()
    }
}