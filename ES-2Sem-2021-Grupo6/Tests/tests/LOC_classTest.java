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

import Metrics.CYCLO_Method;
import Metrics.LOC_class;

/**
 * @author setee
 *
 */
class LOC_classTest {
	private static LOC_class a;
	private static String nameClassTest;
	private static int locTest;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a = new LOC_class();
		nameClassTest = "ParsingException";
		locTest = 44;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		a.countLines("C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\ParsingException.java");
	}
	
	/**
	 *
	 * Test method for {@link Metrics.LOC_class#getLines()}.
	 */
	@Test
	void testGetLines() {
		Assertions.assertEquals(locTest, a.getLines());
	}

	
	/**
	 * Test method for {@link Metrics.LOC_class#nameClass()}.
	 */
	@Test
	void testNameClass() {
		Assertions.assertEquals(nameClassTest, a.getNameClass());
	}

	
}
