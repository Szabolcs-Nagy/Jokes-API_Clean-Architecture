package com.challenger.data.source

import com.challenger.data.models.ResponseJokesEntity
import com.challenger.data.utils.DataFactory
import com.challenger.data.utils.JokeFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class JokeRemoteDataStoreTest{
    private lateinit var jokeRemote: IJokeRemote
     private lateinit var jokeRemoteDataStore: JokeRemoteDataStore

    @Before
    fun setUp() {
        jokeRemote = mock()
        jokeRemoteDataStore = JokeRemoteDataStore(jokeRemote)
    }

    @Test
    fun get_jokes_use_case_completes_without_errors() {
        stubWheneverThenReturn(Single.just(JokeFactory.makeJokeReponseEntity(10)))
        val testObserver = jokeRemoteDataStore.getRandomJokes(DataFactory.randomInt(), "").test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

    @Test
    fun get_jokes_use_case_returns_data() {
        val responseJokesEntity = JokeFactory.makeJokeReponseEntity(10)
        stubWheneverThenReturn(Single.just(responseJokesEntity))
        val testObserver = jokeRemoteDataStore.getRandomJokes(DataFactory.randomInt(), "").test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(responseJokesEntity)
    }


    private fun stubWheneverThenReturn(single: Single<ResponseJokesEntity>){
        whenever(jokeRemote.getRandomJokes(any(),any()))
            .thenReturn(single)
    }



}