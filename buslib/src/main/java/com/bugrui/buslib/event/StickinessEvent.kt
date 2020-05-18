package com.bugrui.buslib.event

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import java.util.*


/**
 * 粘性事件
 */
class StickinessEvent(
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
        if (!liveDataMap.containsKey(tag) || liveDataMap[tag] == null) {
            liveDataMap[tag] = MutableLiveData()
        }
        liveDataMap[tag]?.observe(owner, Observer { o ->
            observer.onChanged(o)
            liveDataMap[tag] = MutableLiveData()
            subscribe(owner, observer)
        })
    }


    private fun subscribeForever(owner: LifecycleOwner, observer: Observer<Any?>) {
        if (!liveDataMap.containsKey(tag) || liveDataMap[tag] == null) {
            liveDataMap[tag] = MutableLiveData()
        }

        val mObserver= Observer<Any?> {o ->
            observer.onChanged(o)
            liveDataMap[tag] = MutableLiveData()
            subscribeForever(owner, observer)
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
