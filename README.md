# InstanceCoupling

这是一个当Activity或者Fragment调用onSaveInstanceState(Bundle outState)方法时，进行数据保存的，并且可以在需要将savedInstanceState的数据进行读取的库。
详细使用可以看Simple里的代码。

build

    compile 'com.sora:InstanceCoupling:1.0.0'

##使用方法
注解需要保存的字段：
```Java
@SaveField//给name属性添加一个注解
private String name;
```
读取
```Java
//读取数据
Couple.readInstance(this, savedInstanceState);
TextView textView = findViewById(R.id.textview);
textView.setText(name);
```
保存：
```Java
@Override
protected void onSaveInstanceState(Bundle outState) {
   super.onSaveInstanceState(outState);
   //保存数据
   Couple.saveInstance(this, outState);
}
```


Copyright 2018 zhengyang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

