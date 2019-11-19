package com.bugrui.buslib;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BugRui
 * @CreateDate: 2019/9/29 14:33
 * @Description: 事件管理
 */
final class LiveDataBusManages {

    private volatile static LiveDataBusManages mInstance;

    private Map<String, MutableLiveData> busMap;

    static LiveDataBusManages getInstance() {
        if (mInstance == null) {
            synchronized (LiveDataBusManages.class) {
                if (mInstance == null) {
                    mInstance = new LiveDataBusManages();
                }
            }
        }
        return mInstance;
    }

    private LiveDataBusManages() {
        busMap = new HashMap<>();
    }

    /**
     * 关联（关联后，发送的事件才能收到）
     *
     * @param tag 事件标识
     * @return
     */
    @SuppressWarnings("unchecked")
    <T> MutableLiveData<T> with(@NonNull String tag) {
        busMap.put(tag, new MutableLiveData<>());
        return busMap.get(tag);
    }

    /**
     * 发送事件
     *
     * @param tag    事件标识
     * @param t 附带内容
     */
    @SuppressWarnings("unchecked")
    <T> void send(@NonNull String tag, @NonNull T t) {
        if (busMap.get(tag) == null) return;
        MutableLiveData liveData = busMap.get(tag);
        if (liveData == null) return;
        liveData.postValue(t);
    }


}
