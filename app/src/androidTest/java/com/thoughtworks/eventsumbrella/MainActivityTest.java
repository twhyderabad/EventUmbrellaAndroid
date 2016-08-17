package com.thoughtworks.eventsumbrella;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void shouldDisplayOneName() {
        onView(withText(startsWith("Artificial"))).check(matches(withText(containsString("Anup"))));
    }

    @Test
    public void shouldDisplayTwoName() {
        onView(withText(startsWith("Evolution"))).check(matches(withText(containsString("Jonnalagadda"))));
    }
}
