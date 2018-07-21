package com.lingnan.lvcity.dao;

import java.util.List;

import com.lingnan.lvcity.model.ArticleVO;
import com.lingnan.lvcity.model.BanarVO;
import com.lingnan.lvcity.model.FoodVO;
import com.lingnan.lvcity.model.ScenicVO;

/**
 * 首页dao接口类
 * @author Sunset
 *
 */
public interface IndexDao {
	/**
	 * 广告大图
	 * @return
	 */
	public List<BanarVO> findBanar();
	/**
	 * 首页文章
	 * @return
	 */
	public List<ArticleVO> findIndexArticle();
	/**
	 * 首页风景图片
	 * @return
	 */
	public List<ScenicVO> findIndexScenic();
	/**
	 * 首页美食图片
	 * @return
	 */
	public List<FoodVO> findIndexFood();
}
