package com.challenger.data.source

import com.challenger.data.models.ResponseJokesEntity
import io.reactivex.Single



class JokeRemoteDataStore(private val jokeRemote: IJokeRemote) : IJokeDataStore {

    override fun getRandomJokes(numJokes: Int, exclude: String): Single<ResponseJokesEntity> {
         return jokeRemote.getRandomJokes(numJokes, exclude)
    }

}