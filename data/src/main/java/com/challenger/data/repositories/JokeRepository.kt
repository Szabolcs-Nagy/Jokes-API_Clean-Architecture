package com.challenger.data.repositories

import com.challenger.data.mappers.ResponseJokeEntityMapper
import com.challenger.data.source.IJokeDataStore
import com.challenger.domain.models.Joke
import com.challenger.domain.repository.IJokeRepository
import io.reactivex.Single




class JokeRepository(private val jokeRemoteDataSource: IJokeDataStore, private val jokeResponseJokeEntityMapper: ResponseJokeEntityMapper) :
    IJokeRepository {

    override fun getRandomJokes(numJokes: Int, exclude: String): Single<List<Joke>> {
         return jokeRemoteDataSource.getRandomJokes(numJokes, exclude).map { responseJokeEntity->
              jokeResponseJokeEntityMapper.mapFromRemote(responseJokeEntity)
         }
    }


}