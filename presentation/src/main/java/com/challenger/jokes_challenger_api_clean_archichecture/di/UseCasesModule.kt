package com.challenger.jokes_challenger_api_clean_archichecture.di

import com.challenger.domain.executor.JobExecutor
import com.challenger.domain.usercases.GetJokes
import com.challenger.jokes_challenger_api_clean_archichecture.executor.UiThread
import org.koin.dsl.module

val useCasesModule = module {
    single { GetJokes(get(), JobExecutor(),
        UiThread()
    ) }
}