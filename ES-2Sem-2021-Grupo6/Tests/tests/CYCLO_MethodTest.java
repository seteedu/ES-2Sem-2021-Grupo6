package tests;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Metrics.CYCLO_Method;

/**
 * To test the "CYCLO_Method" class and its procedure to get the number of cycles/complexity of the method
 *
 */
class CYCLO_MethodTest {

	private static CYCLO_Method b;
	private static ArrayList<Integer> nCyclesB;
	
	/** Setup of the classes needed for the test
	 * 	Instantiate the a CYCLO_Method and creates an empty ArrayList of integers
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		b = new CYCLO_Method();
		nCyclesB = new ArrayList<Integer>();
	}


	/** Starts the procedure in a java file and fills the ArrayList with the values manually counted
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeEach
	void setUp() throws Exception {
		b.countCyclo("testing\\Teste\\testFiles\\src\\com\\jasml\\compiler\\SourceCodeParser.java");
		Collections.addAll(nCyclesB, 1, 1, 2, 5, 4, 8, 3, 17, 3, 4, 10, 1, 128, 26, 11, 12, 15, 3, 4, 17, 3, 7, 4,2, 3, 2, 2 ,1, 1, 1, 1, 1);
		}	

	
	/** Tests if the procedure is giving the right number of cycles/complexity of each method in a file 
	 * 
	 * Test method for {@link Metrics.CYCLO_Method#getNCycles()}.
	 * @throws FileNotFoundException 
	 */
	@Test
	void testGetNCycles() throws FileNotFoundException {
		Assertions.assertIterableEquals(nCyclesB, b.getNCycles());
	}


}
