# fast-spring-cloud

#### 项目介绍
fast-spring-boot基于SpringBoot，致力于做更简洁的Web系统，代码简洁，注释丰富，上手容易。

#### 软件架构

 1. fast-core：基础工具类
 2. fast-core-mybatis：对Mybatis-plus扩展工具类
 3. fast-core-web：Web项目工具类
 4. fast-web-example：项目中用到的技术演示 

#### 项目特点

 1. 基于SpringBoot,简化了大量项目配置和maven依赖,让您更专注于业务开发,独特的分包方式,代码多而不乱；
 2. 利用Hutool工具包，帮助我们简化代码，方便快捷的使用我们经常使用的工具方法；
 3. 利用Mybatis-plus简化CQRA
 4. 利用Jwt进行安全认证，实现前后台完全分离；
 5. 利用swagger注解方式，自动生成API文档。
 
 #### 使用到的技术

 1. [SpringBoot](https://projects.spring.io/spring-boot/)：是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程；
 2. [Hutool](http://hutool.mydoc.io)：Java基础工具类，对文件、流、加密解密、转码、正则、线程、XML等JDK方法进行封装，组成各种Util工具类；
 3. [Mybatis-plus](http://mp.baomidou.com/#/quick-start)：是一个 Mybatis 的增强工具，在 Mybatis 的基础上只做增强不做改变，为简化开发、提高效率而生；
 4. [Jwt](https://jwt.io/)：JWT 是JSON Web Token 的简称，通过一个加密密钥来进行前后端的鉴权，更加简单和易于扩展。
 5. [swagger](https://swagger.io/)：是一个简单但功能强大的API表达工具，使用Swagger生成API，我们可以得到交互式文档，自动生成代码的SDK以及API的发现特性等。

#### 安装教程

1. 安装JDK8以上
2. 安装Maven
3. 演示example需要安装Mysql

#### 使用说明

1. git clone https://gitee.com/gitile/fast-spring-boot.git
2. mvn clean install -Dmaven.test.skip=true
3. cd fast-web-example
4. 导入doc下数据库脚本，修改application-dev.yml中数据库配置
5. mvn spring-boot:run
6. 访问http://localhost:8080/swagger-ui.html 查看swagger接口文档

