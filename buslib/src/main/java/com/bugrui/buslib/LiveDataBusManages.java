package com.bugrui.buslib;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BugRui
 * @CreateDate: 2019/9/29 14:33
 * @Description: 事件通知
 */
final class LiveDataBusManages {

    private static final LiveDataBusManages INSTANCE = new LiveDataBusManages();
    private Map<String, MutableLiveData<Object>> busMap;

    static LiveDataBusManages getInstance() {
        return INSTANCE;
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
    MutableLiveData<Object> with(String tag) {
        busMap.put(tag, new MutableLiveData<>());
        return busMap.get(tag);
    }

    /**
     * 发送事件
     *
     * @param tag    事件标识
     * @param object 附带内容
     */
    void send(String tag,@NonNull Object object) {
        if (busMap.get(tag) == null) return;
        MutableLiveData<Object> liveData = busMap.get(tag);
        if (liveData == null) return;
        liveData.setValue(object);
    }


}
