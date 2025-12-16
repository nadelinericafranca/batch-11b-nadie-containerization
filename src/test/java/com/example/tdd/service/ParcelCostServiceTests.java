package com.example.tdd.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ParcelCostServiceTests {

	ParcelCostService parcelCostService = new ParcelCostServiceImpl();

	@Test
	public void testCase_TC10() {
		double l = 10;
		double w = 10;
		double h = 10;
		double expected = 30;

		double cost = parcelCostService.computeCost(l, w, h);

		Assertions.assertEquals(expected, cost);
	}

	@Test
	public void testCase_TC20() {
		double l = 20;
		double w = 10;
		double h = 10;
		double expected = 80;

		double cost = parcelCostService.computeCost(l, w, h);

		Assertions.assertEquals(expected, cost);
	}

	@Test
	public void testCase_TC30() {
		double l = 30;
		double w = 10;
		double h = 10;
		double expected = 150;

		double cost = parcelCostService.computeCost(l, w, h);

		Assertions.assertEquals(expected, cost);
	}

	@Test
	public void testCase_TC40() {
		double l = 15;
		double w = 10;
		double h = 10;
		double expected = 60;

		double cost = parcelCostService.computeCost(l, w, h);

		Assertions.assertEquals(expected, cost);
	}

	@Test
	public void testCase_TC50() {
		double l = 25;
		double w = 10;
		double h = 10;
		double expected = 125;

		double cost = parcelCostService.computeCost(l, w, h);

		Assertions.assertEquals(expected, cost);
	}

	@Test
	public void testCase_TC60() throws Exception {
		String expectedErrorMessage = "Length must be greater than 0";

		double l = 0;
		double w = 10;
		double h = 10;

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parcelCostService.computeCost(l, w, h);
		});
		Assertions.assertEquals(expectedErrorMessage, thrown.getMessage());
	}

	@Test
	public void testCase_TC70() throws Exception {
		String expectedErrorMessage = "Width must be greater than 0";

		double l = 10;
		double w = 0;
		double h = 10;

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parcelCostService.computeCost(l, w, h);
		});
		Assertions.assertEquals(expectedErrorMessage, thrown.getMessage());
	}

	@Test
	public void testCase_TC80() throws Exception {
		String expectedErrorMessage = "Height must be greater than 0";

		double l = 10;
		double w = 10;
		double h = 0;

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parcelCostService.computeCost(l, w, h);
		});
		Assertions.assertEquals(expectedErrorMessage, thrown.getMessage());
	}

	@Test
	public void testCase_TC90() throws Exception {
		String expectedErrorMessage = "Length must be greater than 0";

		double l = -1;
		double w = 10;
		double h = 10;

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parcelCostService.computeCost(l, w, h);
		});
		Assertions.assertEquals(expectedErrorMessage, thrown.getMessage());
	}

	@Test
	public void testCase_TC100() throws Exception {
		String expectedErrorMessage = "Width must be greater than 0";

		double l = 10;
		double w = -1;
		double h = 10;

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parcelCostService.computeCost(l, w, h);
		});
		Assertions.assertEquals(expectedErrorMessage, thrown.getMessage());
	}

	@Test
	public void testCase_TC110() throws Exception {
		String expectedErrorMessage = "Height must be greater than 0";

		double l = 10;
		double w = 10;
		double h = -1;

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parcelCostService.computeCost(l, w, h);
		});
		Assertions.assertEquals(expectedErrorMessage, thrown.getMessage());
	}
}
