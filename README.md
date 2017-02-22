Androidのテストライブラリ
====


## 用途
アプリ側のbuild.gradleでライブラリのリモートリポジトリを使用するため


## アプリ側のbuild.gradle

```
repositories {
    maven {
        url "https://github.com/hyyyyde/MyTestLibrary/raw/master/repository"
    }
}

dependencies {
  :
  :
  compile 'com.example.hyyyyde:mylibrary:1.0.0'
}
```


