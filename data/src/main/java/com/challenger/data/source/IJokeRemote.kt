package com.challenger.data.source

import com.challenger.data.models.ResponseJokesEntity
import io.reactivex.Single

/**
 * Implementation of the [IJokeRemote] interface to provide a means of communicating
 * with the remote data source
 */
interface IJokeRemote {
    fun getRandomJokes(numJokes: Int,excludeCategory :String) : Single<ResponseJokesEntity>
}

