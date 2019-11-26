package com.microservices.spa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<CustVehicle, String> {

	/*
	 * @Query List<Vehicle> findByCustName(@Param("custname") String strCustName);
	 * 
	 * @Query List<Vehicle> findByVehicleStatus(@Param("vechiclestatus") String
	 * strVehicleStatus);
	 */
}

