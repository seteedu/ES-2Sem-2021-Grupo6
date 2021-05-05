package tests;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Excell_Summary;

/**
 * To test the "Excel_Summary" class and its procedure to get the summary of the metrics written in excel
 *
 */
class Excell_SummaryTest {
	
	private static Excell_Summary e;

	
	/** Setup of the classes needed for the test
	 * 	Instantiate the a Excell_Summary and creates an empty ArrayList of integers
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		e = new Excell_Summary();
	}

	/** Starts the procedure in a java file and creates an ArrayList with the values manually counted
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeEach
	void setUp() throws Exception {
		e.getMetrics(new File("Code_Smells.xlsx"));
	}
	
	/** Tests if the procedure is giving the right number of packages in a folder
	 * 
	 * Test method for {@link Metrics.Excell_Summary#getNumPackages()}.
	 * @throws FileNotFoundException if any error occurs during the test
	 */
	@Test
	void testNumPack() {
		Assertions.assertEquals(1, e.getNumPackages());
	}
	
	/** Tests if the procedure is giving the right number of classes in a folder
	 * 
	 * Test method for {@link Metrics.Excell_Summary#getNumClasses()}.
	 * @throws FileNotFoundException if any error occurs during the test
	 */
	@Test
	void testNumClass() {
		Assertions.assertEquals(11, e.getNumClasses());
	}

	/** Tests if the procedure is giving the right number of methods in a folder
	 * 
	 * Test method for {@link Metrics.Excell_Summary#getNumMethods()}.
	 * @throws FileNotFoundException if any error occurs during the test
	 */
	@Test
	void testNumMethods() {
		Assertions.assertEquals(22, e.getNumMethods());
	}

	/** Tests if the procedure is giving the right number of lines in a folder
	 * 
	 * Test method for {@link Metrics.Excell_Summary#getNumLines()}.
	 * @throws FileNotFoundException if any error occurs during the test
	 */
	@Test
	void testNumLines() {
		Assertions.assertEquals(285, e.getNumLines());
	}
}
