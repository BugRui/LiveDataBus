package com.bugrui.buslib

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import java.util.*

/**
 * @Author: BugRui
 * @CreateDate: 2019/10/12 17:26
 * @Description: 事件消息
 */
object LiveDataBus {

    private val liveDataMap = HashMap<String, MutableLiveData<Any?>>()

    /**
     * 关联一个普通事件消息，需要关联后才能收到发送的消息
     * @param tag 事件标识
     */
    fun with(tag: Int): LiveData<Any?> {
        return with(tag.toString())
    }

    fun with(tag: String): LiveData<Any?> {
        val mutableLiveData = MutableLiveData<Any?>()
        liveDataMap.put(tag, mutableLiveData)
        return mutableLiveData
    }


    /**
     * 关联一个粘性事件消息，可以收到关联之前发送的消息
     */
    fun withStickiness(tag: Int): StickinessEvent {
        return withStickiness(tag.toString())
    }

    fun withStickiness(tag: String): StickinessEvent {
        return StickinessEvent(liveDataMap, tag)
    }

    /**
     * 发送一个普通事件消息
     * @param tag 事件标识
     * @param t 事件内容
     */
    fun send(tag: Int, t: Any? = null) {
        send(tag.toString(), t)
    }

    fun send(tag: String, t: Any? = null) {
        if (!liveDataMap.containsKey(tag) || liveDataMap[tag] == null) return
        liveDataMap[tag]?.postValue(t)
    }

    /**
     * 发送一个粘性事件消息
     *  @param tag 事件标识
     *  @param t 事件内容
     */
    fun sendStickiness(tag: Int,t: Any? = null) {
        return sendStickiness(tag.toString(), t)
    }

    /**
     * 发送一个粘性事件消息
     */
    fun sendStickiness(tag: String, t: Any? = null) {
        if (!liveDataMap.containsKey(tag) || liveDataMap[tag] == null) {
            liveDataMap.put(tag, MutableLiveData())
        }
        liveDataMap[tag]?.postValue(t)
    }

}
