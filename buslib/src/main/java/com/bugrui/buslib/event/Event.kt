package com.bugrui.buslib.event

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

interface Event {

    /**
     * 仅更新处于活动生命周期状态的应用程序组件观察者
     */
    fun observe(activity: ComponentActivity, observer: Observer<Any?>)

    /**
     * 仅更新处于活动生命周期状态的应用程序组件观察者
     */
    fun observe(fragment: Fragment, observer: Observer<Any?>)

    /**
     * 不受生命周期的影响，只要数据更新就会收到通知
     */
    fun observeForever(activity: ComponentActivity, observer: Observer<Any?>)

    /**
     * 不受生命周期的影响，只要数据更新就会收到通知
     */
    fun observeForever(fragment: Fragment, observer: Observer<Any?>)
}