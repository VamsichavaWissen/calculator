package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(Lifecycle.PER_CLASS)
class CalculatorServiceTest {
	
	static Calculator c1;
	
	@BeforeAll
	void createCalculator() {
		c1 = new Calculator();
	}
	
	@AfterAll
	static void removeCalculator() {
		c1 = null;
	}
	
	
	
	@Test
	@EnabledOnOs(value = OS.WINDOWS)
	void testAdd() {
		
		int actual = c1.add(10, 100);
		int expected = 110;
		assertEquals(expected, actual);
	}
	
	@Test
	void testDevide() {
		assertThrows(ArithmeticException.class, ()->c1.devide(10, 0));
		assertEquals(1, c1.devide(10, 10));
	}
	
	@Test
	void testSub() {
		assertAll(
				()->assertEquals(1, c1.sub(11, 10)),
				()->assertEquals(1, c1.sub(12, 11)),
				()->assertEquals(11, c1.sub(21, 10))
		);
	}
	
}
