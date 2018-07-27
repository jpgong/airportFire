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
 * 用来处理消防用具的操作
 * 
 * @author jpgong
 *
 */
public class ProductDao {

	/**
	 * 查询每一个id值的消防用具
	 * 
	 * @param parentId
	 * @return
	 */
	public ProductBean getById(int id) {
		ProductBean productBean = null;
		// 和数据库交互时需要用到的数据库类
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select * from fireapp_info where 序号=" + id;
			rs = statement.executeQuery(sql);

			if (rs.next()) {
				// 封装消防用具信息
				productBean = new ProductBean();
				productBean.setId(rs.getInt("序号"));
				productBean.setProductName(rs.getString("名称"));
				productBean.setProductType(rs.getString("型号"));
				productBean.setStatus(rs.getString("状态"));
				productBean.setIntro(rs.getString("备注"));
				productBean.setCreateDate(DateUtil.getDateFormat(rs.getTimestamp("修改时间")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, statement, connection); // 5、关闭连接
		}
		return productBean;
	}

	/**
	 * 查询一类消防用具的数量
	 * 
	 * @param parentId
	 * @return
	 */
	public int getCountByName(String produceName) {
		// 和数据库交互时需要用到的数据库类
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		int count = 0;
		try {
			connection = JDBCUtil.getConn();
			statement = connection.createStatement();
			String sql = "select count(*) count from fireapp_info where 名称='" + produceName + "'";
			rs = statement.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, statement, connection); // 5、关闭连接
		}
		return count;
	}

	/**
	 * 修改消防用具的信息
	 * 
	 * @param productBean
	 * @return
	 */
	public boolean update(ProductBean productBean) {
		// 和数据库交互时需要用到的数据库类
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = JDBCUtil.getConn();
			String sql = "update fireapp_info set 名称=?,型号=?,状态=?,备注=?,修改时间=? where 序号=?";
			statement = connection.prepareStatement(sql);
			// 往数据库中添加商品分类信息
			statement.setString(1, productBean.getProductName());
			statement.setString(2, productBean.getProductType());
			statement.setString(3, productBean.getStatus());
			statement.setString(4, productBean.getIntro());
			statement.setString(5, productBean.getCreateDate());
			statement.setInt(6, productBean.getId());
			// 执行SQL
			flag = statement.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(statement, connection); // 5、关闭连接
		}
		return flag;
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		// 和数据库交互时需要用到的数据库类
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = JDBCUtil.getConn();
			String sql = "delete from fireapp_info where 序号=?";
			statement = connection.prepareStatement(sql);
			// 往数据库中添加商品分类信息
			statement.setInt(1, id);
			// 执行SQL
			flag = statement.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(statement, connection); // 5、关闭连接
		}
		return flag;
	}
}