package com.challenger.data.mappers

import com.challenger.data.utils.JokeFactory
import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ResponseJokeEntityMapperTest{
    private lateinit var jokeEntityMapper: JokeEntityMapper
    private lateinit var responseJokeEntityMapper: ResponseJokeEntityMapper

    @Before
    fun setUp() {
        jokeEntityMapper = JokeEntityMapper()
        responseJokeEntityMapper = ResponseJokeEntityMapper(jokeEntityMapper)
    }

    @Test
    fun test_map_from__response_joke_entity_to_joke() {
        val jokeResponseEntity = JokeFactory.makeJokeReponseEntity(10)

        val jokes = responseJokeEntityMapper.mapFromRemote( jokeResponseEntity)

        val jokeEntities = jokeResponseEntity.value

        for (i in 0 until jokeEntities.size){
            assertEquals(jokeEntities[i].id, jokes[i].id)
            assertEquals(jokeEntities[i].joke, jokes[i].joke)
            assertArrayEquals(jokeEntities[i].categories.toTypedArray(), jokes[i].categories.toTypedArray())
        }



    }
}