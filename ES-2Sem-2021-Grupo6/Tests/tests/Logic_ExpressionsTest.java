package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CodeSmell.Logic_Expressions;
import CodeSmell.Threshold;

class Logic_ExpressionsTest {

	private static Threshold cr;
	private static Logic_Expressions le;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cr = new Threshold("LOC_Class", "<", 100);
		le = new Logic_Expressions();
		
	}
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLogicExpressionsOne() {
		Assertions.assertEquals(true,le.one(cr,70));
	}
	
	@Test
	void testLogicExpressionsTwoAnd() {
		Assertions.assertEquals(false, le.twoAnd(true, cr, 110));
	}
	
	@Test
	void testLogicExpressionsTwoOr() {
		Assertions.assertEquals(true, le.twoOr(true, cr, 110));
	}

}
