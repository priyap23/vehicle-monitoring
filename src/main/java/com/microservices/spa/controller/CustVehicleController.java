package com.microservices.spa.controller;

import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping(value="/home", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustVehicle> displayVehicleDetails() {
		
		Iterable<CustVehicle> list = repo.findAll();
		List<CustVehicle> listVehicle = new ArrayList<CustVehicle>();
		for (CustVehicle custVehicle : list) {
			listVehicle.add(custVehicle);
		}
		System.out.println("List :::::; "+list.toString());
		return listVehicle;
	}
}
