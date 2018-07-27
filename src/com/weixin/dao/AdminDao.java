/**
 * 
 */
package com.weixin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weixin.Util.JDBCUtil;
import com.weixin.Util.MD5;
import com.weixin.bean.AdminBean;


/**
 * 用来处理用户和数据库之间的交互
 * @author jpgong
 *
 */
public class AdminDao {
	
	/**
	 * 验证管理员登录
	 * @param username  管理员名
	 * @param password  管理员密码，已经经过加密了
	 * @return 如果是null,则登陆失败
	 */
	public AdminBean login(String username,String password){
		AdminBean adminBean = null;
		//和数据库交互时需要用到的数据库类
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from admin where username='" + username + "'";
			resultSet = statement.executeQuery(sql);
			
			//如果在数据库中查到该管理员用户，则返回此用户的信息
			if (resultSet.next()) {
				//读取数据库中该管理员的信息
				String passwordJDBC = resultSet.getString("password");
				String salt = resultSet.getString("salt");
				
				//将登陆时传过来的密码和盐值salt进行MD5加密
				String passwordCount = MD5.GetMD5Code(password + salt);
				
				//如果数据库中该用户的密码和网页传过来的密码一致，则登陆成功
				if (passwordCount.equals(passwordJDBC)) {
					adminBean = new AdminBean();
					adminBean.setId(resultSet.getInt("id"));
					adminBean.setUserName(username);
					adminBean.setPassWord(passwordCount);
					adminBean.setSalt(salt);
					adminBean.setCreateDate(resultSet.getString("create_date"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, statement, connection);     //5、关闭连接
		}
		return adminBean;
	}

	/**
	 * 添加管理员信息
	 * @param adminBean 
	 * @return 如果添加成功，返回true;添加失败，返回false
	 */
	public boolean add(AdminBean adminBean) {
		//和数据库交互时需要用到的数据库类
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = JDBCUtil.getConn();
			String sql = "insert into admin(username,password,salt,create_date) values(?,?,?,?)" ;
			statement = connection.prepareStatement(sql);
			//往数据库中添加管理员信息
			statement.setString(1, adminBean.getUserName());
			statement.setString(2, adminBean.getPassWord());
			statement.setString(3, adminBean.getSalt());
			statement.setString(4, adminBean.getCreateDate());
			//执行SQL
			flag = statement.executeUpdate()>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(statement, connection);     //5、关闭连接
		}
		return flag;
	}

	/**
	 * 用来判断管理员信息在数据库中是否已存在
	 * @param userName
	 * @return 若存在则返回true;否则返回false
	 */
	public boolean checkUserName(String userName) {
		//和数据库交互时需要用到的数据库类
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean flag = false;
		
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from admin where username='" + userName + "'";
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) { 
				//如果在数据库中查到该管理员用户，则说明用户重复
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, statement, connection);     //5、关闭连接
		}
		return flag;
	}

	/**
	 * 查询数据库中所有的管理员信息
	 * @return
	 */
	public List<AdminBean> list() {
		AdminBean adminBean = null;
		//和数据库交互时需要用到的数据库类
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<AdminBean> list = new ArrayList<AdminBean>();
		
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from admin";
			rs = statement.executeQuery(sql);
			
			//如果在数据库中查到该管理员用户，则返回此用户的信息
			while(rs.next()) {
				//封装管理员用户信息
				adminBean = new AdminBean();
				adminBean.setId(rs.getInt("id"));
				adminBean.setUserName(rs.getString("username"));
				adminBean.setPassWord(rs.getString("password"));
				adminBean.setSalt(rs.getString("salt"));
				adminBean.setCreateDate(rs.getString("create_date"));
				list.add(adminBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, statement, connection);     //5、关闭连接
		}
		return list;
	}

	/**
	 * 查询数据库中一共有多少条数据
	 * @return
	 */
	public int getCount() {
		//和数据库交互时需要用到的数据库类
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
	    int count = 0;
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select count(*) count from admin";
			rs = statement.executeQuery(sql);
			
			//如果在数据库中查到该管理员用户，则返回此用户的信息
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, statement, connection);     //5、关闭连接
		}
		return count;
	}

	/**
	 * 分页查询数据库
	 * @param pageSize 
	 * @param start 
	 * @return
	 */
	public List<AdminBean> listByPage(int start, int pageSize) {
		AdminBean adminBean = null;
		//和数据库交互时需要用到的数据库类
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<AdminBean> list = new ArrayList<AdminBean>();
		
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from admin limit " + start + "," + pageSize;
			rs = statement.executeQuery(sql);
			
			//如果在数据库中查到该管理员用户，则返回此用户的信息
			while(rs.next()) {
				//封装管理员用户信息
				adminBean = new AdminBean();
				adminBean.setId(rs.getInt("id"));
				adminBean.setUserName(rs.getString("username"));
				adminBean.setPassWord(rs.getString("password"));
				adminBean.setSalt(rs.getString("salt"));
				adminBean.setCreateDate(rs.getString("create_date"));
				list.add(adminBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, statement, connection);     //5、关闭连接
		}
		return list;
	}
}