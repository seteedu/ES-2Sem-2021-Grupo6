
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

import com.github.javaparser.utils.Pair;

import Metrics.CYCLO_Method;
import Metrics.MethodsHandler;

/**
 * @author setee
 *
 */
class MethodsHandlerTest {
	private static MethodsHandler a;
	private static ArrayList<Pair<String, Integer>> listA;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a = new MethodsHandler();
		listA = new ArrayList<Pair<String, Integer>>();
	}
	

	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		a.countMethods("C:\\Users\\setee\\OneDrive\\Universidade\\3 ano\\2ºsemestre\\Engenharia de Software\\test\\testFiles\\src\\com\\jasml\\compiler\\ParsingException.java");
		listA.add( new Pair("ParsingException", 6));
		listA.add(new Pair("ParsingException", 5));
		listA.add( new Pair("ParsingException", 4));
		listA.add(new Pair("ParsingException", 3));
		listA.add(new Pair("ParsingException", 3));
		listA.add(new Pair("getMessage", 20));
	}

	
	/**
	 * Test method for {@link Metrics.MethodsHandler#countMethods(java.lang.String)}.
	 */
	@Test
	void testCountMethods() {
		Assertions.assertIterableEquals(listA, a.getPair());
	}

	
}
