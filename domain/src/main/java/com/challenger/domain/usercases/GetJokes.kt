package com.challenger.domain.usercases

import com.challenger.domain.models.Joke
import com.challenger.domain.repository.IJokeRepository
import io.reactivex.Single
import com.challenger.domain.executor.PostExecutionThread
import com.challenger.domain.executor.ThreadExecutor
import com.challenger.domain.utils.OpenForTesting


@OpenForTesting
class GetJokes(private val jokeRepository: IJokeRepository,
               threadExecutor: ThreadExecutor,
               postExecutionThread: PostExecutionThread
): SingleUseCase<List<Joke>, Int,String>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(numJokes: Int?, exclude:String?): Single<List< Joke>> {
        return jokeRepository.getRandomJokes(numJokes = numJokes!!, exclude =exclude!!)
    }




}