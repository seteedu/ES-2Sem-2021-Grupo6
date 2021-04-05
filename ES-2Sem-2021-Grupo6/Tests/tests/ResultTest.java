/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Metrics.Result;


/**
 * @author setee
 *
 */

class ResultTest {
	private static Result a;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a = new Result ("package", "class", "metodo", 1, 2, 3, 4, 5);
	}
		
	/**
	 * Test method for {@link Metrics.Result#getPackage1()}.
	 */
	@Test
	void testGetPackage1() {
		Assertions.assertEquals("package", a.getPackage1());
	}

	
	/**
	 * Test method for {@link Metrics.Result#getClass1()}.
	 */
	@Test
	void testGetClass1() {
		Assertions.assertEquals("class", a.getClass1());
	}
	

	
	/**
	 * Test method for {@link Metrics.Result#getMethod1()}.
	 */
	@Test
	void testGetMethod1() {
		Assertions.assertEquals("metodo", a.getMethod1());
	}

	
	/**
	 * Test method for {@link Metrics.Result#getNom()}.
	 */
	@Test
	void testGetNom() {
		Assertions.assertEquals(1, a.getNom());
	}

	
	/**
	 * Test method for {@link Metrics.Result#getLoc()}.
	 */
	@Test
	void testGetLoc() {
		Assertions.assertEquals(2, a.getLoc());
	}

	
	/**
	 * Test method for {@link Metrics.Result#getWmc()}.
	 */
	@Test
	void testGetWmc() {
		Assertions.assertEquals(3, a.getWmc());
	}

	
	/**
	 * Test method for {@link Metrics.Result#getLocm()}.
	 */
	@Test
	void testGetLocm() {
		Assertions.assertEquals(4, a.getLocm());
	}

	/**
	 * Test method for {@link Metrics.Result#getCyclom()}.
	 */
	@Test
	void testGetCyclom() {
		Assertions.assertEquals(5, a.getCyclom());
	}

}
