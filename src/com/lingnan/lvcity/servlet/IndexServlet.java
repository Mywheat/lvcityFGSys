package com.lingnan.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.lvcity.model.ArticleVO;
import com.lingnan.lvcity.model.BanarVO;
import com.lingnan.lvcity.model.FoodVO;
import com.lingnan.lvcity.model.ScenicVO;
import com.lingnan.lvcity.service.IndexService;
import com.lingnan.lvcity.service.impl.IndexServiceImpl;

/**
 * 首页的Servlet实现类
 * @author Sunset
 *
 */
public class IndexServlet extends HttpServlet {
	/**
	 * 构造方法？？？
	 */
	public IndexServlet(){
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest requset, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(requset.getContextPath());
		doPost(requset, response);
	}
	
	/**
	 @see HttpServlet#doGetdoPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session
		HttpSession session = requset.getSession();
		//调用Service方法
		IndexService indexService = IndexServiceImpl.getInstance();
		
		List<BanarVO> banarList = indexService.findBanar();
		session.setAttribute("banarList", banarList);

		List<ArticleVO> articleList = indexService.findIndexArticle();
		session.setAttribute("articleList", articleList);
		
		List<ScenicVO> scenicList = indexService.findIndexScenic();
		session.setAttribute("scenicList", scenicList);
		
		List<FoodVO> foodList = indexService.findIndexFood();
		session.setAttribute("foodList", foodList);
		response.sendRedirect(requset.getContextPath()+"/User/index.jsp");
	}
}
