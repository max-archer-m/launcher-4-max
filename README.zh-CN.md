# Launcher4Max

> 英文语义源：[README.md](README.md)。

Launcher4Max 是一个克制且有明确意图的 Android 主屏幕启动器，旨在帮助用户以尽可能少的干扰，找到所需应用和设备信息。

## 产品方向

Launcher4Max 的目标是作为 Android 设备的默认主屏幕应用。产品首先服务于作者的日常需求，未来可能通过英文和简体中文体验服务更广泛的全球用户。

产品优先考虑直接访问、克制的默认体验、用户控制权和重视隐私的设计。广告、推荐流及以提高参与时长为目标的模式不在已确认的产品边界内。

已确认的产品意图、边界和待解决范围见[项目概览](overview.zh-CN.md)，其[英文语义源](overview.md)亦可查阅。

## 运行要求

- Android 12（API 31）或更高版本。
- 普通 Android 手机。Launcher4Max 仅以竖屏呈现；不支持横屏、折叠屏、平板、桌面模式和外部显示布局。
- 英文或简体中文。Launcher4Max 跟随系统语言，无法识别时回退英文。

## 安装

公开发布以 APK 形式附在本仓库的 Releases 中。首个发布推出前，可按[开发指南](docs/development.zh-CN.md)自行构建。

1. 安装该 APK。由于它不来自应用商店，Android 会先要求你允许从此来源安装。
2. 打开一次 Launcher4Max。
3. 把它设为默认主屏幕应用：在 Android 设置中把默认主屏幕应用选为 Launcher4Max。具体路径因设备而异，多数设备为**应用 → 默认应用 → 主屏幕应用**。当 Launcher4Max 不是默认启动器时，Home 上也会显示一个可关闭的提示；Settings 页面上的`默认主屏幕应用`条目会打开同一个系统目的地。
4. 要切回原启动器，在同一系统设置中选择它即可。卸载 Launcher4Max 或在 Android 设置中清除其应用数据，会移除本地保存的数据。

## 你的数据

- Launcher4Max 把数据保留在你的设备上。它不提供账号、广告、分析、崩溃报告上传、云服务或 Launcher4Max 运营的服务器；Home、Drawer、应用启动和 Settings 核心功能在没有网络连接时仍然可用。
- 收藏、Drawer 显示设置与快捷操作绑定保存在设备本地。
- Settings 提供手动本地备份与恢复。备份会把一个 JSON 文件写入你通过系统文档选择器选定的位置；恢复会读取你选择的文件，并在你明确确认后执行。该文件始终由你掌控，永不上传。产品不提供自动、定时或云端备份。
- 卸载 Launcher4Max 或在 Android 设置中清除其应用数据，会移除本地保存的数据。除你自己制作的备份文件外，当前产品此后不提供恢复功能。
- 可选的锁屏能力使用用途受限的 Android 无障碍服务。它只在你执行绑定到它的 Home 手势时，请求一次系统锁屏操作；它不读取屏幕或窗口内容，不观察其他应用中的活动，不收集无障碍事件，也不发送或共享数据。只有你把某个手势绑定为锁屏，并在 Android 无障碍设置中启用该服务后它才会生效；你可以随时关闭该服务，而不影响其他 Launcher 功能。
- 完整说明见[隐私与数据处理](docs/product/features/privacy.zh-CN.md)。

## 文档

- [项目概览](overview.zh-CN.md)
- [英文项目概览](overview.md)
- [隐私与数据处理](docs/product/features/privacy.zh-CN.md)
- [文档地图与治理规则](docs/documentation.zh-CN.md)
- [开发指南](docs/development.zh-CN.md)
- [验证指南](docs/validation.zh-CN.md)
- [产品基础需求](docs/requirements/product-foundation.zh-CN.md)
- [版本、产物与发布治理](docs/release.zh-CN.md)
- [已完成交付记录，当前为 1.0.0 至 1.6.0](docs/documentation.zh-CN.md#当前权威文档)
- [版本交付文档](docs/versions/version-delivery-format.zh-CN.md)
- [迭代记录格式](docs/iterations/iteration-record-format.zh-CN.md)
- [Agent 指令](AGENTS.zh-CN.md)
- [英文 Agent 指令](AGENTS.md)
- [许可证](LICENSE)

## 反馈

问题与缺陷报告欢迎提交到 [GitHub Issues 页面](https://github.com/max-archer-m/launcher-4-max/issues)。

## 许可证

本项目采用 [Apache License 2.0](LICENSE)。第三方组件及其许可证见[第三方通知](THIRD-PARTY-NOTICES.md)。
