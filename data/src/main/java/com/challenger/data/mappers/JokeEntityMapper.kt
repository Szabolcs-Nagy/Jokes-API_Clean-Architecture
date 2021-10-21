package com.challenger.data.mappers

import com.challenger.data.models.JokeEntity
import com.challenger.domain.models.Joke

class JokeEntityMapper : EntityMapper<JokeEntity, Joke>() {

    override fun mapFromRemote(jokeEntity: JokeEntity): Joke {
        return Joke(id = jokeEntity.id, joke = jokeEntity.joke, categories = jokeEntity.categories)
    }




}