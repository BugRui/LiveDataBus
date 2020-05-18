package com.bugrui.buslib.event

import android.app.Service
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import java.util.HashMap

/**
 * 普通事件
 */
class DefaultEvent(
        private val liveDataMap: HashMap<String, MutableLiveData<Any?>>,
        private val tag: String
) : Event {


    override fun observe(activity: ComponentActivity, observer: Observer<Any?>) {
        subscribe(activity, observer)
    }

    override fun observe(fragment: Fragment, observer: Observer<Any?>) {
        subscribe(fragment, observer)
    }

    override fun observeForever(activity: ComponentActivity, observer: Observer<Any?>) {
        subscribeForever(activity, observer)
    }

    override fun observeForever(fragment: Fragment, observer: Observer<Any?>) {
        subscribeForever(fragment, observer)
    }

    private fun subscribe(owner: LifecycleOwner, observer: Observer<Any?>) {
        liveDataMap[tag] = MutableLiveData()
        liveDataMap[tag]?.observe(owner, Observer { o ->
            observer.onChanged(o)
        })
    }

    private fun subscribeForever(owner: LifecycleOwner, observer: Observer<Any?>) {
        liveDataMap[tag] = MutableLiveData()

        val mObserver= Observer<Any?> {o ->
            observer.onChanged(o)
        }

        liveDataMap[tag]?.observeForever(mObserver)

        //onDestroy时解绑
        owner.lifecycle.addObserver(object : LifecycleObserver{
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                liveDataMap[tag]?.removeObserver(mObserver)
            }
        })
    }

}