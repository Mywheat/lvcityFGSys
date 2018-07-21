package com.lingnan.lvcity.service.impl;

import java.util.List;

import org.junit.Test;

import com.lingnan.lvcity.model.BanarVO;
import com.lingnan.lvcity.model.FoodVO;
import com.lingnan.lvcity.service.IndexService;

public class IndexServiceImplTest {

	@Test
	public void testFindBanar() {
		IndexService indexService = IndexServiceImpl.getInstance();
		List<BanarVO> banarList = indexService.findBanar();
		for(BanarVO a:banarList){
			System.out.println("hhhhh"+a.getState()+"   "+a.getImage());
		}
		List<FoodVO> scenicList = indexService.findIndexFood();
		for(FoodVO a:scenicList){
			System.out.println("fffff"+a.getFid());
		}

	}

}
