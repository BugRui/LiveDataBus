# LiveDataBus

基于LiveData实现事件总线

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```


```
implementation 'com.github.BugRui:LiveDataBus:1.0.0'
```


订阅

```
LiveDataBus.get("main")
                .observe(this, new Observer<Object>() {
                    @Override
                    public void onChanged(Object o) {
                        
                    }
                });

```

发布

```

  LiveDataBus.send("main","收到一条消息");

```
