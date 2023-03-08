package com.xxx.controller;

import com.xxx.entity.valueObject.MessageModel;
import com.xxx.mapper.UserDao;
import com.xxx.service.ReService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class ReServlet extends HttpServlet {

    //ʵ����ReService
    private ReService reService=new ReService();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ�������������
        String Customer_id = request.getParameter("uname");
        String Customer_name=request.getParameter("uname");
        String Customer_pwd=request.getParameter("upwd");
        String Customer_type=request.getParameter("Customer_type");
        String Customer_tele=request.getParameter("Customer_tele");
        String Customer_address=request.getParameter("Customer_address");
        MessageModel messageModel = reService.userRegister(Customer_name,Customer_pwd);

        if(messageModel.getCode()==1) {
            //����User���󣬸�ֵ
//            User u = new User();
//            u.setCustomer_name(Customer_name);
//            u.setCustomer_pwd(Customer_pwd);
            UserDao udao = new UserDao();

//        //����udao�ķ���ʵ�ֲ��빦��
            int x = udao.insertUser(Customer_id,Customer_name,Customer_pwd,Customer_type,Customer_tele,Customer_address);
            if (x >= 1) {
                response.sendRedirect("reSuccess.jsp");
            }
        }else
        {
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }
}
