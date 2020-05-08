package com.bugrui.buslib.event

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.*


/**
 * 粘性事件
 */
class StickinessEvent(
        private val liveDataMap: HashMap<String, MutableLiveData<Any?>>,
        private val tag: String
):Event{

    override fun observe(activity: ComponentActivity, observer: Observer<Any?>) {
        subscribe(activity,observer)
    }

    override fun observe(fragment: Fragment, observer: Observer<Any?>) {
        subscribe(fragment,observer)
    }

    private fun subscribe(owner: LifecycleOwner, observer: Observer<Any?>) {
        if (!liveDataMap.containsKey(tag) || liveDataMap[tag] == null) {
            liveDataMap[tag] = MutableLiveData()
        }
        liveDataMap[tag]?.observe(owner, Observer { o ->
            observer.onChanged(o)
            liveDataMap[tag] = MutableLiveData()
            subscribe(owner, observer)
        })
    }

}
