package tests;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CodeSmell.Rule;
import CodeSmell.Threshold;
import Main.CodeSmell_Detector;
import Main.Quality_Graph;

/**
 * To test the "Quality_Graph" class and its procedure to create the data set  
 *
 */
class Quality_GraphTest {

	private static CodeSmell_Detector c;
	private static Quality_Graph graph;

	
	/** Setup of the classes needed for the test
	 * 	Instantiate the two Thresholds and two Rules for each code smell needed to detect in the excel file 
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new CodeSmell_Detector();

		Threshold cr = new Threshold("LOC_Class", "<", 100);
		ArrayList<Threshold> crl = new ArrayList<Threshold>();
		crl.add(cr);
		Rule defClassRule1 = new Rule("default1", "is_God_Class",crl);
		
		Threshold mr = new Threshold("LOC_Method", "<", 20);
		ArrayList<Threshold> mrl = new ArrayList<Threshold>();
		mrl.add(mr);
		Rule defMethodRule1 = new Rule("default2", "is_Long_Method", mrl);

		c.detect("testing\\TestTeste.xlsx", defClassRule1, defMethodRule1);
	}

	/** Creates the object Quality_Graph with the instantiations above needed
	 * 
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@BeforeEach
	void setUp() throws Exception {
		graph = new Quality_Graph(c.classPairs(),c.methodPairs());
	}

	/**	Tests if the procedure is giving the right number of True Negatives gotten from the comparison 
	 * between the code smell detected by the program and the ones written manually by the user
	 * 
	 * Test method for {@link Main.Quality_Graph#getVN()}.
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@Test
	void testVN() throws Exception {
		Assertions.assertEquals(148, graph.getVN());
	}

	/**	Tests if the procedure is giving the right number of True Positives gotten from the comparison 
	 * between the code smell detected by the program and the ones written manually by the user
	 * 
	 * Test method for {@link Main.Quality_Graph#getVP()}.
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@Test
	void testVP() throws Exception {
		Assertions.assertEquals(32, graph.getVP());
	}

	/**	Tests if the procedure is giving the right number of False Negatives gotten from the comparison 
	 * between the code smell detected by the program and the ones written manually by the user
	 * 
	 * Test method for {@link Main.Quality_Graph#getFN()}.
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@Test
	void testFN() throws Exception {
		Assertions.assertEquals(10, graph.getFN());
	}

	/**	Tests if the procedure is giving the right number of False Positives gotten from the comparison 
	 * between the code smell detected by the program and the ones written manually by the user
	 * 
	 * Test method for {@link Main.Quality_Graph#getFP()}.
	 * @throws java.lang.Exception if any error occurs before the test
	 */
	@Test
	void testFP() throws Exception {
		Assertions.assertEquals(41, graph.getFP());
	}
	
}
