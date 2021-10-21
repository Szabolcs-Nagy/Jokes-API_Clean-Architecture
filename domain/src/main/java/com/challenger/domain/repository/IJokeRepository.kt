package com.challenger.domain.repository

import com.challenger.domain.models.Joke
import io.reactivex.Single

/**
 * Implementation of the [IJokeRepository] interface to provide a means of communicating
 * with the data layer
 */
interface IJokeRepository{

    fun getRandomJokes(numJokes: Int, exclude: String): Single<List<Joke>>
}