# LiveDataBus

基于LiveData实现事件总线

## 集成
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
implementation 'com.github.BugRui:LiveDataBus:1.0.0'
```


### 订阅
```java
LiveDataBus.get("main")
                .observe(this, new Observer<Object>() {
                    @Override
                    public void onChanged(Object o) {
                        
                    }
                });

```

### 发送
```java

  LiveDataBus.send("main","发送一条消息");

```
