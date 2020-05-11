package by.gvu.jd2.ishop.controller.command;

import by.gvu.jd2.ishop.bean.User;
import by.gvu.jd2.ishop.bean.define.Define;
import by.gvu.jd2.ishop.service.UserService;
import by.gvu.jd2.ishop.service.exception.ServiceException;
import by.gvu.jd2.ishop.service.factory.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Define.VERIFY_LOGIN).forward(request, response);

        UserService userService = FactoryService.getInstance().getUserService();

        try {
            HttpSession httpSession = request.getSession();

            User loginedUser = userService.login(request.getParameter(Define.WEB_USER_LOGIN), request.getParameter(Define.WEB_USER_PASSWORD));

            httpSession.setAttribute(Define.CURRENT_USER, loginedUser);
            response.sendRedirect(Define.MAIN_PAGE);
        } catch (ServiceException serviceException) {
            request.setAttribute(Define.ERROR_MESSAGE, serviceException.getMessage());
            request.getRequestDispatcher(Define.LOGIN_PAGE).forward(request, response);
        }
    }
}
