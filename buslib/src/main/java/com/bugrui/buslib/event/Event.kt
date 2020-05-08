package com.bugrui.buslib.event

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

interface Event {

    fun observe(activity: ComponentActivity, observer: Observer<Any?>)

    fun observe(fragment: Fragment, observer: Observer<Any?>)
}