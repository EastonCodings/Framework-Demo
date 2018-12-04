package me.gacl.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import me.gacl.domain.Server;
import me.gacl.mapping.ServerMapperI;
import me.gacl.util.MyBatisUtil;

public class TestCRUDByAnnotationMapper {

    // @Test
    public void testAdd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        // 得到ServerMapperI接口的实现类对象，ServerMapperI接口的实现类对象由sqlSession.getMapper(ServerMapperI.class)动态构建出来
        ServerMapperI mapper = sqlSession.getMapper(ServerMapperI.class);

        Server server = new Server();
        server.setWarehouseName("vxvc");
        server.setRecipients("vxcvxcv");
        server.setCreatedBy(2);
        server.setModifiedBy(2);
        int add = mapper.add(server);

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(add);
    }

    // @Test
    public void testUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        // 得到ServerMapperI接口的实现类对象，ServerMapperI接口的实现类对象由sqlSession.getMapper(ServerMapperI.class)动态构建出来
        ServerMapperI mapper = sqlSession.getMapper(ServerMapperI.class);

        Server server = new Server();
        server.setId(152);
        server.setWarehouseName("zxvzxvdfdsf");
        server.setRecipients("vvz");
        server.setCreatedBy(3);
        server.setModifiedBy(3);

        // 执行修改操作
        int retResult = mapper.update(server);

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    // @Test
    public void testDelete() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        // 得到ServerMapperI接口的实现类对象，ServerMapperI接口的实现类对象由sqlSession.getMapper(ServerMapperI.class)动态构建出来
        ServerMapperI mapper = sqlSession.getMapper(ServerMapperI.class);

        // 执行删除操作
        int retResult = mapper.deleteById(151);

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    // @Test
    public void testGetServer() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        // 得到ServerMapperI接口的实现类对象，ServerMapperI接口的实现类对象由sqlSession.getMapper(ServerMapperI.class)动态构建出来
        ServerMapperI mapper = sqlSession.getMapper(ServerMapperI.class);

        // 执行查询操作，将查询结果自动封装成User返回
        Server server = mapper.getById(152);

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(server);
    }

    // @Test
    public void testGetAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        // 得到ServerMapperI接口的实现类对象，ServerMapperI接口的实现类对象由sqlSession.getMapper(ServerMapperI.class)动态构建出来
        ServerMapperI mapper = sqlSession.getMapper(ServerMapperI.class);

        // 执行查询操作，将查询结果自动封装成List<User>返回
        List<Server> lstServers = mapper.getAll();

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(lstServers);
    }
}
