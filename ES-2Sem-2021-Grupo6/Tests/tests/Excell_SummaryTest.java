package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Excell_Summary;

class Excell_SummaryTest {
	
	private static Excell_Summary e;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		File file = new File("Code_Smells.xlsx");
		e = new Excell_Summary();
		e.getMetrics(file);
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testNumPack() {
		Assertions.assertEquals(1, e.getNumPackages());
	}
	
	@Test
	void testNumClass() {
		Assertions.assertEquals(11, e.getNumClasses());
	}

	@Test
	void testNumMethods() {
		Assertions.assertEquals(22, e.getNumMethods());
	}

	@Test
	void testNumLines() {
		Assertions.assertEquals(285, e.getNumLines());
	}
}
