package by.gvu.jd2.ishop.dao.impl;

import by.gvu.jd2.ishop.bean.User;
import by.gvu.jd2.ishop.bean.define.Define;
import by.gvu.jd2.ishop.dao.UserDao;
import by.gvu.jd2.ishop.dao.exception.ConnectionPoolException;
import by.gvu.jd2.ishop.dao.exception.DaoException;
import by.gvu.jd2.ishop.dao.pool.ConnectionPool;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    public Boolean add(User user) throws DaoException {
        Boolean resultValue = false;

        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connectionAdd = null;
        PreparedStatement preparedStatementAdd = null;

        try {
            connectionAdd = connectionPool.takeConnection();
            preparedStatementAdd = connectionAdd.prepareStatement(Define.SQL_USER_ADD);

            preparedStatementAdd.setString(1, user.getLogin());
            preparedStatementAdd.setString(2, user.getPswSh3());
            preparedStatementAdd.setString(3, user.getPswMd5());
            preparedStatementAdd.setString(4, user.getEmail());
            preparedStatementAdd.setInt(5, user.getRoleId());
            preparedStatementAdd.setString(6, user.getFirstName());
            preparedStatementAdd.setString(7, user.getSecondName());
            preparedStatementAdd.setString(8, user.getNikName());
            preparedStatementAdd.setInt(9, user.getSexId());
            preparedStatementAdd.setTimestamp(10, user.getBirthday());

            resultValue = (preparedStatementAdd.executeUpdate() > 0);
        } catch (ConnectionPoolException e) {
            throw new DaoException("Ошибка получения полу соединений", e);
        } catch (SQLException e) {
            throw new DaoException("Ошибка при добавлении пользователя", e);
        } finally {
            connectionPool.closeConnection(connectionAdd, preparedStatementAdd);
        }

        return resultValue;
    }

    public User verify(String userLogin, String userPassword) throws DaoException {
        User user = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connectionVerify = null;
        PreparedStatement preparedStatementVerify = null;
        ResultSet resultSetVerify = null;

        try{
            connectionVerify = connectionPool.takeConnection();
            preparedStatementVerify = connectionVerify.prepareStatement(Define.SQL_USER_GET_BY_LOGIN);

            preparedStatementVerify.setString(1, userLogin);
            resultSetVerify = preparedStatementVerify.executeQuery();

            if (resultSetVerify.next()){

                String pswMd5 = DigestUtils.md5Hex(userPassword);
                String pswSha3 = DigestUtils.sha3_224Hex(userPassword);

                if (pswMd5.equals(resultSetVerify.getString(Define.BEAN_USER_PSW_MD5)) &&
                    pswSha3.equals(resultSetVerify.getString(Define.BEAN_USER_PSW_SHA3))) {

                    user = fillValuesFromResultSet(resultSetVerify);
                } else {
                    throw new DaoException("Не верно указан пароль");
                }
            } else {
                throw new DaoException("Пользователь с указаным логином не найден");
            }
        } catch (ConnectionPoolException e) {
            throw new DaoException("Ошибка получения полу соединений", e);
        } catch (SQLException e) {
            throw new DaoException("Ошибка при добавлении пользователя", e);
        } finally {
            connectionPool.closeConnection(connectionVerify, preparedStatementVerify);
        }

        return user;
    }

    public User getByLogin(String userLogin) throws DaoException {
        User user = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connectionGetByLogin = null;
        PreparedStatement preparedStatementGetByLogin = null;
        ResultSet resultSetGetByLogin = null;

        try{
            connectionGetByLogin = connectionPool.takeConnection();
            preparedStatementGetByLogin = connectionGetByLogin.prepareStatement(Define.SQL_USER_GET_BY_LOGIN);

            preparedStatementGetByLogin.setString(1, userLogin);
            resultSetGetByLogin = preparedStatementGetByLogin.executeQuery();

            if (resultSetGetByLogin.next()){
                user = fillValuesFromResultSet(resultSetGetByLogin);
            } else {
                user = null;
            }
        } catch (ConnectionPoolException e) {
            throw new DaoException("Ошибка получения полу соединений", e);
        } catch (SQLException e) {
            throw new DaoException("Ошибка при добавлении пользователя", e);
        } finally {
            connectionPool.closeConnection(connectionGetByLogin, preparedStatementGetByLogin);
        }

        return user;
    }

    public User getById(Long loginId) throws DaoException {
        User user = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connectionGetById = null;
        PreparedStatement preparedStatementGetById = null;
        ResultSet resultSetGetById = null;

        try{
            connectionGetById = connectionPool.takeConnection();
            preparedStatementGetById = connectionGetById.prepareStatement(Define.SQL_USER_GET_BY_ID);

            preparedStatementGetById.setLong(1, loginId);
            resultSetGetById = preparedStatementGetById.executeQuery();

            if (resultSetGetById.next()){
                user = fillValuesFromResultSet(resultSetGetById);
            } else {
                user = null;
            }
        } catch (ConnectionPoolException e) {
            throw new DaoException("Ошибка получения полу соединений", e);
        } catch (SQLException e) {
            throw new DaoException("Ошибка при добавлении пользователя", e);
        } finally {
            connectionPool.closeConnection(connectionGetById, preparedStatementGetById);
        }

        return user;
    }

    private User fillValuesFromResultSet(ResultSet sourceResultSet) throws SQLException {
        User user = new User();
        user.setId(sourceResultSet.getLong(Define.BEAN_USER_ID));
        user.setLogin(sourceResultSet.getString(Define.BEAN_USER_LOGIN));
        user.setEmail(sourceResultSet.getString(Define.BEAN_USER_EMAIL));
        user.setRoleId(sourceResultSet.getInt(Define.BEAN_USER_ROLE));
        user.setFirstName(sourceResultSet.getString(Define.BEAN_USER_FIRST_NAME));
        user.setSecondName(sourceResultSet.getString(Define.BEAN_USER_SECOND_NAME));
        user.setNikName(sourceResultSet.getString(Define.BEAN_USER_NIK_NAME));
        user.setSexId(sourceResultSet.getInt(Define.BEAN_USER_SEX));
        user.setBirthday(sourceResultSet.getTimestamp(Define.BEAN_USER_BIRTHDAY));

        return user;
    }
}