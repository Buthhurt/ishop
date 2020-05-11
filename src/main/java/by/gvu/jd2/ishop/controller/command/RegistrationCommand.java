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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegistrationCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher(Define.VERIFY_REGISTRATION).forward(request, response);

        UserService userService = FactoryService.getInstance().getUserService();

            HttpSession httpSession = request.getSession();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Define.DATE_FORMAT);

            User registerUser = new User();
            registerUser.setLogin(request.getParameter(Define.WEB_USER_LOGIN));
            registerUser.setEmail(request.getParameter(Define.WEB_USER_EMAIL));
            registerUser.setRoleId(1);
            registerUser.setFirstName(request.getParameter(Define.WEB_USER_FIRST_NAME));
            registerUser.setSecondName(request.getParameter(Define.WEB_USER_SECOND_NAME));
            registerUser.setNikName(request.getParameter(Define.WEB_USER_NIK_NAME));
            registerUser.setSexId(1);
            try {
                registerUser.setBirthday(new Timestamp(simpleDateFormat.parse(request.getParameter(Define.WEB_USER_BIRTHDAY)).getTime()));
            } catch (ParseException parseException){
                registerUser.setBirthday(new Timestamp(0));
            } catch (NullPointerException nullPointerException){
                registerUser.setBirthday(new Timestamp(0));
            }

            try {
                if (userService.registration(registerUser, request.getParameter(Define.WEB_USER_PASSWORD))) {
                    httpSession.setAttribute(Define.CURRENT_USER, userService.getByLogin(request.getParameter(Define.WEB_USER_LOGIN)));
                    response.sendRedirect(Define.MAIN_PAGE);
                } else {
                    httpSession.removeAttribute(Define.CURRENT_USER);
                    request.getRequestDispatcher(Define.REGISTRATION_PAGE).forward(request, response);
                }
            } catch (ServiceException serviceException) {
                httpSession.removeAttribute(Define.CURRENT_USER);
                request.setAttribute("errorMessage", serviceException.getMessage());
                request.getRequestDispatcher(Define.REGISTRATION_PAGE).forward(request, response);
            }
    }
}