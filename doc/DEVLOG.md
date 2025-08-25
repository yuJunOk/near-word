[TOC]

# 配置项目Gradle

按下面配置，不然项目启动时，会重新下载gradle，并且把依赖下载到C盘。

![工程gradle配置](images/工程gradle配置.png)

# 引入ViewModel

1. 加依赖
   `build.gradle.kts` 追加

   ```
   implementation(libs.androidx.lifecycle.viewmodel.compose)
   ```

2. 声明坐标

   先在 [versions] 区域新增版本号（保持与 lifecycle-runtime-ktx 同版本即可）

   ```
   lifecycleViewModelCompose = "2.6.1"
   ```

   再在 [libraries] 区域新增库

   ```
   androidx-lifecycle-viewmodel-compose = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-compose", version.ref = "lifecycleViewModelCompose" }
   ```

3. 用法

```
@Composable
fun HomeScreen(vm: HomeViewModel = viewModel()) { … }
```

