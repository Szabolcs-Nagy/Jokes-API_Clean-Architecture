package com.challenger.domain.usercases

import com.challenger.domain.executor.PostExecutionThread
import com.challenger.domain.executor.ThreadExecutor
import com.challenger.domain.models.Joke
import com.challenger.domain.repository.IJokeRepository
import com.challenger.domain.usercases.utils.DataFactory
import com.challenger.domain.usercases.utils.JokeFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetJokeTest {
    private lateinit var getJokes: GetJokes
    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockGetJokeInfoRepository: IJokeRepository


    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockGetJokeInfoRepository = mock()

        getJokes = GetJokes(mockGetJokeInfoRepository, mockThreadExecutor, mockPostExecutionThread)
    }

    @Test
    fun get_joke_use_case_calls_repository() {
        getJokes.buildUseCaseObservable(DataFactory.randomInt(), "")
        verify(mockGetJokeInfoRepository).getRandomJokes(any(), any())
    }


    @Test
    fun get_joke_use_case_completes_without_errors() {
        stubWheneverThenReturn(Single.just(JokeFactory.makeJokeListResponse(10)))
        val testObserver = getJokes.buildUseCaseObservable(DataFactory.randomInt(),"").test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

    @Test
    fun get_joke_use_case_returns_data() {
        val joke = JokeFactory.makeJokeListResponse(10)
        stubWheneverThenReturn(Single.just(joke))
        val testObserver = getJokes.buildUseCaseObservable(DataFactory.randomInt(), "").test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(joke)
    }


    private fun stubWheneverThenReturn(single: Single<List<Joke>>) {
        whenever(mockGetJokeInfoRepository.getRandomJokes(any(), any()))
            .thenReturn(single)
    }
}