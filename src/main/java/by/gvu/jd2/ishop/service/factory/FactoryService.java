package by.gvu.jd2.ishop.service.factory;

import by.gvu.jd2.ishop.service.UserService;
import by.gvu.jd2.ishop.service.impl.UserServiceImpl;

public class FactoryService {
    private static final FactoryService instance = new FactoryService();

    private UserService userService = null;

    private FactoryService() {
        this.userService = new UserServiceImpl();
    }

    public static FactoryService getInstance(){
        return instance;
    }

    public UserService getUserService() {
        return this.userService;
    }
}
