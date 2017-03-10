package com.xiaodemo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.xiaodemo.dao.UserDao;
import com.xiaodemo.entity.Tab_UserEntity;

public class ServiceDemo {

	private static final UserDao userdao = new UserDao();

	/**
	 * 查询所有用户的所有信息
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Tab_UserEntity> findAll(Connection conn) throws SQLException {

		return userdao.select(conn);
	}

	/**
	 * 通过id字段来查询用户的相应信息
	 * 
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Tab_UserEntity> findById(Connection conn, Tab_UserEntity user) throws SQLException {

		return userdao.select(conn, user);
	}

	/**
	 * 删除用户信息
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int removeUser(Connection conn, Tab_UserEntity user) throws SQLException {

		return userdao.delete(conn, user);
	}

	/**
	 * 注册新用户
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int addUser(Connection conn, Tab_UserEntity user) throws SQLException {

		return userdao.insert(conn, user);
	}

	/**
	 * 更改用户信息
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int modifyUser(Connection conn, Tab_UserEntity user) throws SQLException {

		return userdao.update(conn, user);
	}

	public List<Tab_UserEntity> userLogin(Connection conn, Tab_UserEntity user) throws SQLException {

		return userdao.select(conn, user);
	}
}
