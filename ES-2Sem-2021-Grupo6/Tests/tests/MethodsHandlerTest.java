
/**
 * 
 */
package tests;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.javaparser.utils.Pair;

import Metrics.MethodsHandler;

/**
 * To test the "Logic_Expressions" class and its procedure to get the boolean of a logic expression
 *
 */
class MethodsHandlerTest {
	private static MethodsHandler a;
	private static ArrayList<Pair<String, Integer>> listA;
	
	
	/** Setup of the classes needed for the test
	 * 	Instantiate the a MethodHandler and create an empty ArrayList of tuples 
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a = new MethodsHandler();
		listA = new ArrayList<Pair<String, Integer>>();
	}
	

	
	/** Starts the procedure in a java file and creates an ArrayList with the values manually counted
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeEach
	void setUp() throws Exception {
		a.countMethods("testing\\Teste\\testFiles\\src\\com\\jasml\\compiler\\ParsingException.java");
		listA();
	}


	/**Adds Pairs to the list manually counted
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void listA() {
		listA.add(new Pair("ParsingException", 6));
		listA.add(new Pair("ParsingException", 5));
		listA.add(new Pair("ParsingException", 4));
		listA.add(new Pair("ParsingException", 3));
		listA.add(new Pair("ParsingException", 3));
		listA.add(new Pair("getMessage", 20));
	}

	
	/**	Tests if the procedure is giving the right number of methods for each class
	 * 
	 * Test method for {@link Metrics.MethodsHandler#countMethods(java.lang.String)}.
	 */
	@Test
	void testCountMethods() {
		Assertions.assertIterableEquals(listA, a.getPair());
	}

	
}
