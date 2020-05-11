package by.gvu.jd2.ishop.dao;

import by.gvu.jd2.ishop.bean.User;
import by.gvu.jd2.ishop.dao.exception.DaoException;

public interface UserDao {
    Boolean add(User user) throws DaoException;
    User verify(String userLogin, String userPassword) throws DaoException;
    User getByLogin(String userLogin) throws DaoException;
    User getById(Long loginId) throws DaoException;
}
