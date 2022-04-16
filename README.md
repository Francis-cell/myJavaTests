# myJavaTests

### 0、修改历史
####2022.4.16
#####1、提交第一次
```txt
1、新增十进制转换二进制(支持浮点数)，二进制转换十进制(支持负数)
2、新增BigDecimal的使用，以及相关的工具类
3、新增邮件发送JavaMail的使用，以及封装好的发送邮件的工具类
```

#####2、提交第二次
```txt
1、修复进制转换工具类，将里面的一些不需要进行暴露的方法置为private私有的方法，在外面无法访问使用（这些方法本身就是供内部使用的方法）
2、自定义了一个日志类，可以使用MyLoggerUtils.logger.info("这是一条info消息");这种形式在控制台留下日志信息，也可以调用相关方法在本地的指定文件里追加日志信(目前仅仅支持在Windows下的路径，Linux上的路径没有测试，不知道是否能够成功使用)。
```


### 1、JavaMailTests

#### 0、参考链接

1、[利用java实现发送邮件](https://blog.csdn.net/xuemengrui12/article/details/78530594)



#### 1、环境需要的maven依赖

```xml
<!-- 引入mail(邮件发送) -->
<!-- https://mvnrepository.com/artifact/javax.mail/mail -->
<dependency>
    <groupId>javax.mail</groupId>
    <artifactId>mail</artifactId>
    <version>1.4.7</version>
</dependency>
```





