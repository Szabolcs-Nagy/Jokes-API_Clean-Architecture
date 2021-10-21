package com.challenger.jokes_challenger_api_clean_archichecture.di

import com.challenger.data.repositories.JokeRepository
import com.challenger.domain.repository.IJokeRepository
import org.koin.dsl.module

val repositoriesModule = module{

    single<IJokeRepository> { JokeRepository(get(), get()) }

}