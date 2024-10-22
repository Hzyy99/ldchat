临大Chat

项目简介：

临大Chat，皆在为临大的学生提供一个实时的交流平台，具有联系人列表，群聊，成员列表。包含图片，文 字，语音，表情包等消息类型，支持回复，消息已读未读列表，未读数统计，IP归属地。

技术栈：SpringBoot+Redis+Caffeine+RocketMQ+MySQL+MybatisPlus+WebSocket+Netty+MinIO

项目职责： 1、负责项目的后端代码开发与项目架构的设计，与前端用Swagger文档进行协作开发。

2、借助微信开放API，通过微信扫码登录，实现Channel与OpenID的关联，并以第三方二维码方式呈现。

3、结合AOP和封装工具，实现Token解析，请求上下文存储，黑名单拦截以及接口日志记录。

4、基于Redisson，封装注解式的分布式锁工具。精简加锁操作。

5、集中管理线程池，采用异步执行优化接口响应速度。确保线程池的异常捕获与优雅停机，提升稳定性。

6、针对模板方法模式，打造支持混合的二级缓存框架。特别支持Keys的差集缓存，提升易用性。

7、采用RocketMQ进行消息广播，WebSocket服务过滤连接消息，实现跨进程的消息推送。

8、为了避免深翻页和频繁变动问题。引入游标翻页机制，简化游标翻页实现。
![image](https://github.com/Hzyy99/ldchat/blob/ldchat/ldchat.png)
