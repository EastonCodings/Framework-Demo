package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.curd.Server;

public class HibernateUtil {
    // 单例模式
    private static SessionFactory sessionFactory = null;

    private HibernateUtil() {

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // 如果还没创建就创建一个新的对象
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(Server.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
