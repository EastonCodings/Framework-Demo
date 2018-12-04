package com.SM;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 直接在启动文件SpringbootApplication.java的类上配置@MapperScan，这样就可以省去，单独给每个Mapper上标识@Mapper的麻烦
@MapperScan("com.SM.dao")
public class SpringBootMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisApplication.class, args);
	}
}



/*  MyBatis 和 Hibernate 的区别

    MyBatis 和 Hibernate 都是优秀的持久化框架，都支持JDBC（Java DataBase Connection）和JTA（Java Transaction API）事务处理。

    MyBatis 优点

                        更加轻量级，如果说 Hibernate 是全自动的框架，MyBatis 就是半自动的框架；
                        入门简单，即学即用，并且延续了很好的 SQL 使用经验；

    Hibernate 优点

                        开发简单、高效，不需要编写 SQL 就可以进行基础的数据库操作；
                        可移植行好，大大降低了 MySQL 和 Oracle 之间切换的成本（因为使用了 HQL 查询，而不是直接写SQL语句）；
                        缓存机制上 Hibernate 也好于 MyBatis；

*/