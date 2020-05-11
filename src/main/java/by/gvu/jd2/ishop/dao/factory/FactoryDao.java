package by.gvu.jd2.ishop.dao.factory;

import by.gvu.jd2.ishop.dao.UserDao;
import by.gvu.jd2.ishop.dao.impl.UserDaoImpl;

public class FactoryDao {
    private static final FactoryDao instance = new FactoryDao();

    private UserDao userDao = null;

    private FactoryDao(){
        this.userDao = new UserDaoImpl();
    }

    public static FactoryDao getInstance(){
        return instance;
    }

    public UserDao getUserDao() {
        return this.userDao;
    }
}
