# PercentView
Simple percent view android library

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

LICENCE
-----

PercentView by [Ahmad Rosid](http://ahmadrosid.com/) is licensed under a [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
