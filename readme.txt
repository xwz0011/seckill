============day1===================
1. 创建项目，导入依赖
    1）thymleaf
    2）mybatis-plus
    3）mysql驱动
    4）lombok
    5）springweb
2. 编写配置文件
3. 创建所需要的文件夹
4. 编写DemoController，hello方法测试搭建
5. 编写登录功能
    1）MD5双重加密的实现
    2）JSR303实现登录信息验证，自定义JSR303注解
    3）定义全局异常处理类
    4）cookie+session的使用
    5）分布式session：spring-boot-starter-data-redis、spring-session-data-redis、commons-pool2

    总结：
        最初：前端-->controller-->service-->mapper-->db
        1)首先我们要对前端传来的数据做校验，用到了JSR303，使用validation注解完成，其中自定义了一个校验注解IsMobile
        2)当校验完参数以后，发现：当参数出现问题时无法返回错误信息，于是定义了全局异常处理，GlobalException，使用@RestControllerAdvice
        和@ExceptionHandler注解实现
        3)分布式session问题：两种方案
            * 使用spring-session
            * 使用redis存储用户信息
        4)每次在controller中进行session校验很麻烦，于是定义了webConfig和UserArgumentResolve，在请求到达controller前进行校验拿去user




