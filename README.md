# PercentView
Simple percent view android library

![alt tag](https://github.com/ar-android/PercentView/raw/master/screen_shoot.png)

This is an Android project allowing to realize a PercentView instead of LinearLayout in the simplest way possible.

#Usage
To make a PercentView add in your layout XML and add PercentView library in your project or you can also grab it via Gradle:

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
   repositories {
	maven { url "https://jitpack.io" }
   }
}
```
Add dependencies :
```gradle
dependencies {
	 compile 'com.github.ar-android:PercentView:1.0'
}
```

#XML
```xml
<ahmadrosid.com.lib.PercentView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:hint="Percent View"
    app:showHint="true"/>
```
You must use the following properties in your XML to change your PercentView.

#####Properties:

* `app:hint`          (string)   -> default Percent View
* `app:showHint`    (boolean)     -> default false
* `app:heightPercent`    (dimension) -> default 5dp
* `app:hideInputPercent`          (boolean)   -> default false
* `app:percent`    (integer)     -> default 0

JAVA
-----

```java
PercentView percentView = new PercentView(context);
percentView.setPercent(20);
percentView.setHeightPercent(10);
```

# License

    Copyright 2017 Ahmad Rosid

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
