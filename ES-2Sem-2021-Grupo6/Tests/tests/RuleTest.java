package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CodeSmell.Rule;
import CodeSmell.Threshold;

class RuleTest {
	
	private static Rule defClassRule1;
	private static Threshold cr;
	private static ArrayList<Threshold> t_list;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		cr = new Threshold("LOC_Class", "<", 100);
		ArrayList<Threshold> crl = new ArrayList<Threshold>();
		crl.add(cr);
		t_list = new ArrayList<Threshold>();
		t_list.add(cr);
		defClassRule1 = new Rule("default1", "is_God_Class",crl);
		
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRuleId() {
		Assertions.assertEquals("default1", defClassRule1.getId());
	}
	
	@Test
	void testRuleCodeSmell() {
		Assertions.assertEquals("is_God_Class", defClassRule1.getCodeSmell());
	}
	
	@Test
	void testRuleThresholdList() {
		Assertions.assertIterableEquals(t_list, defClassRule1.getThresholds());
	}

}
