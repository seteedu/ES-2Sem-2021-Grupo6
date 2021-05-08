/**
 * 
 */
package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Metrics.LOC_class;

/**
 * To test the "LOC_Class" class and its procedure to get the number of lines in a class
 *
 */
class LOC_classTest {
	private static LOC_class a;
	private static String nameClassTest;
	private static String namePackageTest;
	private static int locTest;
	
	/** Setup of the classes needed for the test
	 * 	Instantiate the a LOC_Class, creates an integer with the number manually counted and a string with the name of the class
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a = new LOC_class();
	}

	/** Starts the procedure in a java file and creates an ArrayList with the values manually counted
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeEach
	void setUp() throws Exception {
		a.countLines("testing\\Teste\\testFiles\\src\\com\\jasml\\compiler\\SourceCodeParser.java");
		locTest = 1321;
		nameClassTest = "SourceCodeParser";
		namePackageTest = "com.jasml.compiler";
	}
	
	/**	Tests if the procedure is giving the right number of lines of the parsed file 
	 *
	 * Test method for {@link Metrics.LOC_class#getLines()}.
	 */
	@Test
	void testGetLines() {
		Assertions.assertEquals(locTest, a.getLines());
	}

	
	/**Tests if the procedure is giving the right name of the parsed file 
	 * 
	 * Test method for {@link Metrics.LOC_class#nameClass()}.
	 */
	@Test
	void testNameClass() {
		Assertions.assertEquals(nameClassTest, a.getNameClass());
	}
	
	/**Tests if the procedure is giving the right name of the package
	 * 
	 * Test method for {@link Metrics.LOC_class#namePackage()}.
	 */
	@Test
	void testNamePackage() {
		Assertions.assertEquals(namePackageTest, a.getNamePackage());
	}

	
}
