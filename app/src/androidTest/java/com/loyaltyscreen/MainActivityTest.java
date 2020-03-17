package com.loyaltyscreen;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test_Empty_AllFields() {
        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .check(ViewAssertions.matches(ViewMatchers.withText("")));

        Espresso.onView(ViewMatchers.withId(R.id.lastName))
                .check(ViewAssertions.matches(ViewMatchers.withText("")));

        Espresso.onView(ViewMatchers.withId(R.id.email))
                .check(ViewAssertions.matches(ViewMatchers.withText("")));

        Espresso.onView(ViewMatchers.withId(R.id.phone))
                .check(ViewAssertions.matches(ViewMatchers.withText("")));
    }


    @Test
    public void test_Change_FirstName_EditText() {

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .perform(ViewActions.typeText("Imran"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .check(ViewAssertions.matches(ViewMatchers.withText("Imran")));
    }

    @Test
    public void test_Change_LastName_EditText() {

        Espresso.onView(ViewMatchers.withId(R.id.lastName))
                .perform(ViewActions.typeText("Ali"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.lastName))
                .check(ViewAssertions.matches(ViewMatchers.withText("Ali")));
    }

    @Test
    public void test_Change_Email_EditText() {

        Espresso.onView(ViewMatchers.withId(R.id.email))
                .perform(ViewActions.typeText("imran@abc.com"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.email))
                .check(ViewAssertions.matches(ViewMatchers.withText("imran@abc.com")));
    }

    @Test
    public void test_Change_Phone_EditText() {

        Espresso.onView(ViewMatchers.withId(R.id.phone))
                .perform(ViewActions.typeText("1234567"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.phone))
                .check(ViewAssertions.matches(ViewMatchers.withText("1234567")));
    }

    @Test
    public void test_Visibility_Submit_Button() {

        Espresso.onView(ViewMatchers.withId(R.id.submit))
                .check(ViewAssertions.matches(ViewMatchers.withText(R.string.submit)));
    }

    @Test
    public void test_Error_FirstName_EditText() {

        String error = "Enter a valid First Name, no special characters allowed";

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .perform(ViewActions.typeText("Imran!!"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.submit))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .check(ViewAssertions.matches(
                        ViewMatchers.hasErrorText(error)));

    }

    @Test
    public void test_Error_LastName_EditText() {

        String error = "Enter a valid last name, no special characters allowed";

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .perform(ViewActions.typeText("Imran"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.lastName))
                .perform(ViewActions.typeText("Ali!!"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.submit))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.lastName))
                .check(ViewAssertions.matches(
                        ViewMatchers.hasErrorText(error)));

    }

    @Test
    public void test_Error_Email_EditText() {

        String error = "Enter a valid Email";

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .perform(ViewActions.typeText("Imran"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.lastName))
                .perform(ViewActions.typeText("Ali"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.email))
                .perform(ViewActions.typeText("imranabc.com"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.submit))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.email))
                .check(ViewAssertions.matches(
                        ViewMatchers.hasErrorText(error)));

    }

    @Test
    public void test_Error_Phone_EditText() {

        String error = "Enter a valid Phone, Only allowed non numeric characters";

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .perform(ViewActions.typeText("Imran"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.lastName))
                .perform(ViewActions.typeText("Ali"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.email))
                .perform(ViewActions.typeText("imran@abc.com"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.phone))
                .perform(ViewActions.typeText("123****"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.submit))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.phone))
                .check(ViewAssertions.matches(
                        ViewMatchers.hasErrorText(error)));
    }


    @Test
    public void test_ShowSuccess_Alert() {

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
                .perform(ViewActions.typeText("Imran"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.lastName))
                .perform(ViewActions.typeText("Ali"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.email))
                .perform(ViewActions.typeText("imran@abc.com"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.phone))
                .perform(ViewActions.typeText("1234567"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.submit))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText(R.string.validated_successful))
                .inRoot(RootMatchers.isDialog())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withText(R.string.ok))
                .inRoot(RootMatchers.isDialog())
                .perform(ViewActions.click());
    }



    @After
    public void tearDown() throws Exception {
    }


}