package com.challenger.data.suite

import com.challenger.data.mappers.JokeEntityMapperTest
import com.challenger.data.source.JokeRemoteDataStoreTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(

    JokeRemoteDataStoreTest::class,
    JokeEntityMapperTest::class

)
class JokeSuite