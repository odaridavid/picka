# Picka

[![Release](https://jitpack.io/v/Davidodari/picka.svg)](https://jitpack.io/#Davidodari/picka)

Simple Media Picking Library for Android

### Usage

Call the Picka library from the activity/fragment picking a media file
by default it seeks Image files and no defined mime types.

```kotlin

//With Defaults
Picka.pickMedia(this)

//With Params
Picka.pickMedia(this, MediaType.IMAGE, arrayOf("image/jpeg", "image/png"))
```
The Result can then be retrieved from ```onActivityResult``` as shown
```kotlin
val uri = Picka.collectMediaFile(requestCode, resultCode, data)
```

### Download

Add jitpack to project level build.gradle
```groovy
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```
Then add the library to module level build.gradle.
```groovy
 implementation 'com.github.Davidodari:picka:1.0.0'
```

&copy; David Odari 2019
