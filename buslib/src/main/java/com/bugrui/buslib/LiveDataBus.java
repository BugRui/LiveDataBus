package com.bugrui.buslib;

import androidx.lifecycle.MutableLiveData;

/**
 * @Author: BugRui
 * @CreateDate: 2019/10/12 17:26
 * @Description: 事件通讯
 */
public class LiveDataBus {


    private static LiveDataBusManages getBus(){
        return LiveDataBusManages.getInstance();
    }


    public static <T> MutableLiveData<T> get(int tag) {
        return get(String.valueOf(tag));
    }

    public static <T> MutableLiveData<T> get(String tag) {
        return getBus().with(tag);
    }

    public static <T> void send(int tag,T object){
        send(String.valueOf(tag),object);
    }

    public static <T> void send(String tag,T object) {
        getBus().send(tag,object);
    }

}
