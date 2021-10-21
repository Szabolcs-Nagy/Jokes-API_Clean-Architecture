package com.challenger.data.mappers

import com.challenger.data.utils.JokeFactory
import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class JokeEntityMapperTest{
    private lateinit var jokeEntityMapper: JokeEntityMapper

    @Before
    fun setUp() {
        jokeEntityMapper = JokeEntityMapper()
    }

    @Test
    fun test_map_from_joke_entity_to_joke() {
        val jokeEntity = JokeFactory.makeJokeEntityResponse()
        val joke = jokeEntityMapper.mapFromRemote(jokeEntity = jokeEntity)

        assertEquals(jokeEntity.id, joke.id)
        assertEquals(jokeEntity.joke, joke.joke)
        assertArrayEquals(jokeEntity.categories.toTypedArray(), joke.categories.toTypedArray())
    }
}