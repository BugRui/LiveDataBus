# LiveDataBus [![version](https://jitpack.io/v/BugRui/LiveDataBus.svg)](https://jitpack.io/#BugRui/LiveDataBus/1.1.0)

##### 基于LiveData实现事件总线,具备生命周期感知，感知确保LiveData仅更新处于活动生命周期状态的应用程序组件观察者，
##### 支持粘性，消息发送后订阅也能收到发出的消息
##### 消息发送后，只有处于活动生命周期状态才会收到发出的消息。


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
implementation 'com.github.BugRui:LiveDataBus:1.1.0'
```


### 订阅普通事件消息
```

LiveDataBus.with("tag")
                .observe(this, Observer {
                    toast("收到普通事件消息：${it.toString()}")
                })
```

### 发送普通事件消息
```
 LiveDataBus.send("tag", "发送一条消息")

```
## 订阅粘性事件消息
```
LiveDataBus.withStickiness("tag")
                .observe(this, Observer {
                    toast("收到粘性事件消息：${it.toString()}")
                })
```

### 发送粘性事件消息
```
 LiveDataBus.sendStickiness("tag", "发送一条消息")
```


