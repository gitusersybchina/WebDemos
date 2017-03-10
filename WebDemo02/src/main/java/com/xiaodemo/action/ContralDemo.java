package com.xiaodemo.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaodemo.factory.ConnectionFactory;

public class ContralDemo extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8568652884301973724L;
	// 可以以当前线程为key值存储数据
	public static ThreadLocal<Connection> LOCAL = new ThreadLocal<Connection>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String url = req.getRequestURI();

		url = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));

		String s[] = url.split("!");

		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();

			LOCAL.set(conn);

			conn.setAutoCommit(false);
			// 通过反射得到类的的信息
			Class clazz = Class.forName("com.xiaodemo.action." + s[0]);

			Object obj = clazz.newInstance();
			// 根据参数类型和方法名获取当前类的某个方法
			Method me = clazz.getDeclaredMethod(s[1], HttpServletRequest.class, HttpServletResponse.class);

			me.invoke(obj, req, resp);

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
