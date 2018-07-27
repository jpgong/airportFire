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
 * ���������û������ݿ�֮��Ľ���
 * @author jpgong
 *
 */
public class AdminDao {
	
	/**
	 * ��֤����Ա��¼
	 * @param username  ����Ա��
	 * @param password  ����Ա���룬�Ѿ�����������
	 * @return �����null,���½ʧ��
	 */
	public AdminBean login(String username,String password){
		AdminBean adminBean = null;
		//�����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from admin where username='" + username + "'";
			resultSet = statement.executeQuery(sql);
			
			//��������ݿ��в鵽�ù���Ա�û����򷵻ش��û�����Ϣ
			if (resultSet.next()) {
				//��ȡ���ݿ��иù���Ա����Ϣ
				String passwordJDBC = resultSet.getString("password");
				String salt = resultSet.getString("salt");
				
				//����½ʱ���������������ֵsalt����MD5����
				String passwordCount = MD5.GetMD5Code(password + salt);
				
				//������ݿ��и��û����������ҳ������������һ�£����½�ɹ�
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
			JDBCUtil.close(resultSet, statement, connection);     //5���ر�����
		}
		return adminBean;
	}

	/**
	 * ��ӹ���Ա��Ϣ
	 * @param adminBean 
	 * @return �����ӳɹ�������true;���ʧ�ܣ�����false
	 */
	public boolean add(AdminBean adminBean) {
		//�����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = JDBCUtil.getConn();
			String sql = "insert into admin(username,password,salt,create_date) values(?,?,?,?)" ;
			statement = connection.prepareStatement(sql);
			//�����ݿ�����ӹ���Ա��Ϣ
			statement.setString(1, adminBean.getUserName());
			statement.setString(2, adminBean.getPassWord());
			statement.setString(3, adminBean.getSalt());
			statement.setString(4, adminBean.getCreateDate());
			//ִ��SQL
			flag = statement.executeUpdate()>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(statement, connection);     //5���ر�����
		}
		return flag;
	}

	/**
	 * �����жϹ���Ա��Ϣ�����ݿ����Ƿ��Ѵ���
	 * @param userName
	 * @return �������򷵻�true;���򷵻�false
	 */
	public boolean checkUserName(String userName) {
		//�����ݿ⽻��ʱ��Ҫ�õ������ݿ���
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
				//��������ݿ��в鵽�ù���Ա�û�����˵���û��ظ�
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, statement, connection);     //5���ر�����
		}
		return flag;
	}

	/**
	 * ��ѯ���ݿ������еĹ���Ա��Ϣ
	 * @return
	 */
	public List<AdminBean> list() {
		AdminBean adminBean = null;
		//�����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<AdminBean> list = new ArrayList<AdminBean>();
		
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from admin";
			rs = statement.executeQuery(sql);
			
			//��������ݿ��в鵽�ù���Ա�û����򷵻ش��û�����Ϣ
			while(rs.next()) {
				//��װ����Ա�û���Ϣ
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
			JDBCUtil.close(rs, statement, connection);     //5���ر�����
		}
		return list;
	}

	/**
	 * ��ѯ���ݿ���һ���ж���������
	 * @return
	 */
	public int getCount() {
		//�����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
	    int count = 0;
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select count(*) count from admin";
			rs = statement.executeQuery(sql);
			
			//��������ݿ��в鵽�ù���Ա�û����򷵻ش��û�����Ϣ
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, statement, connection);     //5���ر�����
		}
		return count;
	}

	/**
	 * ��ҳ��ѯ���ݿ�
	 * @param pageSize 
	 * @param start 
	 * @return
	 */
	public List<AdminBean> listByPage(int start, int pageSize) {
		AdminBean adminBean = null;
		//�����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<AdminBean> list = new ArrayList<AdminBean>();
		
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from admin limit " + start + "," + pageSize;
			rs = statement.executeQuery(sql);
			
			//��������ݿ��в鵽�ù���Ա�û����򷵻ش��û�����Ϣ
			while(rs.next()) {
				//��װ����Ա�û���Ϣ
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
			JDBCUtil.close(rs, statement, connection);     //5���ر�����
		}
		return list;
	}
}