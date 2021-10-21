package com.challenger.remote


import com.challenger.data.models.ResponseJokesEntity
import com.challenger.remote.utils.*
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @GET(GET_RANDOM_JOKES)
     fun getRandomJokes(
        @Path(PATH_JOKE)  numJokes:Int,
        @Query(PATH_EXCLUDE) excludeCategory :String
    ) : Single<ResponseJokesEntity>

}