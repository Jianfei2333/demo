# demo
基于Spring Boot的后端demo

1. 环境

   * Java ver 10.0
   * Apache Maven ver 3.5

2. 执行方式

   Bash：

   ```bash
   ./mvnw spring-boot:run -DskipTests=true
   ```

   Cmd:

   ```bash
   ./mvnw.cmd spring-boot:run -DskipTests=true
   ```

3. 文件框架

   ```bash
   .
   ├── mvnw
   ├── mvnw.cmd
   ├── pom.xml
   ├── README.md
   └── src
       └── main
           ├── java/com/example/demo
           │   ├── Bean
           │   │   ├── DataException.java #自定义数据库查询异常实体
           │   │   └── ResBody.java #Http Response实体
           │   ├── Controller
           │   │   ├── MemberController.java
           │   │   └── RootController.java
           │   ├── Dao
           │   │   └── MemberDao.java
           │   ├── DemoApplication.java #程序入口
           │   ├── Library
           │   │   └── utils
           │   │       ├── Configure.java #拦截器配置
           │   │       ├── GlobalExceptionHandler.java #全局异常处理器
           │   │       ├── Interceptors #拦截器定义
           │   │       │   ├── AuthInterceptor.java
           │   │       │   └── LogInterceptor.java
           │   │       └── NetService.java #Http Response功能封装
           │   ├── Model
           │   │   └── MemberAccount.java
           │   └── Service
           │       └── MemberService.java
           └── resources
               ├── application.properties
               ├── static
               └── templates
                   └── index.html
   
   ```

   > 1. mvnw，mvnw.cmd为maven脚本；
   > 2. pom.xml为项目的依赖包配置；
   > 3. README.md即本文件；
   > 4. /src/main/resources为项目静态资源，其中application.properties为项目配置文件。
   > 5. /src/main/java/com/example/demo为项目主体程序部分，分为如下层次：
   >    1. Bean：除数据库表之外的数据实体
   >    2. Controller：URI逻辑与简单的数据封装
   >    3. Dao：与数据库直接交互
   >    4. Library：与服务相关的代码段，其中utils包含了交互/拦截器/异常等功能的封装
   >    5. Model：数据库表在程序中的实体
   >    6. Service：服务层，介于Dao与Controller之间，实现主体业务逻辑
   >    7. DemoApplication.java为整个后端的入口