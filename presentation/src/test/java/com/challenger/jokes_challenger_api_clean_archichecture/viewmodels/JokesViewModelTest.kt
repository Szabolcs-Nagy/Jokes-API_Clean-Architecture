package com.challenger.jokes_challenger_api_clean_archichecture.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MediatorLiveData
import com.challenger.domain.models.Joke
import com.challenger.domain.usercases.GetJokes
import com.challenger.domain.usercases.utils.DataFactory
import com.challenger.domain.usercases.utils.JokeFactory
import com.challenger.jokes_challenger_api_clean_archichecture.utils.Resource
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.ext.getScopeId
import java.lang.RuntimeException

@RunWith(JUnit4::class)
class JokesViewModelTest {
    private lateinit var mockGetJokesUseCase: GetJokes
    private lateinit var jokesViewModel: JokesViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        mockGetJokesUseCase = mock()
        jokesViewModel =
            JokesViewModel(
                mockGetJokesUseCase
            )
    }


    @Test
    fun `test_loading_is_emitted`() {
        stubWheneverThenReturn(Single.just(JokeFactory.makeJokeListResponse(10)))
        jokesViewModel.getJokes(DataFactory.randomInt(),"")

        val mediatorLiveData = MediatorLiveData<Resource<Joke>>()
        mediatorLiveData.addSource(jokesViewModel.get_jokes_random) { result ->
             assertTrue ( result is Resource.Loading )
        }

    }

    @Test
    fun test_error_is_emitted() {
        stubWheneverThenReturn(Single.error(RuntimeException()))
        jokesViewModel.getJokes(DataFactory.randomInt(),"")

        val mediatorLiveData = MediatorLiveData<Resource<Joke>>()
        mediatorLiveData.addSource(jokesViewModel.get_jokes_random) { result ->
            assertTrue ( result is Resource.Error )
        }
    }

    @Test
    fun test_data_is_emitted_success() {
        val jokeList = JokeFactory.makeJokeListResponse(10)
        stubWheneverThenReturn(Single.just(jokeList))
        jokesViewModel.getJokes(DataFactory.randomInt(),"")

        val mediatorLiveData = MediatorLiveData<Resource<Joke>>()
        mediatorLiveData.addSource(jokesViewModel.get_jokes_random) { result ->
            when(result) {
                is Resource.Success -> {
                   val joke = result.result
                    assertArrayEquals(joke.toTypedArray(), jokeList.toTypedArray())

                }

            }

        }
    }

    private fun stubWheneverThenReturn(single: Single<List<Joke>>) {
        whenever(mockGetJokesUseCase.buildUseCaseObservable(any(),any()))
            .thenReturn(single)
    }

}