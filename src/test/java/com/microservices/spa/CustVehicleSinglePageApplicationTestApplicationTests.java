package com.microservices.spa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservices.spa.controller.CustVehicleController;

@SpringBootTest
class CustVehicleSinglePageApplicationTestApplicationTests {

	@Autowired
	CustVehicleController controller;
	
	@Test
	void checkCountOfVehiclesInDatabase() throws Exception{
		assertEquals(7, controller.displayVehicleDetails().size());
	}
	
	@Test
	void checkRandomNumberInRange() {
		int randomNumber = CustVehicleController.getRandomNumberInRange(1, 7);
		boolean isInRange = (randomNumber>=1 && randomNumber<=7);
		assertEquals(true, isInRange);
	}
	

}
