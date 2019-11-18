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


    public static MutableLiveData<Object> get(int tag) {
        return get(String.valueOf(tag));
    }

    public static MutableLiveData<Object> get(String tag) {
        return getBus().with(tag);
    }


    public static void send(int tag,Object object){
        send(String.valueOf(tag),object);
    }

    public static void send(String tag,Object object) {
        getBus().send(tag,object);
    }

}
