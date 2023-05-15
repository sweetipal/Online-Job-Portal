package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAo {
	private Connection conn;

	public UserDAo(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(User u) {
		boolean f = false;
		try {
			String sql = "insert into user(name, email, password, qualification, role) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(2, u.getQualification());
			ps.setString(5, "User");

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String em, String psw) {
		User u = null;
		try {
			String sql = "select * from where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setId(rs.getInt(2));
				u.setId(rs.getInt(3));
				u.setId(rs.getInt(4));
				u.setId(rs.getInt(5));
				u.setId(rs.getInt(6));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

}
