# Picka

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

```groovy
implementation "com.davidodari.picka:picka:1.0.0"
```

&copy David Odari 2019