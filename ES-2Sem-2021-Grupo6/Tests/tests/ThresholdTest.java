package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CodeSmell.Threshold;

class ThresholdTest {
	
	private static Threshold t1;
	private static Threshold t2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t1 = new Threshold("LOC_Class", "<", 100);
		t2 = new Threshold("LOC_Class", ">", 20, "and");
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testThreshold1Name() {
		Assertions.assertEquals("LOC_Class",t1.getName());
	}
	
	@Test
	void testThreshold1Math() {
		Assertions.assertEquals("<",t1.getMath());
	}
	
	@Test
	void testThreshold1Value() {
		Assertions.assertEquals(100,t1.getValue());
	}

	@Test
	void testThreshold1Logic() {
		Assertions.assertEquals(null,t1.getLogic());
	}
	
	@Test
	void testThreshold2Name() {
		Assertions.assertEquals("LOC_Class",t2.getName());
	}
	
	@Test
	void testThreshold2Math() {
		Assertions.assertEquals(">",t2.getMath());
	}
	
	@Test
	void testThreshold2Value() {
		Assertions.assertEquals(20,t2.getValue());
	}

	@Test
	void testThreshold2Logic() {
		Assertions.assertEquals("and",t2.getLogic());
	}
}
