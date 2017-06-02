package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.UserBean;

public class UserDAO {

	public UserBean login(String id,String password){
		ConnectionManager cm = ConnectionManager.getInstance();

		UserBean user = null;
		String sql = "select * from m_user where user_id = '"+id+"' and password = '"+password+"';";

		try(Connection con = cm.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){

			ResultSet res = ps.executeQuery();

			if(res.next()){
				user = new UserBean();
				user.setUserID(res.getString(1));
				user.setPassword(res.getString(2));
				user.setUpdateDate(res.getTimestamp(3));
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		cm.closeConnection();
		return user;
	}

	public int registration(String id, String password){
		ConnectionManager cm = ConnectionManager.getInstance();

		int count = 0;
		try(Connection con = cm.getConnection();
				Statement stmt = con.createStatement()){

			String sql = "INSERT INTO m_user (user_id,password) VALUES('"+id+"','"+password+"');";
			count = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		cm.closeConnection();
		return count;
	}
}
