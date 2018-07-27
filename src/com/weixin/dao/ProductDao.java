/**
 * 
 */
package com.weixin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.weixin.Util.DateUtil;
import com.weixin.Util.JDBCUtil;
import com.weixin.bean.ProductBean;

/**
 * �������������þߵĲ���
 * 
 * @author jpgong
 *
 */
public class ProductDao {

	/**
	 * ��ѯÿһ��idֵ�������þ�
	 * 
	 * @param parentId
	 * @return
	 */
	public ProductBean getById(int id) {
		ProductBean productBean = null;
		// �����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from fireapp_info where ���=" + id;
			rs = statement.executeQuery(sql);

			if (rs.next()) {
				// ��װ�����þ���Ϣ
				productBean = new ProductBean();
				productBean.setId(rs.getInt("���"));
				productBean.setProductName(rs.getString("����"));
				productBean.setProductType(rs.getString("�ͺ�"));
				productBean.setStatus(rs.getString("״̬"));
				productBean.setIntro(rs.getString("��ע"));
				productBean.setCreateDate(DateUtil.getDateFormat(rs.getTimestamp("�޸�ʱ��")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, statement, connection); // 5���ر�����
		}
		return productBean;
	}

	/**
	 * ��ѯһ�������þߵ�����
	 * 
	 * @param parentId
	 * @return
	 */
	public int getCountByName(String produceName) {
		// �����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		int count = 0;
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select count(*) count from fireapp_info where ����='" + produceName + "'";
			rs = statement.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, statement, connection); // 5���ر�����
		}
		return count;
	}

	/**
	 * �޸������þߵ���Ϣ
	 * 
	 * @param productBean
	 * @return
	 */
	public boolean update(ProductBean productBean) {
		// �����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = JDBCUtil.getConn();
			String sql = "update fireapp_info set ����=?,�ͺ�=?,״̬=?,��ע=?,�޸�ʱ��=? where ���=?";
			statement = connection.prepareStatement(sql);
			// �����ݿ��������Ʒ������Ϣ
			statement.setString(1, productBean.getProductName());
			statement.setString(2, productBean.getProductType());
			statement.setString(3, productBean.getStatus());
			statement.setString(4, productBean.getIntro());
			statement.setString(5, productBean.getCreateDate());
			statement.setInt(6, productBean.getId());
			// ִ��SQL
			flag = statement.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(statement, connection); // 5���ر�����
		}
		return flag;
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		// �����ݿ⽻��ʱ��Ҫ�õ������ݿ���
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = JDBCUtil.getConn();
			String sql = "delete from fireapp_info where ���=?";
			statement = connection.prepareStatement(sql);
			// �����ݿ��������Ʒ������Ϣ
			statement.setInt(1, id);
			// ִ��SQL
			flag = statement.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(statement, connection); // 5���ر�����
		}
		return flag;
	}
}