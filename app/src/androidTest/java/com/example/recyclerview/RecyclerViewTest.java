package com.example.recyclerview;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class RecyclerViewTest{

    private  static  final int itemCount=2;                 // Input position
    private static final String toastMsg="Person 3";         // Toast Message
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    
    @Test
    public  void recyclerTest() throws Exception{
        Thread.sleep(2000);
        onView(withId(R.id.recyclerView))
         .perform(RecyclerViewActions.actionOnItemAtPosition(itemCount, click()));
        onView((withText(toastMsg))).inRoot(new ToastMatcher()).check(matches(isDisplayed()));

       /* onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Person 3")), click()));
        onView(withId(R.id.recyclerView))
               .check(matches(hasDescendant(withText("Person 3"))));*/


    }



}
