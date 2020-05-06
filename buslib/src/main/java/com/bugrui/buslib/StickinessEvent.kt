package com.bugrui.buslib

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.*


/**
 * 粘性事件
 * @param
*/
class StickinessEvent(
        private val liveDataMap: HashMap<String, MutableLiveData<Any?>>,
        private val tag: String
) {

    fun observe(owner: LifecycleOwner, observer: Observer<Any?>) {
        if (!liveDataMap.containsKey(tag) || liveDataMap[tag] == null) {
            liveDataMap.put(tag, MutableLiveData())
        }
        liveDataMap[tag]?.observe(owner, Observer { o ->
            observer.onChanged(o)
            liveDataMap.put(tag, MutableLiveData())
            observe(owner, observer)
        })
    }
}
