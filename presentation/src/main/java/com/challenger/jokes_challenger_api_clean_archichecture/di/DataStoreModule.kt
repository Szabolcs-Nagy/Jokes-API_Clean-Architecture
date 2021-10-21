package com.challenger.jokes_challenger_api_clean_archichecture.di

import com.challenger.data.source.IJokeDataStore
import com.challenger.data.source.IJokeRemote
import com.challenger.data.source.JokeRemoteDataStore
import com.challenger.remote.GetJokesRemoteImpl
import org.koin.dsl.module

val dataStoresModule = module {
    single<IJokeRemote> { GetJokesRemoteImpl(get()) }
    single<IJokeDataStore> { JokeRemoteDataStore(get()) }
}