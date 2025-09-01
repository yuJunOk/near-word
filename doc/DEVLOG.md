[TOC]

# 一、配置项目Gradle

按下面配置，不然项目启动时，会重新下载gradle，并且把依赖下载到C盘。

![工程gradle配置](images/工程gradle配置.png)

# 二、引入ViewModel

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

# 三、引入中英词典数据

在开发中英词典应用时，首先需要考虑如何引入词典数据。数据来源可以是CSV文件、SQLite数据库等格式，关键在于能够高效地读取数据，并将其存储到应用的数据库中。经过详细的调研，我发现了以下三种可行的方案：

1. **ECDICT**
   - **来源**：[Releases · skywind3000/ECDICT](https://github.com/skywind3000/ECDICT/releases)
   - **特点**：该词典数据非常全面，涵盖了大量单词及其详细释义，但文件体积较大，对于轻量级应用来说可能不太合适。因此，我暂时不将其作为首选方案。
2. **十万词英汉词典词库SQLite数据库**
   - **来源**：[十万词英汉词典词库SQLite数据库 - GitCode](https://gitcode.com/open-source-toolkit/daa3c)
   - **特点**：该词典数据库轻量级，体积较小，适合在移动设备上使用。我将优先尝试使用这个数据库，以验证其是否满足我们的需求。
3. **ITeye技术社区**
   - **来源**：[ITeye技术社区](https://www.iteye.com/)
   - **特点**：该社区似乎也提供了相关的词典数据，但目前网站无法访问。我将持续关注该资源，以便在需要时作为备选方案。

综上所述，我将首先尝试使用**十万词英汉词典词库SQLite数据库**，因为它在轻量级和数据完整性之间取得了较好的平衡。如果在后续开发过程中发现该数据库无法满足我们的需求，我们将重新评估其他方案。
