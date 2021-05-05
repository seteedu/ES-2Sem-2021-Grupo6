package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CodeSmell.Rule;
import CodeSmell.Threshold;
import Main.CodeSmell_Detector;
import Main.Quality_Graph;

class Quality_GraphTest {

	private static CodeSmell_Detector c;
	private static Quality_Graph graph;

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

		c.detect("Code_Smells.xlsx", defClassRule1, defMethodRule1);
		
		graph = new Quality_Graph(c.classPairs(),c.methodPairs());
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testVN() throws Exception {
		Assertions.assertEquals(4, graph.getVN());
	}

	@Test
	void testVP() throws Exception {
		Assertions.assertEquals(9, graph.getVP());
	}

	@Test
	void testFN() throws Exception {
		Assertions.assertEquals(1, graph.getFN());
	}

	@Test
	void testFP() throws Exception {
		Assertions.assertEquals(14, graph.getFP());
	}


}
