package cs321.customstrength;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class WholeAppTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void wholeAppTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.startWorkoutBtn), withText("Start Workout"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.programsBtn), withText("My Programs"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction button = onView(
                withText("+"));
        button.perform(scrollTo(), click());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.programName));
        appCompatEditText.perform(scrollTo(), replaceText("test"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.dayPlusButton), withText("+")));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.weekPlusButton), withText("+")));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction editText = onView(
                withClassName(is("android.widget.EditText")));
        editText.perform(scrollTo(), replaceText("Yolo"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withClassName(is("android.widget.EditText")), isDisplayed()));
        editText2.perform(replaceText("swag arms"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withText("Add Exercise"), isDisplayed()));
        button2.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.numberPicker));
        appCompatEditText2.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.search), withContentDescription("Hint Search"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete.perform(replaceText("arms"), closeSoftKeyboard());

        ViewInteraction searchAutoComplete2 = onView(
                allOf(withId(R.id.search_src_text), withText("arms"),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete2.perform(pressImeActionButton());

        ViewInteraction searchAutoComplete3 = onView(
                allOf(withId(R.id.search_src_text), withText("arms"),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete3.perform(replaceText("arm"), closeSoftKeyboard());

        ViewInteraction searchAutoComplete4 = onView(
                allOf(withId(R.id.search_src_text), withText("arm"),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete4.perform(pressImeActionButton());

        ViewInteraction button3 = onView(
                withText("ARM CIRCLES"));
        button3.perform(scrollTo(), click());

        ViewInteraction editText3 = onView(
                allOf(withClassName(is("android.widget.EditText")),
                        withParent(withId(R.id.volumeAndIntensity))));
        editText3.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withText("Save"),
                        withParent(withId(R.id.volumeAndIntensity))));
        button4.perform(scrollTo(), click());

        ViewInteraction button5 = onView(
                allOf(withText("Add Exercise"), isDisplayed()));
        button5.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                withId(R.id.numberPicker));
        appCompatEditText3.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.search), withContentDescription("Hint Search"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction searchAutoComplete5 = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete5.perform(replaceText("arm"), closeSoftKeyboard());

        ViewInteraction searchAutoComplete6 = onView(
                allOf(withId(R.id.search_src_text), withText("arm"),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete6.perform(pressImeActionButton());

        ViewInteraction button6 = onView(
                withText("TWO-ARM KETTLEBELL MILITARY PRESS"));
        button6.perform(scrollTo(), click());

        ViewInteraction editText4 = onView(
                allOf(withClassName(is("android.widget.EditText")),
                        withParent(withId(R.id.volumeAndIntensity))));
        editText4.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withClassName(is("android.widget.EditText")),
                        withParent(withId(R.id.volumeAndIntensity))));
        editText5.perform(scrollTo(), replaceText("25"), closeSoftKeyboard());

        ViewInteraction button7 = onView(
                allOf(withText("Save"),
                        withParent(withId(R.id.volumeAndIntensity))));
        button7.perform(scrollTo(), click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withText("Save"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction button8 = onView(
                allOf(withText("test"),
                        withParent(withId(R.id.programLayout))));
        button8.perform(scrollTo(), click());

        ViewInteraction button9 = onView(
                allOf(withText("test:\nYolo:\nswag arms:\n1. ARM CIRCLES\n2. TWO-ARM KETTLEBELL MILITARY PRESS\n\n"),
                        withParent(withId(R.id.programLayout))));
        button9.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.startWorkoutBtn), withText("Start Workout"), isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withText("Start Workout"), isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withText("ARM CIRCLES"),
                        childAtPosition(
                                withId(R.id.currentProgramWeeksList),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withText("TWO-ARM KETTLEBELL MILITARY PRESS"),
                        childAtPosition(
                                withId(R.id.currentProgramWeeksList),
                                1),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        pressBack();

        ViewInteraction appCompatButton8 = onView(
                allOf(withText("Select new workout"), isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction button10 = onView(
                allOf(withText("test"),
                        withParent(allOf(withId(R.id.mainLayout),
                                withParent(withId(R.id.activity_select_workout))))));
        button10.perform(scrollTo(), click());

        ViewInteraction button11 = onView(
                allOf(withText("Yolo"),
                        withParent(allOf(withId(R.id.mainLayout),
                                withParent(withId(R.id.activity_select_workout))))));
        button11.perform(scrollTo(), click());

        ViewInteraction button12 = onView(
                allOf(withText("swag arms"),
                        withParent(allOf(withId(R.id.mainLayout),
                                withParent(withId(R.id.activity_select_workout))))));
        button12.perform(scrollTo(), click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withText("Start Workout"), isDisplayed()));
        appCompatButton9.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.programsBtn), withText("My Programs"), isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction button13 = onView(
                withText("+"));
        button13.perform(scrollTo(), click());

        ViewInteraction appCompatEditText4 = onView(
                withId(R.id.programName));
        appCompatEditText4.perform(scrollTo(), replaceText("secondary"), closeSoftKeyboard());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.dayPlusButton), withText("+")));
        appCompatButton11.perform(scrollTo(), click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.weekPlusButton), withText("+")));
        appCompatButton12.perform(scrollTo(), click());

        ViewInteraction editText6 = onView(
                withClassName(is("android.widget.EditText")));
        editText6.perform(scrollTo(), replaceText("legs"), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
                allOf(withClassName(is("android.widget.EditText")), isDisplayed()));
        editText7.perform(replaceText("brutal"), closeSoftKeyboard());

        ViewInteraction button14 = onView(
                allOf(withText("Add Exercise"), isDisplayed()));
        button14.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                withId(R.id.numberPicker));
        appCompatEditText5.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.search), withContentDescription("Hint Search"), isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction searchAutoComplete7 = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete7.perform(replaceText("squat"), closeSoftKeyboard());

        ViewInteraction searchAutoComplete8 = onView(
                allOf(withId(R.id.search_src_text), withText("squat"),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete8.perform(pressImeActionButton());

        ViewInteraction button15 = onView(
                withText("ALIEN SQUAT"));
        button15.perform(scrollTo(), click());

        ViewInteraction editText8 = onView(
                allOf(withClassName(is("android.widget.EditText")),
                        withParent(withId(R.id.volumeAndIntensity))));
        editText8.perform(scrollTo(), replaceText("10"), closeSoftKeyboard());

        ViewInteraction editText9 = onView(
                allOf(withClassName(is("android.widget.EditText")),
                        withParent(withId(R.id.volumeAndIntensity))));
        editText9.perform(scrollTo(), replaceText("100"), closeSoftKeyboard());

        ViewInteraction button16 = onView(
                allOf(withText("Save"),
                        withParent(withId(R.id.volumeAndIntensity))));
        button16.perform(scrollTo(), click());

        ViewInteraction appCompatButton13 = onView(
                allOf(withText("Save"), isDisplayed()));
        appCompatButton13.perform(click());

        pressBack();

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.startWorkoutBtn), withText("Start Workout"), isDisplayed()));
        appCompatButton14.perform(click());

        ViewInteraction appCompatButton15 = onView(
                allOf(withText("Select new workout"), isDisplayed()));
        appCompatButton15.perform(click());

        ViewInteraction button17 = onView(
                allOf(withText("secondary"),
                        withParent(allOf(withId(R.id.mainLayout),
                                withParent(withId(R.id.activity_select_workout))))));
        button17.perform(scrollTo(), click());

        ViewInteraction button18 = onView(
                allOf(withText("legs"),
                        withParent(allOf(withId(R.id.mainLayout),
                                withParent(withId(R.id.activity_select_workout))))));
        button18.perform(scrollTo(), click());

        ViewInteraction button19 = onView(
                allOf(withText("brutal"),
                        withParent(allOf(withId(R.id.mainLayout),
                                withParent(withId(R.id.activity_select_workout))))));
        button19.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.exerciseBtn), withText("Exercises"), isDisplayed()));
        appCompatButton16.perform(click());

        ViewInteraction appCompatButton17 = onView(
                allOf(withText("Add Custom"), isDisplayed()));
        appCompatButton17.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                withId(R.id.customNameValue));
        appCompatEditText6.perform(scrollTo(), click());

        ViewInteraction appCompatEditText7 = onView(
                withId(R.id.customNameValue));
        appCompatEditText7.perform(scrollTo(), replaceText("Yolo"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                withId(R.id.primaryValue));
        appCompatEditText8.perform(scrollTo(), replaceText("deltoids"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                withId(R.id.difficultyValue));
        appCompatEditText9.perform(scrollTo(), replaceText("tough"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                withId(R.id.equipmentValue));
        appCompatEditText10.perform(scrollTo(), replaceText("none"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                withId(R.id.secondaryValue));
        appCompatEditText11.perform(scrollTo(), replaceText("none"), closeSoftKeyboard());

        ViewInteraction appCompatButton18 = onView(
                allOf(withId(R.id.createButton), withText("Create")));
        appCompatButton18.perform(scrollTo(), click());

        ViewInteraction appCompatButton19 = onView(
                allOf(withId(R.id.createButton), withText("Create")));
        appCompatButton19.perform(scrollTo(), click());

        ViewInteraction appCompatButton20 = onView(
                allOf(withText("Remove Custom"), isDisplayed()));
        appCompatButton20.perform(click());

        ViewInteraction appCompatButton21 = onView(
                allOf(withText("Remove Custom"), isDisplayed()));
        appCompatButton21.perform(click());

        pressBack();

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
