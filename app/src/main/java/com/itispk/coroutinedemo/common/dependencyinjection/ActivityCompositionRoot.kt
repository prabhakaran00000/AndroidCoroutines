package com.techyourchance.coroutines.common.dependencyinjection

import androidx.fragment.app.FragmentActivity
import com.itispk.coroutinedemo.R
import com.ncapdevi.fragnav.FragNavController
import com.itispk.coroutinedemo.common.dependencyinjection.ScreensNavigator
import com.techyourchance.coroutines.common.ToolbarDelegate

class ActivityCompositionRoot(
        private val activity: FragmentActivity,
        private val appCompositionRoot: ApplicationCompositionRoot
) {

    val toolbarManipulator get() = activity as ToolbarDelegate

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(fragNavController)
    }

    private val fragNavController get() = FragNavController(fragmentManager, R.id.frame_content)

    private val fragmentManager get() = activity.supportFragmentManager


}