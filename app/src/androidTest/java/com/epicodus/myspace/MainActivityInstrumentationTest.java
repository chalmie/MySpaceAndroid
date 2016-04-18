package com.epicodus.myspace;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Guest on 4/18/16.
 */
public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.usernameEditText)).perform(typeText("hello")).check(matches(withText("hello")));
    }

    @Test
    public void usernameSentToProfileActivity() {
        String username = "hello";
        onView(withId(R.id.usernameEditText)).perform(typeText(username), closeSoftKeyboard());
        onView(withId(R.id.profileAccessButton)).perform(click());
        onView(withId(R.id.usernameTextView)).check(matches(withText("hello")));

    }
}
