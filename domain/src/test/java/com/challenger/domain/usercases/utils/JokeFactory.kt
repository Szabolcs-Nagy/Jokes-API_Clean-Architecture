package com.challenger.domain.usercases.utils

import com.challenger.domain.models.Joke


class JokeFactory {

    companion object Factory {


        fun makeJokeResponse(): Joke {

            val joke = Joke(
                id = DataFactory.randomInt(),
                joke = DataFactory.randomUuid(),
                categories = DataFactory.makeStringList(2)
            );

            return joke
        }

        fun makeJokeListResponse(count: Int): List<Joke> {
            val list = arrayListOf<Joke>()
            for (i in 0 until count) {
                list.add(makeJokeResponse())
            }

            return list
        }





    }


}