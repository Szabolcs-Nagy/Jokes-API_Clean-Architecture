package com.challenger.jokes_challenger_api_clean_archichecture.di

import com.challenger.data.mappers.JokeEntityMapper
import com.challenger.data.mappers.ResponseJokeEntityMapper
import org.koin.dsl.module

val mappers = module {
    single { JokeEntityMapper() }

    single { ResponseJokeEntityMapper(get()) }
}