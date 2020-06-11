package com.sample.app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    private lateinit var stringToBetyped: String

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
    }

    @Test
    fun validateUIActivities() {

        onView((withId(R.id.btnFindMovie))).check(matches(withText("FIND A MOVIE")))

        onView(withId(R.id.btnFindMovie)).perform(click())

        onView(withId(R.id.btnAction)).check(matches(isDisplayed()))
        onView(withId(R.id.btnComedy)).check(matches(isDisplayed()))
        onView(withId(R.id.btnDetective)).check(matches(isDisplayed()))
        onView(withId(R.id.btnDrama)).check(matches(isDisplayed()))
        onView(withId(R.id.btnFantasy)).check(matches(isDisplayed()))
        onView(withId(R.id.btnHorror)).check(matches(isDisplayed()))
        onView(withId(R.id.btnRand)).check(matches(isDisplayed()))
    }
}