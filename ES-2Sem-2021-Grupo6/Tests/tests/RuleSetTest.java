/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CodeSmell.Rule;
import CodeSmell.RuleSet;
import CodeSmell.Threshold;

/**
 * To test the "RuleSet" class and its procedure to create an HashMap of rules
 *
 */
class RuleSetTest {
	private static RuleSet rs1;
	private static Rule r;
	private static Rule rReplace;
	private static ArrayList<Threshold> crl;
	private static DefaultListModel<String> showRulesTest;
	private static DefaultListModel<String> showRulesFilteredTest;
	private static HashMap<String, Rule> rulesTest;
	
	
	/** Setup of the classes needed for the test
	 * 	Instantiate a RuleSet to start the test 
	 * 	Create two rules for the test addRule() and replaceRule() methods
	 * 	Create two DefaultListModel for the test of showRules() and showRulesFiltered() methods
	 * 	Create an HashMap to compare on the getHashMap() method test  
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		new Threshold("LOC_Class", "<", 100);
		crl = new ArrayList<Threshold>();
		r = new Rule("teste1","is_God_Class", crl);
		rReplace = new Rule("teste2", "is_God_Class", crl);
		rs1 = new RuleSet();
		rulesTest = new HashMap<>();
		rulesTest.put("teste1", r);
		showRulesTest = new DefaultListModel<>();
		showRulesTest.addElement("default1");
		showRulesTest.addElement("default2");
		showRulesTest.addElement("teste1");
		showRulesFilteredTest = new DefaultListModel<>();
		showRulesFilteredTest.addElement("default1");
	}

	/**Initialize here the RuleSet so it covers when the file doesn't exist and when it exists
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		rs1.initializeMap("FicheiroTeste.txt");
	}
	
	
	/**Tests if the procedure is adding properly the rule 
	 * 
	 * Test method for {@link CodeSmell.RuleSet#addRule()}.
	 */
	@Test
	void testAddRule() {
		rs1.addRule(r);
		assertTrue(r.equals(rs1.getHashMap().get("teste1")));
	}

	/**Tests if the procedure is replacing properly the rule 
	 * 
	 * Test method for {@link CodeSmell.RuleSet#replaceRule()}.
	 */
	@Test
	void testReplaceRule() {
		rs1.replaceRule(r.getId(), rReplace);
		assertTrue(rReplace.equals(rs1.getHashMap().get("teste2")));
		assertFalse(r.equals(rs1.getHashMap().get("teste1")));
	}
	
	/**Tests if the procedure is returning the exact DefaultListModel to show in the GUI 
	 * 
	 * Test method for {@link CodeSmell.RuleSet#showRules()}.
	 */
	@Test
	void testShowRules() {
		for(int i = 0; i<showRulesTest.getSize();  i++)
			assertTrue(rs1.showRules().get(i).equals(showRulesTest.get(i)));
	}
	
	/**Tests if the procedure is returning the exact DefaultListModel to show in the GUI 
	 * 
	 * Test method for {@link CodeSmell.RuleSet#showRulesFiltered()}.
	 */
	@Test
	void testShowRulesFiletered() {
		for(int i = 0; i<showRulesFilteredTest.getSize();  i++)
			assertTrue(rs1.showRulesFiltered("is_God_Class").get(i).equals(showRulesFilteredTest.get(i)));
	}
	
	


}
