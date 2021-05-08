package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CodeSmell.Threshold;

/**
 * To test the "Threshold" class and its procedure to create the rules that the user wants
 *
 */
class ThresholdTest {
	
	private static Threshold t1;
	private static Threshold t2;
	private static String s2;
	private static String s1;
	private static String toString;

	/** Setup of the classes needed for the test
	 * 	Instantiate a RuleSet to get the the thresholds from a text file and Threshold with the values manually counted 
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t1 = new Threshold("LOC_Class", "<", 100);
		t2 = new Threshold("LOC_Class", ">", 20, "E");
		s1 = "LOC_Class, <, 100";
		s2 = "LOC_Class, >, 20, E";
		toString = "LOC_Class > 20 E";
	}

	/** Starts the procedure and creates a Threshold with the values manually counted
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**Tests if the procedure is giving the right metric's name of the threshold
	 * Constructor without logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getName()}.
	 */
	@Test
	void testThreshold1Name() {
		Assertions.assertEquals("LOC_Class",t1.getName());
	}
	
	/**Tests if the procedure is giving the right comparison operator of the threshold
	 * Constructor without logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getMath()}.
	 */
	@Test
	void testThreshold1Math() {
		Assertions.assertEquals("<",t1.getMath());
	}
	
	/**Tests if the procedure is giving the right value used as reference for detecting code smells
	 * Constructor without logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getValue()}.
	 */
	@Test
	void testThreshold1Value() {
		Assertions.assertEquals(100,t1.getValue());
	}

	/**Tests if the procedure is giving the right logic operator ""
	 * Constructor without logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getLogic()}.
	 */
	@Test
	void testThreshold1Logic() {
		Assertions.assertEquals(null,t1.getLogic());
	}
	
	/**Tests if the procedure is giving the right name of the threshold code smell
	 * Constructor with logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getName()}.
	 */
	@Test
	void testThreshold2Name() {
		Assertions.assertEquals("LOC_Class",t2.getName());
	}
	
	/**Tests if the procedure is giving the right comparison operator for detecting code smells
	 * Constructor with logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getMath()}.
	 */
	@Test
	void testThreshold2Math() {
		Assertions.assertEquals(">",t2.getMath());
	}
	
	/**Tests if the procedure is giving the right value used as reference for detecting code smells
	 * Constructor with logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getValue()}.
	 */
	@Test
	void testThreshold2Value() {
		Assertions.assertEquals(20,t2.getValue());
	}

	/**Tests if the procedure is giving the right logic operator "E" or "OU"
	 * Constructor with logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getLogic()}.
	 */
	@Test
	void testThreshold2Logic() {
		Assertions.assertEquals("E",t2.getLogic());
	}
	
	
	/**Tests if the procedure is giving the format to write the threshold in a file
	 * Constructor with logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getLogic()}.
	 */
	@Test
	void testToFileS1() {
		Assertions.assertEquals(s1,t1.toFile());
	}
	
	/**Tests if the procedure is giving the format to write the threshold in a file
	 * Constructor with logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getLogic()}.
	 */
	@Test
	void testToFileS2() {
		Assertions.assertEquals(s2,t2.toFile());
	}
	
	/**Tests if the procedure is giving the format to write the threshold on the GUI
	 * Constructor with logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getLogic()}.
	 */
	@Test
	void testToStringS1() {
		Assertions.assertEquals(toString,t2.toString());
	}
	
}
