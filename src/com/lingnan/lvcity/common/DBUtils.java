package com.lingnan.lvcity.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库工具类
 */
public class DBUtils {

	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/lvcity";
			String user = "root";
			String password = "666666";
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Can not get connection", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Can not get connection", e);
		}
		
		/*	         1.加载jdbc驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.定义连接url
		String url = "jdbc:oracle:thin:@localhost:1521:neuedu";
		//3.获取数据库连接    
		Connection conn = DriverManager.getConnection(url,"scott","tiger");*/
		
		/*try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context
					.lookup("java:comp/env/jdbc/lvcity");
			conn = ds.getConnection();
			System.out.println("connect sucess!");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Can not get connection", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Can not get connection", e);
		}
*/
		return conn;
	}

	/**
	 * 开启事务
	 * 
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new ServiceException("Can not begin transaction", e);
		}
	}

	/**
	 * 提交事务
	 * 
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			throw new ServiceException("Can not commit transaction", e);
		}
	}

	/**
	 * 回滚事务
	 * 
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			throw new ServiceException("Can not rollback transaction", e);
		}
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new ServiceException("Can not close connection", e);
		}
	}

	/**
	 * 关闭statement
	 * 
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs, Statement stmt) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new ServiceException("Can not close statement", e);
		}
	}
	
	/**
	 *关闭结果集对象ResultSet,预编译的声明对象PreparedStatement
	 * @param rs 结果集对象
	 * @param pstam 预编译的声明对象
	 */
	public static void closeStatement(ResultSet rs,PreparedStatement pstam){
		//如果查询结果集对象不为空，关闭该对象
		try {
			if(rs != null){		
				rs.close();
			} 
			//如果预编译的声明对象不为空，关闭该对象
			if(pstam != null){
				pstam.close();
			}
		}catch (SQLException e) {
			//将异常封装成自定义异常
			throw new DaoException("关闭查询结果集对象或预编译的声明对象失败",e);
		}
	}
}
