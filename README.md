# Compose Boilerplate

一个 Jetpack Compose 项目模板，包含了移动端工程化的一些常用能力，可以直接拿来使用。

## 技术栈

| 能力     | 方案                                                                                                                                   |
|--------|--------------------------------------------------------------------------------------------------------------------------------------|
| UI 框架  | [Jetpack Compose](https://developer.android.com/jetpack/compose) + [Material 3](https://m3.material.io/)                             |
| 路由     | [navigation-compose](https://developer.android.com/jetpack/compose/navigation)                                                       |
| 全局状态   | Compose `mutableStateOf` + 顶层单例（无需 DI 框架）                                                                                            |
| 组件状态   | [compose-hooks](https://github.com/niceperson/compose-hooks)（类 React Hooks）                                                          |
| 异步数据加载 | 自定义 `useQuery` / `useMutation`（类 React Query）                                                                                        |
| 网络请求   | [OkHttp](https://square.github.io/okhttp/) + [Retrofit](https://square.github.io/retrofit/) + [Gson](https://github.com/google/gson) |
| 持久化    | [SharedPreferences](https://developer.android.com/reference/android/content/SharedPreferences)                                       |
| 图片加载   | [Coil](https://coil-kt.github.io/coil/)                                                                                              |
| 异步     | [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)                                                            |
| 测试     | [MockK](https://mockk.io/) + [Robolectric](https://robolectric.org/) + [AssertJ](https://assertj.github.io/doc/)                     |

## 1. 核心部分

### 1.1 包结构

``` yaml
com.thoughtworks.boilerplate # Android代码根目录
├── features # 以功能点为单位组织所有相关业务逻辑代码（含 API、Model）
│   ├── auth # 登录认证模块
│   │   ├── AuthScreen.kt            # 登录页面
│   │   ├── AuthApi.kt               # 登录 API 接口定义
│   │   ├── AuthModels.kt            # Auth 数据模型（Request / Response）
│   │   └── AuthRepository.kt        # 登录 & Token 管理逻辑
│   ├── animals # 动物图片模块
│   │   ├── AnimalsScreen.kt         # 动物图片页面
│   │   ├── Animal.kt                # 动物数据模型
│   │   ├── AnimalRepository.kt      # 动物数据仓库
│   │   ├── DogApi.kt                # 狗图片 API 接口定义
│   │   └── CatApi.kt                # 猫图片 API 接口定义
│   └── home # 首页模块
│       ├── HomeScreen.kt            # 首页（计数器）页面
│       └── UseCounter.kt            # 管理计数状态的 Hook
├── components # 跨页面共享的 UI 组件
│   ├── querying # 异步加载组件
│   │   ├── AsyncLoader.kt          # 配合 useQuery 处理加载状态的组件
│   │   ├── LoadingPopup.kt          # 加载弹窗
│   │   ├── LoadingPlaceholder.kt    # 加载占位 Widget
│   │   └── ErrorPlaceholder.kt      # 错误占位 Widget
│   └── scaffold # 通用页面脚手架
│       ├── BaseScaffold.kt          # 基础页面脚手架
│       └── DefaultAppBar.kt         # 通用 AppBar
├── states # 全局状态（Compose mutableStateOf）
│   └── AuthState.kt                 # 全局登录状态
├── shared # 跨页面共享的基础设施（单例对象）
│   ├── composequery # 自定义查询工具
│   │   ├── UseQuery.kt              # 异步数据获取 Hook
│   │   ├── UseMutation.kt           # 异步写操作 Hook
│   │   ├── UseQueryResult.kt        # 查询结果数据类
│   │   └── QueryStatus.kt           # 查询状态枚举
│   ├── HttpClient.kt                # 网络请求客户端（含 TokenInterceptor）
│   ├── TokenStore.kt                # Token 持久化存储
│   └── RetrofitApiFactory.kt        # Retrofit API 工厂
├── utils # 工具类（无状态、无副作用）
│   ├── CompositionLocals.kt         # CompositionLocal 依赖注入
│   ├── DummyNavController.kt        # 用于 Preview 的占位 NavController
│   └── Tuples.kt                    # 元组工具类
├── theme # 主题相关
│   ├── Color.kt                     # 调色盘与主题色
│   ├── Dimension.kt                 # 尺寸相关
│   ├── Shape.kt                     # 形状相关
│   ├── Typography.kt                # 字体相关
│   └── Theme.kt                     # Material 主题配置
├── devmenu # 调试菜单
│   ├── DevMenu.kt                   # DevMenu 接口定义
│   └── DummyDevMenu.kt              # 空实现（Release 模式）
├── MainActivity.kt                  # Activity 入口
├── App.kt                           # Application 类（初始化 TokenStore、AuthState）
├── ComposeApp.kt                    # Compose 根组件
└── Routes.kt                        # 路由配置 + 认证守卫（navigation-compose）
```

### 1.2 架构

本项目采用 **三层架构 + 纵向切分**
的设计模式，灵感来源于[通用应用架构](https://juejin.cn/post/7390569548367970314)。

#### 1.2.1 横向分层

| 层次        | 实现方式                             | 职责                             |
|-----------|----------------------------------|--------------------------------|
| **UI 层**  | `XxxScreen.kt`（@Composable）      | 声明式渲染 UI，根据 state 显示对应视图       |
| **流程控制层** | 自定义 Hook（`useXxx`）/ `useQuery`   | 定义 UI State，处理用户事件，衔接 UI 与纯逻辑层 |
| **纯逻辑层**  | `XxxRepository.kt` / API / Model | 业务核心逻辑，数据获取、缓存、计算等（UI 无关）      |

数据流方向：用户事件 → 流程控制层 → 纯逻辑层 → 返回结果 → 更新 UI State → UI 重组。

#### 1.2.2 各层职责详解

**UI 层**（Composable 函数）：

- 仅负责根据 state 的值渲染相应的 UI，内部应只包含分支逻辑（如 loading / error / success）
- 用户事件直接分发给流程控制层处理，不包含业务逻辑
- 示例：`HomeScreen` 只负责显示数字和按钮，点击事件委托给 `useCounter()`

**流程控制层**（Hooks 函数）：

- 定义 UI State（`useState`），处理用户事件
- 承上启下：向上为 UI 层提供 state + 事件处理函数，向下调用纯逻辑层
- 对于简单场景，自定义 Hook 即可（如 `useCounter`）
- 对于异步数据加载，使用通用流程控制组件 `useQuery`（位于
  `shared/composequery`），它标准化了异步操作的状态管理（loading / error / success）

**纯逻辑层**（Repository / API / Model）：

- 包含所有 UI 无关的业务逻辑：网络请求、数据组合、缓存策略等
- 以 Repository 模式实现（如 `AnimalRepository`），通过构造函数注入依赖
- 检验标准：能否通过命令行调用来实现核心功能

#### 1.2.3 纵向切分（Vertical Slicing）

项目以 **业务单元（数据流）** 为最小单位组织代码，每个 feature 目录包含该业务完整的三层代码：

``` yaml
features/home/
├── HomeScreen.kt                # UI 层
└── UseCounter.kt                # 流程控制层（无需纯逻辑层）

features/animals/
├── AnimalsScreen.kt             # UI 层（useQuery 充当流程控制层）
├── AnimalRepository.kt          # 纯逻辑层
├── DogApi.kt                    # 纯逻辑层（API）
├── CatApi.kt                    # 纯逻辑层（API）
└── Animal.kt                    # 纯逻辑层（Model）
```

这种组织方式使得每个业务单元是独立整体，可以单独修改、移动或删除，很好地应对需求变化。

### 1.3 页面路由与认证守卫

使用 [navigation-compose](https://developer.android.com/jetpack/compose/navigation) 管理路由，配置在
`Routes.kt` 中。

项目通过 `LaunchedEffect` 监听 `AuthState.isLoggedIn` 实现响应式路由守卫：

- `sAuthState.isLoggedIn`（`mutableStateOf`）作为观察对象，当认证状态变化时路由自动重新评估
- 未登录时自动跳转登录页，登录成功后自动跳转首页

### 1.4 Token 管理与登录

认证状态通过 `AuthState`（`mutableStateOf`）统一管理，位于 `states/AuthState.kt`：

- **AuthState**：封装 `isLoggedIn` 状态 + TokenStore 持久化，提供 `login()`/`logout()` 方法
- **TokenStore**（`shared/TokenStore.kt`）：底层基于 `SharedPreferences` 持久化存储 Token
- **AuthScreen**：使用 `useMutation` 处理登录，成功后 `authState.login(token)` 更新状态 → 路由自动跳转
- **TokenInterceptor**（`HttpClient.kt` 内部）：OkHttp 拦截器，自动附加 `Authorization` 头；收到 401
  时自动调用 `authState.logout()` → 路由自动跳转登录页
- **Dev Menu**：调用 `sAuthState.logout()` 即可，无需手动导航

### 1.5 依赖注入

本项目不使用 DI 框架，而是利用 Kotlin 顶层变量的天然特性来管理单例对象，
同时用 Composable 函数默认参数的方式来管理组件级对象：

- **顶层变量天然是懒加载且全局唯一的**，适用于全局基础设施（如 `sHttpClient`、`sTokenStore`）
- **组件级对象**（如 Repository）由使用方（Composable）直接构造，生命周期自然跟随组件
- **测试友好**：所有外部依赖都通过构造函数参数传入，且以默认值的形式注入（单例对象或直接构造对象），
  方便测试时替换为 mock 对象

```kotlin
// TokenStore.kt — 顶层单例
val sTokenStore = TokenStore()

// HttpClient.kt — 顶层单例
val sHttpClient: OkHttpClient = OkHttpClient.Builder().build()

// AuthRepository.kt — 组件级，由 Composable 构造并持有
class AuthRepository(
    private val authApi: AuthApi = sAuthApi,       // 注入顶层单例
    private val authState: AuthState = sAuthState, // 注入顶层单例
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
)
```

### 1.6 状态管理

项目采用双层状态管理策略：

**全局状态** — Compose `mutableStateOf` + 顶层单例：

- 适用于跨组件/跨页面共享的响应式状态
- 以 `class XxxState {}` 形式组织，导出顶层变量作为单例
- `mutableStateOf` 的值变化可直接触发 Composable 重组
- 示例：`AuthState.isLoggedIn`

**组件状态** — [compose-hooks](https://github.com/niceperson/compose-hooks)：

- `useState` — 简单的局部状态
- `useQuery`（位于 `shared/composequery`）— 异步数据获取，自动管理 loading / error / success 状态
- `useMutation`（位于 `shared/composequery`）— 异步写操作（如登录、提交表单），支持
  onSuccess / onError 回调

### 1.7 网络库

使用 [OkHttp](https://square.github.io/okhttp/) + [Retrofit](https://square.github.io/retrofit/) +
[Gson](https://github.com/google/gson) 组合。
通过自定义 `@BaseUrl` 注解 + `RetrofitApiFactory` 支持多个 API 地址，无需为每个 base URL 创建独立的
Retrofit 实例。

### 1.8 持久化

使用 [SharedPreferences](https://developer.android.com/reference/android/content/SharedPreferences)
进行简单的键值对持久化，
适用于存储 Token、用户设置等小型数据。

### 1.9 异步加载组件

`components/querying/AsyncLoader.kt` 提供了 `AsyncLoader<T>` 组件，
基于 `UseQueryResult` 自动处理 Loading / Error / Success / Idle 四种状态的 UI 切换：

```kotlin
AsyncLoader(result) { data ->
    // 成功时的 UI
    AnimalsContent(data)
}
```

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
