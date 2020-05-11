package by.gvu.jd2.ishop.service;

import by.gvu.jd2.ishop.bean.User;
import by.gvu.jd2.ishop.service.exception.ServiceException;

public interface UserService {
    Boolean registration(User registerUser, String password) throws ServiceException;
    User login(String login, String password) throws ServiceException;
    User getByLogin(String login) throws ServiceException;
    User getById(Long id) throws ServiceException;
}
