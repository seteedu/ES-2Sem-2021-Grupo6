package tests;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CodeSmell.Rule;
import CodeSmell.Threshold;

/**
 * To test the "Rule" class and its procedure to create the rules that the user wants
 *
 */
class RuleTest {
	
	private static Rule defClassRule1;
	private static Threshold cr;
	private static ArrayList<Threshold> t_list;
	private static ArrayList<Threshold> crl;
	private static String s;
	private static String toString;

	/** Setup of the classes needed for the test
	 * 	Instantiate a RuleSet to get the the rules from a text file and Threshold with the values manually counted
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cr = new Threshold("LOC_Class", "<", 100);
		crl = new ArrayList<Threshold>();
		t_list = new ArrayList<Threshold>();
		crl.add(cr);
		t_list.add(cr);
		defClassRule1 = new Rule("default1", "is_God_Class",crl);
		s = "default1, is_God_Class, LOC_Class, <, 100";
		toString = "is_God_Class:  LOC_Class < 100";
	}

	/** Starts the procedure and creates a Rule with the values manually counted
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**Tests if the procedure is giving the right name of the rule
	 * 
	 * Test method for {@link CodeSmell.Rule#getId()}.
	 */
	@Test
	void testRuleId() {
		Assertions.assertEquals("default1", defClassRule1.getId());
	}
	
	/**Tests if the procedure is giving the right type of the code smell
	 * 
	 * Test method for {@link CodeSmell.Rule#getCodeSmell()}.
	 */
	@Test
	void testRuleCodeSmell() {
		Assertions.assertEquals("is_God_Class", defClassRule1.getCodeSmell());
	}
	
	/**Tests if the procedure is giving the right list of thresholds in a rule
	 * 
	 * Test method for {@link CodeSmell.Rule#getThresholds()}.
	 */
	@Test
	void testRuleThresholdList() {
		Assertions.assertIterableEquals(t_list, defClassRule1.getThresholds());
	}
	
	/**Tests if the procedure is giving the format to write the Rule in a file
	 * 
	 * Test method for {@link CodeSmell.Rule#toFile()}.
	 */
	@Test
	void testToFile() {
		Assertions.assertEquals(s,defClassRule1.toFile());
	}
	
	/**Tests if the procedure is giving the format to write the Rule in the GUI
	 * Constructor with logic operator
	 * 
	 * Test method for {@link CodeSmell.Threshold#getLogic()}.
	 */
	@Test
	void testToString() {
		Assertions.assertEquals(toString,defClassRule1.toString());
	}
	
		
	

}
