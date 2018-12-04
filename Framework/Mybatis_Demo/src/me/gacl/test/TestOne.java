package me.gacl.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.gacl.domain.Server;

public class TestOne {

    public static void main(String[] args) throws IOException {

        // mybatis的配置文件
        String resource = "conf.xml";

        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = TestOne.class.getClassLoader().getResourceAsStream(resource);

        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
//         Reader reader = Resources.getResourceAsReader(resource);

        // 构建sqlSession的工厂
//         SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

        /**
         * 映射sql的标识字符串， me.gacl.mapping.serverMapper是serverMapper.xml文件中mapper标签的namespace属性的值，
         * getServer是select标签的id属性的值，通过select标签的id属性的值，就可以找到要执行的SQL
         */
        String statement = "me.gacl.mapping.serverMapper.getServer";// 映射sql的标识字符串

        // 执行查询返回一个唯一server对象的sql
//        Server server = (Server) session.selectOne(statement, 1);
        Server server = (Server) session.selectOne(statement, 2);
        System.out.println(server);
    }

}
