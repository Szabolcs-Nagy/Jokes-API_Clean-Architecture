package com.challenger.jokes_challenger_api_clean_archichecture.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.challenger.jokes_challenger_api_clean_archichecture.R
import com.challenger.jokes_challenger_api_clean_archichecture.ui.home.HomeActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class HomeActivityTest{

    @get:Rule
    val activityRule = ActivityTestRule(HomeActivity::class.java)


    @Test
    fun test_home_activity_is_opened_not_errors() {
        onView(withId(R.id.homeActivity)).check( matches(ViewMatchers.isDisplayed()) )
    }






}