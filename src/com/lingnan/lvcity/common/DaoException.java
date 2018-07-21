package com.lingnan.lvcity.common;

/**
 * dao异常类
 * @author Sunset
 *
 */
public class DaoException extends RuntimeException{
	/**
	 * 默认的构造方法
	 */
	public DaoException(){		
	}
	
	/**
	 * 构造方法
	 * @param arg0 异常的详细
	 */
	public DaoException(String arg0){
		//调用父类的super构造方法，重写详细异常详细
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg0 产生异常的原因
	 */
	public DaoException(Throwable arg0){
		//调用父类的super（Throwable）构造方法，重写详细异常产生的原因
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg0  异常的详细
	 * @param arg1 产生异常的原因
	 */
	public DaoException(String arg0,Throwable arg1){
		//调用父类的super（Throwable）构造方法，重写详细异常详细和产生的原因
		super(arg0,arg1);
	}
}
