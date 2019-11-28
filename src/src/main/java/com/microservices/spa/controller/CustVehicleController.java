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
	private String strStatus = "Connected";
	
	@RequestMapping(value="/home", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustVehicle> displayVehicleDetails() throws Exception {
		
		Iterable<CustVehicle> list = repo.findAll();
		List<CustVehicle> listVehicle = new ArrayList<CustVehicle>();
		for (CustVehicle custVehicle : list) {
			listVehicle.add(custVehicle);
		}
		//System.out.println("List :::::; "+list.toString());
		return listVehicle;
	}
	
	@RequestMapping(value="/updateStatus", method=RequestMethod.GET)
	public void updateVehicleStatus() throws Exception{
		
		strStatus = (strStatus.equals("Connected")) ? "Disconnected" : "Connected";
		Iterable<CustVehicle> list = repo.findAll();
		List<CustVehicle> listVehicle = new ArrayList<CustVehicle>();
		String strCustName = "Kalles Grustransporter AB";
		String strTempCustName;
		int count = 0;
		for (CustVehicle custVehicle : list) {
			strTempCustName = custVehicle.getStrCustName();
			if(strTempCustName.equalsIgnoreCase(strCustName) && count !=2) {
				custVehicle.setStrVehicleStatus(strStatus);
				repo.save(custVehicle);
				count++;
			}
			if(count == 2)
				break;
			listVehicle.add(custVehicle);
		}
		 //System.out.println("strStatus ::::::: "+strStatus);
		//System.out.println("List11111 :::::; "+listVehicle.toString());
		
	}
}
