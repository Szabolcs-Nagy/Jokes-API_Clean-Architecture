package com.challenger.data.mappers

import com.challenger.data.models.JokeEntity
import com.challenger.data.models.ResponseJokesEntity
import com.challenger.domain.models.Joke

class ResponseJokeEntityMapper(val jokeEntityMapper: JokeEntityMapper) : EntityMapper<ResponseJokesEntity,  List <Joke>>() {
    override fun mapFromRemote(type: ResponseJokesEntity): List<Joke> {
            return jokeEntityMapper.mapFromRemote(type.value)
    }


}