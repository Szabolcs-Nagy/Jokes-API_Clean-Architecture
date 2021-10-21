package com.challenger.data.source

import com.challenger.data.models.ResponseJokesEntity
import io.reactivex.Single

interface IJokeDataStore {
    fun getRandomJokes(numJokes: Int, exclude: String) : Single<ResponseJokesEntity>
}