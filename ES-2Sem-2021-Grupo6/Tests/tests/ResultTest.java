/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Metrics.CYCLO_Method;

/**
 * @author setee
 *
 */
class ResultTest {
	CYCLO_Method b;
	static ArrayList<Integer> nCyclesB;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		CYCLO_Method b = new CYCLO_Method();
		nCyclesB = new ArrayList<Integer>();
	}

	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		b.countCyclo("C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\ParsingException.java");
		Collections.addAll(nCyclesB, 1, 1, 1, 1, 1, 6);
	}

	
	/**
	 * Test method for {@link Metrics.Result#Result(java.lang.String, java.lang.String, java.lang.String, int, int, int, int, int)}.
	 */
	@Test
	void testResult() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.Result#getPackage1()}.
	 */
	@Test
	void testGetPackage1() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.Result#getClass1()}.
	 */
	@Test
	void testGetClass1() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.Result#getMethod1()}.
	 */
	@Test
	void testGetMethod1() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.Result#getNom()}.
	 */
	@Test
	void testGetNom() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.Result#getLoc()}.
	 */
	@Test
	void testGetLoc() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.Result#getWmc()}.
	 */
	@Test
	void testGetWmc() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.Result#getLocm()}.
	 */
	@Test
	void testGetLocm() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Metrics.Result#getCyclom()}.
	 */
	@Test
	void testGetCyclom() {
		fail("Not yet implemented");
	}

}
