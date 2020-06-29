# LiveDataBus [![version](https://jitpack.io/v/BugRui/LiveDataBus.svg)](https://jitpack.io/#BugRui/LiveDataBus/1.2.0)

基于LiveData实现事件总线,具备生命周期感知，感知确保LiveData仅更新处于活动生命周期状态的应用程序组件观察者，
支持粘性，消息发送后订阅也能收到发出的消息，但是只能收到订阅前发送的最后一条消息

Event bus based on LiveData, with life cycle awareness, awareness to ensure that LiveData only updates the observer of application components in the active life cycle state,
Stickiness is supported. Subscriptions can also receive outgoing messages after the message is sent, but only the last message sent before the subscription is received


### 集成 integration
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


### 订阅普通事件消息  Subscribe to regular event messages

LiveDataBus有两种订阅的方式 LiveDataBus has two subscription options

1，observe 仅更新处于活动生命周期状态的应用程序组件观察者 Only application component observers in the active lifecycle state are updated

2，observeForever 不受生命周期的影响，只要数据更新就会收到通知  It is unaffected by the life cycle and is notified whenever data is updated

tag订阅的标识，对应发送的tag，一对一
Tag subscribes to an identity that corresponds to the tag being sent, one to one

```

LiveDataBus.with("tag")
                .observe(this, Observer {
                    toast("messages：${it.toString()}")
                })
		
LiveDataBus.with("tag")
                .observeForever(this, Observer {
                    toast("messages：${it.toString()}")
                })
```

### 发送普通事件消息  send regular event messages
```
 LiveDataBus.send("tag", "message")

```
## 订阅粘性事件消息  Subscribe to sticky event messages
```

//仅更新处于活动生命周期状态的应用程序组件观察者 Only application component observers in the active lifecycle state are updated
LiveDataBus.withStickiness("tag")
                .observe(this, Observer {
                    toast("message：${it.toString()}")
                })
		
//不受生命周期的影响，只要数据更新就会收到通知  It is unaffected by the life cycle and is notified whenever data is updated	 
LiveDataBus.withStickiness("tag")
                .observeForever(this, Observer {
                    toast("message：${it.toString()}")
                })
```

### 发送粘性事件消息  Send a sticky event message
```
 LiveDataBus.sendStickiness("tag", "message")
```


