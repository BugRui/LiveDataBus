# LiveDataBus

1.基于LiveData实现事件总线,具备生命周期感知，感知确保LiveData仅更新处于活动生命周期状态的应用程序组件观察者，
2.在使用LiveDataBus的时候只有先进行订阅后才能收到发送的消息事件，无法接收订阅前发送的消息事件,发送后，只有处于活动生命周期状态才会收到发出的消息。

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
implementation 'com.github.BugRui:LiveDataBus:1.0.1'
```


### 订阅
```java
LiveDataBus.<String>get("main")
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String str) {
                        
                    }
                });

```

### 发送
```java

  LiveDataBus.send("main","发送一条消息");

```
