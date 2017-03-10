package com.xiaodemo.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiaodemo.entity.Tab_UserEntity;
import com.xiaodemo.factory.ConnectionFactory;
import com.xiaodemo.service.ServiceDemo;

@SuppressWarnings("serial")
public class LoginAction extends HttpServlet {

	private static Connection conn = ConnectionFactory.getInstance().getConnection();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		login(req, resp);
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) {

		String username = req.getParameter("user");
		String password = req.getParameter("pass");

		// 创建Tab_UserEntity 对象为了给预编译的sql语句传递相应参数
		Tab_UserEntity user = new Tab_UserEntity();
		user.setName(username);
		user.setPass(password);

		try {
			List<Tab_UserEntity> list = new ServiceDemo().userLogin(conn, user);
			// 如果list集合为空表示没有结果返回，即就是用户名或密码错误
			if (list.isEmpty()) {
				
				System.out.println("登录失败...用户名密码错误...");
				req.setAttribute("error", "用户名或密码错误！");
				// 如果登录失败则使用转发进行页面跳转到登录页面
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} else {

				System.out.println("登录成功.....");

				HttpSession session = req.getSession();

				session.setAttribute("user", "user_name");

				// 设置Session失效时间

				// 如果登录成功则使用重定向进行页面跳转到 home.jsp
				resp.sendRedirect("home.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
