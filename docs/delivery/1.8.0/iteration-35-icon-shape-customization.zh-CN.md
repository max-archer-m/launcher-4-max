# 迭代 35：图标形状配置

> 适用版本契约：[1.8.0 交付](delivery.zh-CN.md)。本契约只定义范围，不授权实现、提交、推送、打 tag 或发布。

## 目标

交付从 Settings 到持久化，再到 Home 与抽屉一致呈现的已接受图标形状偏好。

## 产品与版本引用

- 产品契约基线：`0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`
- 适用产品文档：[图标形状](../../product/features/icon-shape.zh-CN.md)、[Settings 行为](../../product/surfaces/settings.zh-CN.md)、[Settings 呈现](../../product/presentation/settings.zh-CN.md)、[Home 行为](../../product/surfaces/home.zh-CN.md)、[抽屉行为](../../product/surfaces/drawer.zh-CN.md)
- 适用版本契约：[1.8.0 交付](delivery.zh-CN.md)
- 所有产品文档链接均按产品契约基线 `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6` 阅读。

### 已接受预览增补：2026-10-16

作者接受 `0ebf612e0553385bdce9e794a1f57500bf5feb8a` 中的有界预览增补，
补充原基线 `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`，明确预览几何、
示例名称与无障碍预期。目标与主要验收结果保持不变。

- 原边界：原基线中的图标形状 Settings 预览与选择契约。
- 增补边界：既有预览旅程内已接受的 64dp 预览内缩、16dp 行距、本地化示例名称
  与行无障碍语义，不新增产品范围。
- 增补修订中的变更来源：[图标形状](https://github.com/max-archer-m/launcher-4-max/blob/0ebf612e0553385bdce9e794a1f57500bf5feb8a/docs/product/features/icon-shape.zh-CN.md)、
  [Settings 呈现](https://github.com/max-archer-m/launcher-4-max/blob/0ebf612e0553385bdce9e794a1f57500bf5feb8a/docs/product/presentation/settings.zh-CN.md)
  与[图标形状设置线框](https://github.com/max-archer-m/launcher-4-max/blob/0ebf612e0553385bdce9e794a1f57500bf5feb8a/docs/product/wireframes/icon-shape-settings.txt)，
  以及适用的英文语义源。
- 验收与验证在既有选择、持久化、Home/Drawer 及备份旅程之外，包含增补后的预览几何、
  名称呈现与无障碍语义。依赖该增补的实现开始前，实现线必须包含增补基线。
  其他产品引用仍采用原基线。

## 可观察结果

作者可以在 Settings 选择契约规定的图标形状，在 Home 与抽屉的合格应用图标上看到一致结果，并在重建与重启后保留选择。

## 纳入工作

- Settings 图标形状入口、选项、文案与选择行为。
- 持久化、默认行为以及与现有设置和备份数据的兼容。
- 通过共享形状契约在 Home 与抽屉中呈现图标。
- 英文与简体中文资源、导航、呈现、术语、隐私与线框同步。
- 覆盖选择、持久化、呈现与无障碍语义的聚焦测试。

## 排除工作

- 自定义应用图稿、逐应用独立形状与折叠屏适配。
- 应用名称位置或 Home 布局变更。
- 模块折叠与展开。

## 技术变更面

Settings 状态与序列化、共享图标呈现、Home 与抽屉界面、资源、导航、线框与聚焦测试。

## 依赖与顺序

本迭代是 1.8.0 的第一个迭代。实现线必须包含记录的产品基线。

## 迁移与兼容影响

新偏好缺失时，既有安装使用契约规定的默认值。既有备份按当前方向性兼容规则继续导入。

## 安全、隐私、权限与许可影响

不引入新权限、网络、账户或外部服务。隐私文案必须与本地设置行为一致。

## 风险与未决决策

OEM 应用图标遮罩可能暴露源图稿差异。实现必须将应用内形状偏好与系统启动器遮罩分离。

## 验收标准

- Settings 双语呈现契约规定的图标形状选项。
- 选择跨重启持久，并在 Home 与抽屉一致呈现。
- 既有设置与备份行为保持兼容。
- 无障碍标签与焦点顺序有效。

## 验证要求

在主设备上于 Home 与抽屉、相关排列、重启和备份恢复后验证各形状，并在可用时执行聚焦自动化检查。

## 相关决策与技术评估

- [图标形状契约](../../product/features/icon-shape.zh-CN.md)
- [Settings 行为](../../product/surfaces/settings.zh-CN.md)
