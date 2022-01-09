package com.itispk.coroutinedemo.common.dependencyinjection

import android.os.Bundle
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavController.RootFragmentListener
import com.techyourchance.coroutines.demonstrations.backgroundthread.BackgroundThreadDemoFragment
import com.itispk.coroutinedemo.basiccoroutines.BasicCoroutinesDemoFragment
import com.itispk.coroutinedemo.uithread.UiThreadDemoFragment
import com.techyourchance.coroutines.home.HomeFragment

class ScreensNavigator(private val fragNavController: FragNavController) {

    fun init(savedInstanceState: Bundle?) {
        fragNavController.rootFragmentListener = object : RootFragmentListener {
            override val numberOfRootFragments get() = 1

            override fun getRootFragment(index: Int) = HomeFragment.newInstance()
        }

        fragNavController.initialize(FragNavController.TAB1, savedInstanceState)
    }

    fun onSaveInstanceState(outState: Bundle?) {
        fragNavController.onSaveInstanceState(outState)
    }

    fun isRootScreen() = fragNavController.isRootFragment

    fun navigateBack(): Boolean {
        if (fragNavController.isRootFragment) {
            return false
        } else {
            fragNavController.popFragment()
            return true
        }
    }

    fun navigateUp() {
        fragNavController.popFragment()
    }

    fun toHomeScreen() {
        fragNavController.clearStack()
        fragNavController.pushFragment(HomeFragment.newInstance())
    }

    fun toUiThreadDemo() {
        fragNavController.pushFragment(UiThreadDemoFragment.newInstance())
    }

    fun toBackgroundThreadDemo() {
        fragNavController.pushFragment(BackgroundThreadDemoFragment.newInstance())
    }

    fun toBasicCoroutinesDemo() {
        fragNavController.pushFragment(BasicCoroutinesDemoFragment.newInstance())
    }
//
//    fun toExercise1() {
//        fragNavController.pushFragment(Exercise1Fragment.newInstance())
//    }
//
//    fun toCoroutinesCancellationDemo() {
//        fragNavController.pushFragment(CoroutinesCancellationDemoFragment.newInstance())
//    }
//
//    fun toExercise2() {
//        fragNavController.pushFragment(Exercise2Fragment.newInstance())
//    }
//
//    fun toConcurrentCoroutines() {
//        fragNavController.pushFragment(ConcurrentCoroutinesDemoFragment.newInstance())
//    }
//
//    fun toScopeChildrenCancellation() {
//        fragNavController.pushFragment(ScopeChildrenCancellationDemoFragment.newInstance())
//    }
//
//    fun toExercise3() {
//        fragNavController.pushFragment(Exercise3Fragment.newInstance())
//    }
//
//    fun toScopeCancellation() {
//        fragNavController.pushFragment(ScopeCancellationDemoFragment.newInstance())
//    }
//
//    fun toViewModel() {
//        fragNavController.pushFragment(ViewModelDemoFragment.newInstance())
//    }
//
//    fun toExercise4() {
//        fragNavController.pushFragment(Exercise4Fragment.newInstance())
//    }
//
//    fun toDesignDemo() {
//        fragNavController.pushFragment(DesignDemoFragment.newInstance())
//    }
//
//    fun toExercise5() {
//        fragNavController.pushFragment(Exercise5Fragment.newInstance())
//    }
//
//    fun toCoroutinesCancellationCooperativeDemo() {
//        fragNavController.pushFragment(CoroutinesCancellationCooperativeDemoFragment.newInstance())
//    }
//
//    fun toCoroutinesCancellationCooperative2Demo() {
//        fragNavController.pushFragment(CoroutinesCancellationCooperative2DemoFragment.newInstance())
//    }
//
//    fun toExercise6() {
//        fragNavController.pushFragment(Exercise6Fragment.newInstance())
//    }
//
//    fun toNonCancellable() {
//        fragNavController.pushFragment(NonCancellableDemoFragment.newInstance())
//    }
//
//    fun toExercise8() {
//        fragNavController.pushFragment(Exercise8Fragment.newInstance())
//    }
//
//    fun toExercise9() {
//        fragNavController.pushFragment(Exercise9Fragment.newInstance())
//    }
//
//    fun toUncaughtException() {
//        fragNavController.pushFragment(UncaughtExceptionDemoFragment.newInstance())
//    }
//
//    fun toExercise10() {
//        fragNavController.pushFragment(Exercise10Fragment.newInstance())
//    }

}