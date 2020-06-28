# LiveDataBus [![version](https://jitpack.io/v/BugRui/LiveDataBus.svg)](https://jitpack.io/#BugRui/LiveDataBus/1.2.0)

##### 基于LiveData实现事件总线,具备生命周期感知，感知确保LiveData仅更新处于活动生命周期状态的应用程序组件观察者，
##### 支持粘性，消息发送后订阅也能收到发出的消息，但是只能收到订阅前发送的最后一条消息




### 集成
#### Step 1. Add the JitPack repository to your build file
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

```
####  Step 2. Add the dependency
```
  implementation 'com.github.BugRui:LiveDataBus:1.2.2'
```


### 订阅普通事件消息

LiveDataBus有两种订阅的方式

1，observe 仅更新处于活动生命周期状态的应用程序组件观察者
2，observeForever 不受生命周期的影响，只要数据更新就会收到通知

```

LiveDataBus.with("tag")
                .observe(this, Observer {
                    toast("仅更新处于活动生命周期状态的应用程序组件观察者：${it.toString()}")
                })
		
LiveDataBus.with("tag")
                .observeForever(this, Observer {
                    toast("不受生命周期的影响，只要数据更新就会收到通知：${it.toString()}")
                })
```

### 发送普通事件消息
```
 LiveDataBus.send("tag", "发送一条消息")

```
## 订阅粘性事件消息
```

//仅更新处于活动生命周期状态的应用程序组件观察者
LiveDataBus.withStickiness("tag")
                .observe(this, Observer {
                    toast("收到粘性事件消息：${it.toString()}")
                })
		
//不受生命周期的影响，只要数据更新就会收到通知	
LiveDataBus.withStickiness("tag")
                .observeForever(this, Observer {
                    toast("收到粘性事件消息：${it.toString()}")
                })
```

### 发送粘性事件消息
```
 LiveDataBus.sendStickiness("tag", "发送一条消息")
```


