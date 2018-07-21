package com.lingnan.lvcity.service;

import java.util.List;

import com.lingnan.lvcity.model.ArticleVO;
import com.lingnan.lvcity.model.BanarVO;
import com.lingnan.lvcity.model.FoodVO;
import com.lingnan.lvcity.model.ScenicVO;

/**
 * 首页Service接口类
 * @author Sunset
 *
 */
public interface IndexService {
	/**
	 * 查询banar信息
	 * @return 查询到的banar信息
	 */
	public List<BanarVO> findBanar();
	/**
	 * 查询article信息
	 * @return 查询到的article信息
	 */
	public List<ArticleVO> findIndexArticle();
	/**
	 * 查询scenic信息
	 * @return 查询到的scenic信息
	 */
	public List<ScenicVO> findIndexScenic();
	/**
	 * 查询food信息
	 * @return 查询到的food信息
	 */
	public List<FoodVO> findIndexFood();
}
