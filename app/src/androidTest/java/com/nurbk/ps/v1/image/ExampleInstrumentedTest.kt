package com.nurbk.ps.v1.image

import android.content.Intent
import android.os.SystemClock
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nurbk.ps.v1.image.ui.activty.MainActivity
import com.nurbk.ps.v1.image.ui.fragment.ImagesFragment.Companion.dataSource
import kotlinx.android.synthetic.main.menu_sheet.*
import org.hamcrest.Matchers.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import org.w3c.dom.Text

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(MainActivity::class.java)
    lateinit var activitySearchScenario: ActivityScenario<MainActivity>
    @Test
    fun recycleTest() {

        SystemClock.sleep(6000)
        onView(withId(R.id.rvPhoto))
            .perform(
                RecyclerViewActions
                    .scrollToPosition<RecyclerView.ViewHolder>(
                        dataSource.size - 1
                    )
            )
    }

    @Test
    fun goToSearch() {
        val i = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)

        activitySearchScenario = ActivityScenario.launch(i)
        i.putExtra("data", "net")

        onView(withId(R.id.searchFragment))
            .perform(ViewActions.click())

        onView(
            withId(R.id.etSearch)
        ).perform(ViewActions.typeText(i.getStringExtra("data")))
            .perform(ViewActions.pressImeActionButton())
            .perform(ViewActions.closeSoftKeyboard())

        SystemClock.sleep(6000)

        onView(withId(R.id.favoriteFragment))
            .perform(ViewActions.click())

    }


    @Test
    fun goToVideo() {
        val i = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        activitySearchScenario = ActivityScenario.launch(i)

        onView(withId(R.id.videoFragment))
            .perform(ViewActions.click())
    }


    @Test
    fun recycleClickTest() {

        SystemClock.sleep(2000)
        onView(withId(R.id.rvPhoto))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        1, ViewActions.click()
                    )
            )

        onView(withId(R.id.btnSaveImageDetails))
            .perform(ViewActions.click())

        SystemClock.sleep(2000)

        Espresso.pressBack();

        onView(withId(R.id.favoriteFragment))
            .perform(ViewActions.click())

        SystemClock.sleep(2000)



    }


}