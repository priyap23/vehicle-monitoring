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
	void checkCountOfVehiclesInDatabase() {
		assertEquals(5, controller.displayVehicleDetails().size());
	}
	
	

}
