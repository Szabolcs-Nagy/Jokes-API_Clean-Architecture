package com.challenger.remote.utils

import com.challenger.data.models.JokeEntity
import com.challenger.data.models.ResponseJokesEntity

class GetJokesFactory {

    companion object Factory {

        fun makeJokeEntityResponse(): JokeEntity {

            val jokeEntity = JokeEntity(
                id = DataFactory.randomInt(),
                joke = DataFactory.randomUuid(),
                categories = DataFactory.makeStringList(2)
            );

            return jokeEntity
        }

       fun makeJokeEntityListResponse(count: Int) : List<JokeEntity>{
           val list = arrayListOf<JokeEntity>()
           for (i in 0 until count){
               list.add(makeJokeEntityResponse())
           }

           return list
       }

        fun makeJokeReponseEntity(numJokes: Int) =
            run { ResponseJokesEntity(DataFactory.randomUuid(), makeJokeEntityListResponse(numJokes)) }

    }


}