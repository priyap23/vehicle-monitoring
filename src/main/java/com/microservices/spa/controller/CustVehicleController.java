package com.microservices.spa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.spa.dao.CustVehicle;
import com.microservices.spa.dao.VehicleRepository;

@RestController
public class CustVehicleController {

	@Autowired
	VehicleRepository repo;
	private String strStatus = "Connected";
	
	/**
	 * This method acts as GET service, used for displaying all details of vehicle
	 * @return List of Vehicles from h2 database
	 * @throws Exception
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustVehicle> displayVehicleDetails() throws Exception {
		
		Iterable<CustVehicle> list = repo.findAll();	//Get all details of vehicle from Database
		List<CustVehicle> listVehicle = new ArrayList<CustVehicle>();
		for (CustVehicle custVehicle : list) {
			listVehicle.add(custVehicle);
		}
		return listVehicle;
	}
	
	/**
	 * This method act as GET service call for updating the Status of vehicle randomly
	 * @throws Exception
	 */
	@RequestMapping(value="/updateStatus", method=RequestMethod.GET)
	public void updateVehicleStatus() throws Exception{
		
		Iterable<CustVehicle> list = repo.findAll();
		int rowConut = (int) repo.count();
		
		List<CustVehicle> randomListVehicle = new ArrayList<CustVehicle>();
		
		int randomNumber = getRandomNumberInRange(1, rowConut);
		int count = 0;
		
		for(CustVehicle vehicle : list) { //Vehicle details from DB
			if(randomNumber>0) { //Loop to change the status for vehicle till value of random number
				strStatus = vehicle.getStrVehicleStatus();
				strStatus = (strStatus.equals("Connected")) ? "Disconnected" : "Connected"; //Change the status as for Connected set Disconnected and vice versa
				vehicle.setStrVehicleStatus(strStatus);
				repo.save(vehicle);
				randomNumber--;
			} else 
				break;
		}
		
	}
	
	/**
	 * This method returns random number between 1 to 7
	 * @param min : 1
	 * @param max : 7
	 * @return
	 */
	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than Min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
