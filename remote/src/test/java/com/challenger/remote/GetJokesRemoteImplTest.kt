package com.challenger.remote


import com.challenger.data.models.ResponseJokesEntity
import com.challenger.remote.utils.DataFactory
import com.challenger.remote.utils.GetJokesFactory
import com.challenger.remote.utils.GetJokesFactory.Factory.makeJokeReponseEntity
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
 class GetJokesRemoteImplTest{
    private lateinit var apiService: ApiService
    private lateinit var getJokesRemoteImpl: GetJokesRemoteImpl

    @Before
    fun setup() {
        apiService = mock()
        getJokesRemoteImpl = GetJokesRemoteImpl(apiService)
    }

    @Test
    fun get_random_jokes_completes_not_errors() {
        val jokeResponseEntity =makeJokeReponseEntity(10)

        stubWheneverThenReturn(Single.just(jokeResponseEntity))

       val testObserver = getJokesRemoteImpl.getRandomJokes(DataFactory.randomInt(), "").test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

    @Test
    fun get_random_jokes_returns_data() {
        val jokeResponseEntity =makeJokeReponseEntity(10)

        stubWheneverThenReturn(Single.just(jokeResponseEntity))
        val testObserver = getJokesRemoteImpl.getRandomJokes(DataFactory.randomInt(),"").test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(jokeResponseEntity)

    }

    private fun stubWheneverThenReturn(single: Single<ResponseJokesEntity>){
        whenever(apiService.getRandomJokes(any(), any()))
            .thenReturn(single)
    }

}