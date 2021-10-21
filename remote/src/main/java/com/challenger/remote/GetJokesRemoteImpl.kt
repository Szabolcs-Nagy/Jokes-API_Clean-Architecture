package com.challenger.remote

import com.challenger.data.models.ResponseJokesEntity
import com.challenger.data.source.IJokeRemote
import io.reactivex.Single

class GetJokesRemoteImpl(private val apiService: ApiService) : IJokeRemote {
    override fun getRandomJokes(numJokes: Int, excludeCategory :String): Single<ResponseJokesEntity> {
        return apiService.getRandomJokes(numJokes,excludeCategory)
    }
}