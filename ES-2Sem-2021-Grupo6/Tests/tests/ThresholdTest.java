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

	/** Setup of the classes needed for the test
	 * 	Instantiate a RuleSet to get the the thresholds from a text file and Threshold with the values manually counted 
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t1 = new Threshold("LOC_Class", "<", 100);
		t2 = new Threshold("LOC_Class", ">", 20, "and");
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
		Assertions.assertEquals("and",t2.getLogic());
	}
}
