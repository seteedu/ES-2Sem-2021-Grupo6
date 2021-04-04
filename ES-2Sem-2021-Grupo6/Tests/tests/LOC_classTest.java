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
class LOC_classTest {
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
	 * Test method for {@link Metrics.LOC_class#countLines(java.lang.String)}.
	 */
	@Test
	void testCountLines() {
		fail("Not yet implemented");
	}

	
	/**
	 *
	 * Test method for {@link Metrics.LOC_class#getLines()}.
	 */
	@Test
	void testGetLines() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.LOC_class#nameClass()}.
	 */
	@Test
	void testNameClass() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link Metrics.LOC_class#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		fail("Not yet implemented");
	}

	
}
