package by.gvu.jd2.ishop.service.impl;

import by.gvu.jd2.ishop.bean.User;
import by.gvu.jd2.ishop.dao.UserDao;
import by.gvu.jd2.ishop.dao.exception.DaoException;
import by.gvu.jd2.ishop.dao.factory.FactoryDao;
import by.gvu.jd2.ishop.service.UserService;
import by.gvu.jd2.ishop.service.exception.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;

public class UserServiceImpl implements UserService {
    public Boolean registration(User registerUser, String password) throws ServiceException {
        Boolean resultRegistration = false;
        UserDao userDao = FactoryDao.getInstance().getUserDao();

        try {
            if (userDao.getByLogin(registerUser.getLogin())!=null){
                throw new ServiceException("Такой пользователь уже существует");
            }

            registerUser.setPswMd5(DigestUtils.md5Hex(password));
            registerUser.setPswSh3(DigestUtils.sha3_224Hex(password));

            resultRegistration = userDao.add(registerUser);
        } catch (DaoException daoException){
            daoException.printStackTrace();
            throw new ServiceException("Ошибка регистрации пользователя.", daoException);
        }
        System.out.println("resultRegistration ["+resultRegistration+"]");

        return resultRegistration;
    }

    public User login(String login, String password) throws ServiceException {
        User loginedUser = null;
        UserDao userDao = FactoryDao.getInstance().getUserDao();

        try {
            loginedUser = userDao.verify(login, password);
        } catch (DaoException daoException) {
            throw new ServiceException("Ошибка авторизации", daoException);
        }

        return loginedUser;
    }

    public User getByLogin(String login) throws ServiceException {
        User user = null;
        UserDao userDao = FactoryDao.getInstance().getUserDao();

        try {
            user = userDao.getByLogin(login);
        } catch (DaoException daoException) {
            throw new ServiceException("Пользователь не найден", daoException);
        }

        return user;
    }

    public User getById(Long id) throws ServiceException {
        User user = null;
        UserDao userDao = FactoryDao.getInstance().getUserDao();

        try {
            user = userDao.getById(id);
        } catch (DaoException daoException) {
            throw new ServiceException("Пользователь не найден", daoException);
        }

        return user;
    }
}
