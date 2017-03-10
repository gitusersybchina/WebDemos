package com.xiaodemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xiaodemo.entity.Tab_UserEntity;

public class UserDao implements UserInterfaceDemo {

	public List<Tab_UserEntity> select(Connection conn) throws SQLException {
		return null;
	}

	public int insert(Connection conn, Tab_UserEntity user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Connection conn, Tab_UserEntity user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Connection conn, Tab_UserEntity user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Tab_UserEntity> select(Connection conn, Tab_UserEntity user) throws SQLException {

		PreparedStatement state = conn.prepareStatement("select * from tab_user where name=? and pass=?");

		state.setString(1, user.getName());
		state.setString(2, user.getPass());

		List<Tab_UserEntity> list = new ArrayList<Tab_UserEntity>();

		ResultSet rs = state.executeQuery();
		while (rs.next()) {

			Tab_UserEntity uentity = new Tab_UserEntity();
			uentity.setId(rs.getLong("id"));
			uentity.setName(rs.getString("name"));
			uentity.setPass(rs.getString("pass"));
			uentity.setEmail(rs.getString("pass"));

			list.add(uentity);
		}

		return list;
	}

}
