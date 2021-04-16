package com.bigjava18.web.servlet;

import com.bigjava18.web.bean.User;
import com.bigjava18.web.biz.UserBiz;
import com.bigjava18.web.biz.impl.UserBizImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zgp
 * @Since 2021 -04 -16 09 :24
 * @Description 用户Servlet
 */
public class UserServlet extends HttpServlet {

    UserBiz userBiz=new UserBizImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User(username,password);

        if(userBiz.addUser(user)){
            resp.getWriter().write("用户添加成功！");
        }else {
            resp.getWriter().write("用户添加失败！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
