package by.gvu.jd2.ishop.controller;

import by.gvu.jd2.ishop.bean.define.Define;
import by.gvu.jd2.ishop.controller.command.FactoryCommand;
import by.gvu.jd2.ishop.dao.exception.ConnectionPoolException;
import by.gvu.jd2.ishop.dao.pool.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
            throw new ServletException("Ошибка инициализации соединения с базой данных");
        }

        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("windows-1251");
        response.setCharacterEncoding("windows-1251");

        String commandName = request.getParameter(Define.COMMAND);
        FactoryCommand.getInstance().getCommandByName(commandName).execute(request, response);
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().dispose();
        super.destroy();
    }
}