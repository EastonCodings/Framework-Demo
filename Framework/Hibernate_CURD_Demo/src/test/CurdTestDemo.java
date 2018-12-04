package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.curd.Server;

import util.HibernateUtil;

public class CurdTestDemo {

    public static void main(String[] args) {
        CurdTestDemo curdTest = new CurdTestDemo();
        // 增加
        curdTest.addServer();
        // 查询一个
        // curdTest.findServerByid();
        // 查询所有
        // curdTest.findAllServer();
        // 更新
        // curdTest.updateServerByid();
        // 删除
        curdTest.deleteServer();
    }

    public void findServerByid() {
        // 根据id查找信息
        // 单例模式创建sessionfatory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // 创建session对象
        Session session = sessionFactory.openSession();
        // 开始事务
        Transaction transaction = session.beginTransaction();
        // 根据id查找信息
        Server server = session.get(Server.class, 156);
        System.out.println("根据id查找结果：");
        System.out.println(server.getWarehouseName() + " " + server.getSlackGroup());
        // 提交事务
        transaction.commit();
        // 关闭session，释放资源
        session.close();
    }

    public void findAllServer() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        // 开始事务
        Transaction transaction = session.beginTransaction();
        // 获取查询对象，参数为hql语言，Server为类名
        Query query = session.createQuery("from Server");
        // 使用查询对象返回集合，集合中封装hql中查询的类实例化对象
        List list = query.list();
        System.out.println("全部信息：");
        for (int i = 0; i < list.size(); i++) {
            Server server = (Server) list.get(i);
            System.out.println(server.getWarehouseName() + " " + server.getSlackGroup());
        }
        // 关闭事务
        transaction.commit();
        // 关闭session
        session.close();
    }

    // 先查后更
    public void updateServerByid() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();
        // 查找相关id的对象
        Server server = session.get(Server.class, 156);
        server.setWarehouseName("464564");
        server.setSlackGroup("vzxvxc");
        server.setCreatedBy(2);
        server.setModifiedBy(2);
        // 更新信息
        session.update(server);
        // 提交事务
        transaction.commit();
        // 关闭 session
        session.close();
    }

    // 先查后删
    public void deleteServer() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();
        Server server = new Server();
        server = session.get(Server.class, 159);
        // 删除空对象会异常
        if (server != null) {
            session.delete(server);
        } else {
            System.out.println("已经删除了~！");
        }
        // 事务提交，相当于conn.commit
        transaction.commit();
        // 关闭 session，释放资源
        session.close();
    }

    public void addServer() {
        SessionFactory sessionFactor = HibernateUtil.getSessionFactory();
        Session session = sessionFactor.openSession();
        Transaction transaction = session.beginTransaction();
        Server server = new Server();
        server.setWarehouseName("edqwedqwed");
        server.setSlackGroup("vdfbdb");
        server.setCreatedBy(2);
        server.setModifiedBy(2);
        session.save(server);
        transaction.commit();
        session.close();
    }
}
