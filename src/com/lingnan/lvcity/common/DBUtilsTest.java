package com.lingnan.lvcity.common;

import java.sql.Connection;

import org.junit.Test;


public class DBUtilsTest {

	   Connection connection = DBUtils.getConnection();
		@Test	
		public void testGetConnection() {		
			System.out.println(connection);
		}

}
