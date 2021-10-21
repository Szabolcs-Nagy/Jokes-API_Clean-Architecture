package com.challenger.jokes_challenger_api_clean_archichecture.suite


import com.challenger.jokes_challenger_api_clean_archichecture.viewmodels.JokesViewModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    JokesViewModelTest::class
)
class GetJokesSuite