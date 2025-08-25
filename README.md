# 🗣️ NearWord 音近词典

> 看到中文，就能读出英文
> **“零听力”也能掌握纯正发音**

## 🎯 一句话介绍

NearWord 把 **英文单词 → 中文音近词** 的映射做成离线词典：
用户看到中文就能**立刻复现**英文读音，无需联网、无需播放音频，真正做到“见字能读”。

## 🚀 核心能力

| 功能         | 说明                                                     |
| ------------ | -------------------------------------------------------- |
| 离线发音词典 | 集成 CMU-Dict / Oxford 5000，含音标、翻译、离线 TTS 音频 |
| 音近算法     | 将英文音标 → 中文同音字/谐音（例：`apple` → “艾坡”）     |
| 零听力学习   | 不播放音频，仅显示中文谐音即可跟读                       |
| 多端同步     | 单 Activity + Compose，未来可扩展到 Wear OS、Desktop     |

## 🛠️ 技术栈速览

| 层级     | 选型                                 |
| -------- | ------------------------------------ |
| 语言     | Kotlin 2.0                           |
| UI       | Jetpack Compose                      |
| 架构     | MVVM + UseCase                       |
| 导航     | Navigation-Compose                   |
| 词典包   | 本地 SQLite + CMU-Dict / Oxford 5000 |
| 音近引擎 | 自定义映射表 + 拼音相似度算法        |
| 依赖注入 | Hilt                                 |
| 构建     | Gradle Version Catalog               |

## 📦 实现路线

| 阶段   | 目标                               | 状态        |
| ------ | ---------------------------------- | ----------- |
| ✅ v0.1 | 项目骨架 & 规范                    | DONE        |
| 🚧 v0.2 | 引入离线词典包（含音标/翻译/音频） | IN PROGRESS |
| ⏳ v0.3 | 音标 → 中文音近词映射算法          | TODO        |
| ⏳ v0.4 | 搜索 & 收藏 & 历史                 | TODO        |
| ⏳ v1.0 | 发布 Google Play                   | TODO        |

## 🔧 快速开始

```bash
git clone https://github.com/yourname/NearWord.git
cd NearWord
./gradlew assembleDebug
```

## 📖 规范

开发规范、包结构、命名约定等详见
👉 [CONVENTIONS.md](doc/CONVENTIONS.md)

## 📝 开发日志

每日进度、踩坑记录见
👉 [DEVLOG.md](doc/DEVLOG.md)

## 🤝 参与贡献

欢迎提 Issue / PR，一起让“零听力”学英语更简单！