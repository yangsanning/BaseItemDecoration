# BaseItemDecoration
[![](https://jitpack.io/v/yangsanning/BaseItemDecoration.svg)](https://jitpack.io/#yangsanning/BaseItemDecoration)
[![API](https://img.shields.io/badge/API-19%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=19)


## 主要文件
| 名字             | 摘要           |
| ---------------- | -------------- |
|[RvItemDecorationBuilder]  | 用于构建分割线 |
|[BaseItemDecoration]  | 分割线的主要实现, 使用时需要继承它 |

### 1.基本用法 

#### 1.1 继承BaseItemDecoration 实现 getRvItemDecoration(int itemPosition)方法
```android
public class MyItemDecoration extends BaseItemDecoration {

    @Nullable
    @Override
    public RvItemDecoration getRvItemDecoration(int itemPosition) {
        return null;
    }
}
```

#### 1.2 通过RvItemDecorationBuilder构建返回属于你的自定义分割线
``` android
    @Nullable
    @Override
    public RvItemDecoration getRvItemDecoration(int itemPosition) {
        return new RvItemDecorationBuilder()
            // 左分割线
            .buildLeft(getColor(R.color.divider_left), width, -width, -width)
            // 上分割线
            .buildTop(getColor(R.color.divider_top), width)
            // 右分割线
            .buildRight(getColor(R.color.divider_right), width, -width, -width)
            // 底分割线
            .buildBottom(getColor(R.color.divider_bottom), width)
            // 一定要调用, 调用后才开始构建
            .finish();
    }
```

### 2.添加方法

#### 2.1 添加仓库

在项目的 `build.gradle` 文件中配置仓库地址。

```android
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

#### 2.2 添加项目依赖

在需要添加依赖的 Module 下添加以下信息，使用方式和普通的远程仓库一样。

```android
implementation 'com.github.yangsanning:BaseItemDecoration:1.1.0'
```

[RvItemDecorationBuilder]:https://github.com/yangsanning/BaseItemDecoration/blob/master/baseitemdecoration/src/main/java/ysn/com/recyclerview/RvItemDecorationBuilder.java
[BaseItemDecoration]:https://github.com/yangsanning/BaseItemDecoration/blob/master/baseitemdecoration/src/main/java/ysn/com/recyclerview/BaseItemDecoration.java
