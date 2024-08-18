# Compose Boilerplate

## 1. 核心部分

### 1.1 包结构

``` yaml
com.package.name # Android代码根目录
```

### 1.2 架构

本项目选用的是MVVM架构，对于一个页面来说，主要包含以下几个部分：

|    | View            | ViewModel      | Model                        |
|----|-----------------|----------------|------------------------------|
| 代码 | XxxScreen       | XxxViewModel   | XxxRepository(api, model...) |
| 职责 | 用于渲染UI          | 用于管理状态和状态相关的逻辑 | 用于数据相关的逻辑                    |
| 构成 | UI内部状态 + Widget | 业务状态 + UI事件响应  | 数据存取、缓存策略...                 |

### 1.3 页面路由

[navigation-compose]

### 1.4 网络库

[okhttp] + [retrofit]

### 1.5 持久化

> TODO

### 1.6 对页面异步加载的一个封装

这部分代码在`common/asyncLoader`中，其目标是让页面不必处理异步加载的逻辑，只需要关注数据成功加载后的UI渲染即可。
`AsyncLoadProcessor`负责异步加载的UI渲染，它会根据`LoadState`的状态来显示不同的UI，`LoadState`
的状态有以下几种：

1. `Idle`：表示未开始加载的空状态，此时不会显示任何内容
2. `Loading`：表示正在加载中，此时默认会显示`LoadingPlaceholder`，若`loadingView`
   不为空，则会显示`loadingView`
3. `Success`：表示加载成功，此时会显示`content`中传入的Widget，一般此处传入的Widget才是页面真正的主体内容
4. `Failure`：表示加载失败，此时默认则会显示`ErrorPlaceholder`，若`errorView`不为空，则会显示`errorView`

`AsyncLoadViewModel`是`AsyncLoadProcessor`
的ViewModel，它负责处理异步加载的逻辑。它的构造函数中需要传入一个`DataViewModel`，
`AsyncLoadViewModel`并且会调用`DataViewModel`的`fetch`方法来获取数据，并且会根据`fetch`
的执行结果来更新`LoadState`的状态。

`DataViewModel`是一个抽象类，它的子类需要实现`fetch`方法，`fetch`方法需要返回一个`Future`。
`DataViewModel`是页面真正主体（即上面提到的`content`）对应的ViewModel，它虽然要实现`fetch`方法，但它不负责获取数据，
它只用关心数据成功加载后的业务逻辑。

## 2. 非核心部分

### 2.1 Lint + Git hookss

[spotless] + [kover]

### 2.2 单元测试

[Mockk] + [Robolectric] + [AssertJ]

### 2.3 Theme

位于`ui/theme`中，主要包含以下几个部分：

### 2.4 Dev Menu

位于`devMenu`中

### 2.5 环境变量

`build_config.gradle`

### 2.6 Feature Toggle

> TODO

### 2.7 混淆

### 2.8 pipeline

[fastlane]

### 2.9 local server
