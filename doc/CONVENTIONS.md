[TOC]

# NearWord 规范说明

> 版本：v1.0
> 适用范围：Kotlin + Jetpack Compose 单模块或多模块项目
> 目标：让任何新成员 5 分钟内即可定位任何文件

## 🛠️ 技術棧

| 层级     | 选型                     | 备注                          |
| -------- | ------------------------ | ----------------------------- |
| 语言     | Kotlin 2.0+              |                               |
| UI       | Jetpack Compose          | 完全声明式                    |
| 架构     | MVVM + UseCase           | ViewModel 只做状态管理        |
| 依赖注入 | Hilt                     | 官方推荐                      |
| 导航     | Navigation-Compose       | 单 Activity + Compose NavHost |
| 网络     | Retrofit + OkHttp        | —                             |
| 异步     | Kotlin Coroutines + Flow | —                             |
| 版本管理 | Gradle Version Catalog   | 全局 `libs.versions.toml`     |

### 工具库

* ViewModel：状态仓库... [引入ViewModel记录](./DEVLOG.md#引入ViewModel)

## 🏗️ 项目结构（单模块示例）

```
app/src/main/java/com/xxx/nearword/
├── MainActivity.kt                 // 唯一入口
├── ui/                             // 所有 UI
│   ├── main/                       // 主屏
│   │   ├── MainScreen.kt           // 主屏 Scaffold + NavHost
│   │   ├── MainViewModel.kt
│   │   └── navigation/
│   │       ├── MainBottomBar.kt    // 底部栏
│   │       └── MainNavGraph.kt     // 路由
│   ├── home/
│   │   ├── HomeScreen.kt
│   │   └── HomeViewModel.kt
│   ├── search/
│   │   ├── SearchScreen.kt
│   │   └── SearchViewModel.kt
│   └── profile/
│       ├── ProfileScreen.kt
│       └── ProfileViewModel.kt
├── data/                           // Repository & DataSource
├── domain/                         // UseCase & 纯业务
├── di/                             // Hilt Module
└── util/                           // 工具 & 扩展
```

## 🚀 开发环境

| 工具                   | 版本               |
| ---------------------- | ------------------ |
| Android Studio         | Hedgehog 2023.1.1+ |
| Gradle                 | 8.4+               |
| JDK                    | 11                 |
| minSdk                 | 24                 |
| targetSdk / compileSdk | 36                 |

## 📋 开发规范

### 1. 文件命名规范

| 场景      | 模板                  | 示例                     |
| --------- | --------------------- | ------------------------ |
| 顶级入口  | `MainActivity.kt`     | `MainActivity.kt`        |
| 整屏      | `模块名+Screen.kt`    | `HomeScreen.kt`          |
| ViewModel | `模块名+ViewModel.kt` | `HomeViewModel.kt`       |
| 底部栏    | `MainBottomBar.kt`    | `MainBottomBar.kt`       |
| 子组件    | `功能+Composable.kt`  | `SearchBarComposable.kt` |
| 扩展函数  | `类名+Ext.kt`         | `StringExt.kt`           |

### 2.包名层级

```
com.xxx.nearword
├── ui
│   └── {feature}
├── data
├── domain
├── di
└── util
```

### 3.资源命名

| 类型               | 模板                | 示例                   |
| ------------------ | ------------------- | ---------------------- |
| drawable           | `ic_模块_描述`      | `ic_search_search.png` |
| 布局/XML           | `activity_模块.xml` | `activity_main.xml`    |
| string/color/dimen | 按模块拆分文件      | `home_strings.xml`     |

### 4.Compose 代码风格

- 组件函数用**名词**：`HomeScreen()`、`SearchBar()`
- 状态放 `ViewModel`，UI 只读状态
- 禁止在 Composable 中直接 `mutableStateOf`（用 `remember` 或 `ViewModel`）
- 所有公共 API 写 KDoc；其余用 `//` 单行注释

### 5.依赖声明（Gradle Version Catalog）

在 `libs.versions.toml` 统一声明后，模块只需：

```kotlin
implementation(libs.androidx.lifecycle.viewmodel.compose)
```

### 6. Git提交规范（Conventional Commits）

格式为 `<type>(<scope>): <subject>`

| type       | 含义               |
| ---------- | ------------------ |
| `feat`     | 新功能             |
| `fix`      | 修复 bug           |
| `docs`     | 文档               |
| `style`    | 格式变动（无逻辑） |
| `refactor` | 重构               |
| `perf`     | 性能优化           |
| `test`     | 测试               |
| `chore`    | 构建/依赖          |
| `ci`       | CI/CD              |

**scope 和 subject 规则（一句话记）**

| 字段        | 写法                                      | 示例                      |
| ----------- | ----------------------------------------- | ------------------------- |
| **scope**   | 可选；用“模块/功能”小写即可               | `home` `nav` `api`        |
| **subject** | 50 字内，**英文小写祈使句**，**不加句号** | `add search history list` |

**示例**

```
feat(home): add search history list
fix(login): resolve crash on empty password
docs: update README
chore(deps): bump compose-bom to 2024.09.00
```

**首次提交**

```
Initial commit
```
