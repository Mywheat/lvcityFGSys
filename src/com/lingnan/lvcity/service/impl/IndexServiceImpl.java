package com.lingnan.lvcity.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.lvcity.common.DBUtils;
import com.lingnan.lvcity.common.DaoException;
import com.lingnan.lvcity.common.ServiceException;
import com.lingnan.lvcity.dao.IndexDao;
import com.lingnan.lvcity.dao.impl.IndexDaoImpl;
import com.lingnan.lvcity.model.ArticleVO;
import com.lingnan.lvcity.model.BanarVO;
import com.lingnan.lvcity.model.FoodVO;
import com.lingnan.lvcity.model.ScenicVO;
import com.lingnan.lvcity.service.IndexService;

/**
 * 首页的service具体实现类
 * @author Sunset
 *
 */
public class IndexServiceImpl implements IndexService{
	
	/**
	 * 类实例
	 */
	private static final IndexService instance = new IndexServiceImpl();
	
	/**
	 * 取得实例
	 * @return 实例对象
	 */
	public static IndexService getInstance(){
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private IndexServiceImpl(){		
	}
	
	/**
	 * 查询banar信息
	 * @return 查询到的banar信息
	 */
	@Override
	public List<BanarVO> findBanar() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		List<BanarVO> list = new ArrayList<BanarVO>();
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
		    //
			IndexDao indexMgrDao = new IndexDaoImpl(conn);
		    //调用dao中的findBanar方法，进行查询Banar的信息，结果赋值给list
			list = indexMgrDao.findBanar();
		}
		catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}
		catch(Exception e){
			//将异常封装成自定义异常抛出
			throw new ServiceException("查询banar信息错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}

	/**
	 * 查询article信息
	 * @return 查询到的article信息
	 */
	@Override
	public List<ArticleVO> findIndexArticle() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
		    //
			IndexDao indexMgrDao = new IndexDaoImpl(conn);
		    //调用dao中的findIndexArticle方法，进行查询Article的信息，结果赋值给list
			list = indexMgrDao.findIndexArticle();
		}
		catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}
		catch(Exception e){
			//将异常封装成自定义异常抛出
			throw new ServiceException("查询article信息错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}

	/**
	 * 查询scenic信息
	 * @return 查询到的scenic信息
	 */
	@Override
	public List<ScenicVO> findIndexScenic() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		List<ScenicVO> list = new ArrayList<ScenicVO>();
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
		    //
			IndexDao indexMgrDao = new IndexDaoImpl(conn);
		    //调用dao中的findIndexScenic方法，进行查询scenic的信息，结果赋值给list
			list = indexMgrDao.findIndexScenic();
		}
		catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}
		catch(Exception e){
			//将异常封装成自定义异常抛出
			throw new ServiceException("查询scenic信息错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}

	/**
	 * 查询food信息
	 * @return 查询到的food信息
	 */
	@Override
	public List<FoodVO> findIndexFood() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		List<FoodVO> list = new ArrayList<FoodVO>();
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
		    //
			IndexDao indexMgrDao = new IndexDaoImpl(conn);
		    //调用dao中的findIndexFood方法，进行查询food的信息，结果赋值给list
			list = indexMgrDao.findIndexFood();
		}
		catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}
		catch(Exception e){
			//将异常封装成自定义异常抛出
			throw new ServiceException("查询food信息错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}

}
