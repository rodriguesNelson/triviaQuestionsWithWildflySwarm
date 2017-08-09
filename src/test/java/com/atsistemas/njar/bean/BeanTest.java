package com.atsistemas.njar.bean;

import java.beans.IntrospectionException;

import com.atsistemas.njar.tester.JavaBeanTester;

/**
 * Unit test for any Bean
 * 
 * @author njandrade
 *
 */
public class BeanTest {
	
	/**
	 * Test Bean
	 */
	public void testBean(Class<?> clazz, String...  skipThese) {
		try {
			JavaBeanTester.test(clazz, skipThese);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
