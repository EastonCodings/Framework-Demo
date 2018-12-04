package me.gacl.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import me.gacl.domain.Server;
import me.gacl.util.MyBatisUtil;

public class TestCRUDByXmlMapper {

    // @Test
    public void testAdd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
        // SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        /**
         * 映射sql的标识字符串， me.gacl.mapping.serverMapper是serverMapper.xml文件中mapper标签的namespace属性的值，
         * addServer是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
         */
        String statement = "me.gacl.mapping.serverMapper.addServer";// 映射sql的标识字符串

        Server server = new Server();
        server.setWarehouseName("jfgjfjfgj");
        server.setRecipients("jfgjfjf");
        server.setCreatedBy(2);
        server.setModifiedBy(2);

        // 执行插入操作
        int retResult = sqlSession.insert(statement, server);

        // 手动提交事务
        sqlSession.commit();

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    // @Test
    public void testUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        /**
         * 映射sql的标识字符串， me.gacl.mapping.serverMapper是serverMapper.xml文件中mapper标签的namespace属性的值，
         * updateServer是update标签的id属性值，通过update标签的id属性值就可以找到要执行的SQL
         */
        String statement = "me.gacl.mapping.serverMapper.updateServer";// 映射sql的标识字符串

        Server server = new Server();
        server.setId(149);
        server.setWarehouseName("wqewqewqe");
        server.setRecipients("GACLAAA");
        server.setCreatedBy(3);
        server.setModifiedBy(3);

        // 执行修改操作
        int retResult = sqlSession.update(statement, server);

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    // @Test
    public void testDelete() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        /**
         * 映射sql的标识字符串， me.gacl.mapping.serverMapper是serverMapper.xml文件中mapper标签的namespace属性的值，
         * deleteServer是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的SQL
         */
        String statement = "me.gacl.mapping.serverMapper.deleteServer";// 映射sql的标识字符串

        // 执行删除操作
        int retResult = sqlSession.delete(statement, 150);

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    // @Test
    public void testGetAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        /**
         * 映射sql的标识字符串， me.gacl.mapping.serverMapper是serverMapper.xml文件中mapper标签的namespace属性的值，
         * getAllServers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "me.gacl.mapping.serverMapper.getAllServers";// 映射sql的标识字符串

        // 执行查询操作，将查询结果自动封装成List<Server>返回
        List<Server> lstServers = sqlSession.selectList(statement);

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(lstServers);
    }
}
