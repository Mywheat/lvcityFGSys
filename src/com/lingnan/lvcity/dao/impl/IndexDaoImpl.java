package com.lingnan.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.lvcity.common.DBUtils;
import com.lingnan.lvcity.common.DaoException;
import com.lingnan.lvcity.dao.IndexDao;
import com.lingnan.lvcity.model.ArticleVO;
import com.lingnan.lvcity.model.BanarVO;
import com.lingnan.lvcity.model.FoodVO;
import com.lingnan.lvcity.model.ScenicVO;

/**
 * 首页dao的具体实现类
 * @author Sunset
 *
 */
public class IndexDaoImpl implements IndexDao{

	/**
	 * 数据库连接
	 */
	private Connection conn;
	
	/**
	 * 构造方法，传递数据库连接对象
	 * @param conn 数据库连接对象
	 */
	public IndexDaoImpl(Connection conn){
		//给属性赋初始化值
		this.conn = conn;
	}
	
	/**
	 * 查询banar信息
	 * @return 查询到的banar信息
	 */
	@Override
	public List<BanarVO> findBanar() {
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明Banar变量，用于保存结果集中提取出来的数据
		List<BanarVO> list = new ArrayList<BanarVO>();
		try {
			//调用连接对象的PreparedStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from banar where state=1");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			while(rs.next()){
				//创建一个新用户对象，赋值给用户对象变量
				BanarVO banarvo = new BanarVO();
				/*
				 * 调用结果集对象的getXxx方法，取出各个字段的值
				 * 然后再调用用户对象的setXxx方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				banarvo.setBanarid(rs.getInt("banarid"));
				banarvo.setImage(rs.getString("image"));
				banarvo.setState(rs.getInt("state"));
				//把查询到的信息放进列表list
				list.add(banarvo);
			}
		} 
		//结果出现异常，输出异常信息
		catch (SQLException e) {
			System.out.println("在查询banar信息时出错了，错误信息是：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("查询banar信息",e);
		}finally{
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
		/*
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
		 * 如果查询结果为空，该对象为空值null
		 */
		return list;		
	}

	/**
	 * 查询article信息
	 * @return 查询到的article信息
	 */
	@Override
	public List<ArticleVO> findIndexArticle() {
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明Banar变量，用于保存结果集中提取出来的数据
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		try {
			//调用连接对象的PreparedStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select aid,content,image,articlename from article where atid = 1 order by aid desc limit 3");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			while(rs.next()){
				//创建一个新用户对象，赋值给用户对象变量
				ArticleVO articlevo = new ArticleVO();
				/*
				 * 调用结果集对象的getXxx方法，取出各个字段的值
				 * 然后再调用用户对象的setXxx方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				articlevo.setAid(rs.getInt("aid"));
				articlevo.setContent(rs.getString("content"));
				articlevo.setImage(rs.getString("image"));
				articlevo.setArticlename(rs.getString("articlename"));
				//把查询到的信息放进列表list
				list.add(articlevo);
			}
		} 
		//结果出现异常，输出异常信息
		catch (SQLException e) {
			System.out.println("在查询article信息时出错了，错误信息是：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("查询article信息",e);
		}finally{
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
		/*
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
		 * 如果查询结果为空，该对象为空值null
		 */
		return list;		
	}

	/**
	 * 查询scenic信息
	 * @return 查询到的scenic信息
	 */
	@Override
	public List<ScenicVO> findIndexScenic() {
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明Banar变量，用于保存结果集中提取出来的数据
		List<ScenicVO> list = new ArrayList<ScenicVO>();
		try {
			//调用连接对象的PreparedStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from scenic where sid>round((rand()*(select max(sid) from scenic where lx='景点'))-3.5,0) limit 7");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			while(rs.next()){
				//创建一个新用户对象，赋值给用户对象变量
				ScenicVO scenicvo = new ScenicVO();
				/*
				 * 调用结果集对象的getXxx方法，取出各个字段的值
				 * 然后再调用用户对象的setXxx方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				scenicvo.setAid(rs.getInt("aid"));
				scenicvo.setSname(rs.getString("sname"));
				scenicvo.setImage(rs.getString("image"));
				scenicvo.setLx(rs.getString("lx"));
				scenicvo.setSid(rs.getInt("sid"));
				scenicvo.setStid(rs.getInt("stid"));
				//把查询到的信息放进列表list
				list.add(scenicvo);
			}
		} 
		//结果出现异常，输出异常信息
		catch (SQLException e) {
			System.out.println("在查询scenic信息时出错了，错误信息是：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("查询scenic信息",e);
		}finally{
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
		/*
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
		 * 如果查询结果为空，该对象为空值null
		 */
		return list;		
	}

	/**
	 * 查询food信息
	 * @return 查询到的food信息
	 */
	@Override
	public List<FoodVO> findIndexFood() {
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明Banar变量，用于保存结果集中提取出来的数据
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			//调用连接对象的PreparedStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select fid,fname,aid,image from food order by fid desc limit 6");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			while(rs.next()){
				//创建一个新用户对象，赋值给用户对象变量
				FoodVO foodvo = new FoodVO();
				/*
				 * 调用结果集对象的getXxx方法，取出各个字段的值
				 * 然后再调用用户对象的setXxx方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				foodvo.setAid(rs.getInt("aid"));
				foodvo.setFid(rs.getInt("fid"));
				foodvo.setFname(rs.getString("fname"));
				foodvo.setImage(rs.getString("image"));
				//把查询到的信息放进列表list
				list.add(foodvo);
			}
	     }
		//结果出现异常，输出异常信息
		catch (SQLException e) {
			System.out.println("在查询food信息时出错了，错误信息是：" + e.getMessage());
			// 将异常封装成自定义异常
			throw new DaoException("查询food信息",e);
		}finally{
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
		/*
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
		 * 如果查询结果为空，该对象为空值null
		 */
		return list;		
	}

}
