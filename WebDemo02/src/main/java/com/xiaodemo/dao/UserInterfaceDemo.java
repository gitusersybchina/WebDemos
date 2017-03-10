package com.xiaodemo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.xiaodemo.entity.Tab_UserEntity;

public interface UserInterfaceDemo {

	/**
	 * 增
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int insert(Connection conn, Tab_UserEntity user) throws SQLException;

	/**
	 * 删
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection conn, Tab_UserEntity user) throws SQLException;

	/**
	 * 改
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int update(Connection conn, Tab_UserEntity user) throws SQLException;

	/**
	 * 查
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Tab_UserEntity> select(Connection conn) throws SQLException;

	public List<Tab_UserEntity> select(Connection conn, Tab_UserEntity user) throws SQLException;

}
