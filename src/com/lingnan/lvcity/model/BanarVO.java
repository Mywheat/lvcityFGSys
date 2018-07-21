package com.lingnan.lvcity.model;

/**
 * 广告大图信息类
 * @author Sunset
 *
 */
public class BanarVO {
	
    // 构造方法
	public BanarVO(){
		super();
	}
	// 带参数的构造方法
	public BanarVO(int _banarid,String _image,int _state){
		super();
		this.banarid=_banarid;
		this.image=_image;
		this.state =_state; 
	}	
	private int banarid;
	private String image;
	private int state;
	public int getBanarid() {
		return banarid;
	}
	public void setBanarid(int banarid) {
		this.banarid = banarid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
