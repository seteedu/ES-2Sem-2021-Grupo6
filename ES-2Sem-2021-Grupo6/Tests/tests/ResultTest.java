/**
 * 
 */
package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Metrics.Result;


/**
 * To test the "Result" class and its procedure to create the Result that groups all the metrics of each method 
 *
 */
class ResultTest {
	private static Result a;
	
	
	/** Setup of the classes needed for the test
	 * 	Instantiate a Main to get the result from a java file and create a Result with values manually counted 
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a = new Result ("package", "class", "metodo", 1, 2, 3, 4, 5);
	}
		
	/**Tests if the procedure is giving the right name of the package
	 * 
	 * Test method for {@link Metrics.Result#getPackage1()}.
	 */
	@Test
	void testGetPackage1() {
		Assertions.assertEquals("package", a.getPackage1());
	}

	
	/**Tests if the procedure is giving the right name of the class
	 * 
	 * Test method for {@link Metrics.Result#getClass1()}.
	 */
	@Test
	void testGetClass1() {
		Assertions.assertEquals("class", a.getClass1());
	}
	

	
	/**Tests if the procedure is giving the right name of the method
	 * 
	 * Test method for {@link Metrics.Result#getMethod1()}.
	 */
	@Test
	void testGetMethod1() {
		Assertions.assertEquals("metodo", a.getMethod1());
	}

	
	/**Tests if the procedure is giving the right number of methods in the class that it's in
	 * 
	 * Test method for {@link Metrics.Result#getNom()}.
	 */
	@Test
	void testGetNom() {
		Assertions.assertEquals(1, a.getNom());
	}

	
	/**Tests if the procedure is giving the right number of lines of the class that it's in
	 * 
	 * Test method for {@link Metrics.Result#getLoc()}.
	 */
	@Test
	void testGetLoc() {
		Assertions.assertEquals(2, a.getLoc());
	}

	
	/**Tests if the procedure is giving the total of cycles/complexity in the class that it's in 
	 * 
	 * Test method for {@link Metrics.Result#getWmc()}.
	 */
	@Test
	void testGetWmc() {
		Assertions.assertEquals(3, a.getWmc());
	}

	
	/**Tests if the procedure is giving the right number of lines in the method
	 * 
	 * Test method for {@link Metrics.Result#getLocm()}.
	 */
	@Test
	void testGetLocm() {
		Assertions.assertEquals(4, a.getLocm());
	}

	/**Tests if the procedure is giving the right number of cycles/complexity of each method in a file 
	 * 
	 * Test method for {@link Metrics.Result#getCyclom()}.
	 */
	@Test
	void testGetCyclom() {
		Assertions.assertEquals(5, a.getCyclom());
	}

}
