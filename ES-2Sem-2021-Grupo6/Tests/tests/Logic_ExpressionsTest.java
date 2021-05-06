package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CodeSmell.Logic_Expressions;
import CodeSmell.Threshold;

/**
 * To test the "Logic_Expressions" class and its procedure to get the boolean of a logic expression
 *
 */
class Logic_ExpressionsTest {

	private static Threshold cr;
	private static Logic_Expressions le;
	
	/** Setup of the classes needed for the test
	 * 	Instantiate the a Logic_Expression and a Threshold to get the logic value
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cr = new Threshold("LOC_Class", "<", 100);
		le = new Logic_Expressions();
		
	}
	
	/**	Tests if the procedure is giving the right logic value from the comparison with Threshold 
	 *
	 * Test method for {@link CodeSmell.Logic_Expression#one()}.
	 */
	@Test
	void testLogicExpressionsOne() {
		Assertions.assertEquals(true,le.one(cr,70));
	}
	
	/**	Tests if the procedure is giving the right logic value from the comparison between two logic expressions 
	 * using the logic operator "E"
	 *
	 * Test method for {@link CodeSmell.Logic_Expression#twoAnd()}.
	 */
	@Test
	void testLogicExpressionsTwoAnd() {
		Assertions.assertEquals(false, le.twoAnd(true, cr, 110));
	}
	
	/**	Tests if the procedure is giving the right logic value from the comparison between two logic expressions 
	 * using the logic operator "OU"
	 *
	 * Test method for {@link CodeSmell.Logic_Expression#twoOr()}.
	 */
	@Test
	void testLogicExpressionsTwoOr() {
		Assertions.assertEquals(true, le.twoOr(true, cr, 110));
	}

}
