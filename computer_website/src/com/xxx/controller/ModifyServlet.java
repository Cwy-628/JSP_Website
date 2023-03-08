package com.xxx.controller;

import com.xxx.mapper.UserDao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/modify")
public class ModifyServlet extends HttpServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String oupwd = request.getParameter("oupwd");
        String nupwd = request.getParameter("nupwd");

//        MessageModel messageModel = ModifyService.userModify(oupwd,nupwd);
        UserDao udao = new UserDao();
        int x = udao.updateUser(nupwd);
        if (x >= 1) {
            request.getRequestDispatcher("update.jsp");
        }
    }
}
