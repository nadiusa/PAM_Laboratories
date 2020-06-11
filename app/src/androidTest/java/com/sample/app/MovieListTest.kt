package com.sample.app

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieListTest {
    private lateinit var stringToBetyped: String

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
    }

    @Test
    fun validateRecyclerView() {

        onView(withId(R.id.btnFindMovie)).perform(click())
        onView(withId(R.id.btnAction)).perform(click())

        Thread.sleep(500)

        onView(ViewMatchers.withId(R.id.feed_recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )

        onView(withId(R.id.movieTitle)).check(matches(isDisplayed()))

        onView(withText("Movie Title"))
            .perform(scrollTo())
            .check(matches(isDisplayed()))
        onView(withText("Movie Overview")).check(matches(isDisplayed()))
            .perform(scrollTo())
        onView(withText("User Rating"))
            .perform(scrollTo())
            .check(matches(isDisplayed()))
        onView(withText("Release Date"))
            .perform(scrollTo())
            .check(matches(isDisplayed()))
        onView(withText("Popularity"))
            .perform(scrollTo())
            .check(matches(isDisplayed()))

    }
}