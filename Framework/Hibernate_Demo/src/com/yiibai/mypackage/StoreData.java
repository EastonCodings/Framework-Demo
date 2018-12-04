package com.yiibai.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {

        // 使用 Hibernate 的 API 来完成将 Server 信息保存到 mysql 数据库中的操作
        // creating configuration object
        // Hibernate 框架加载 hibernate.cfg.xml 文件
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // populates the data of the configuration file

        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        // creating session object
        Session session = factory.openSession();

        // creating transaction object
        Transaction t = session.beginTransaction();

        Server server = new Server();
        server.setWarehouseName("vxvc");
        server.setRecipients("vxcvxcv");
        server.setCreatedBy(2);
        server.setModifiedBy(2);

        // persist --- 不会缓存对象 + 持久化
        // save --- 会缓存对象 + 持久化
        // 缓存只对查询有效
        session.persist(server); // persisting the object

        t.commit(); // transaction is committed
        session.close();

        System.out.println("successfully saved");

    }
}
