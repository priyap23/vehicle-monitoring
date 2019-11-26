package com.microservices.spa.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "custvehicle")
public class CustVehicle {

	@Id
	@Column(name="vin")
	String strVehicleNumber;
	
	@Column(name="regnr")
	String strRegistratioNumber;
	
	@Column(name="vname")
	String strVehicleName;
	
	@Column(name="custname")
	String strCustName;
	
	@Column(name="custaddr")
	String strCustAddress;
	
	@Column(name="vstatus")
	String strVehicleStatus;

	public String getStrVehicleNumber() {
		return strVehicleNumber;
	}

	public void setStrVehicleNumber(String strVehicleNumber) {
		this.strVehicleNumber = strVehicleNumber;
	}

	public String getStrRegistratioNumber() {
		return strRegistratioNumber;
	}

	public void setStrRegistratioNumber(String strRegistratioNumber) {
		this.strRegistratioNumber = strRegistratioNumber;
	}

	public String getStrVehicleName() {
		return strVehicleName;
	}

	public void setStrVehicleName(String strVehicleName) {
		this.strVehicleName = strVehicleName;
	}

	public String getStrCustName() {
		return strCustName;
	}

	public void setStrCustName(String strCustName) {
		this.strCustName = strCustName;
	}

	public String getStrCustAddress() {
		return strCustAddress;
	}

	public void setStrCustAddress(String strCustAddress) {
		this.strCustAddress = strCustAddress;
	}

	public String getStrVehicleStatus() {
		return strVehicleStatus;
	}

	public void setStrVehicleStatus(String strVehicleStatus) {
		this.strVehicleStatus = strVehicleStatus;
	}

	@Override
	public String toString() {
		return "Vehicle [strVehicleNumber=" + strVehicleNumber + ", strRegistratioNumber=" + strRegistratioNumber
				+ ", strVehicleName=" + strVehicleName + ", strCustName=" + strCustName + ", strCustAddress="
				+ strCustAddress + ", strVehicleStatus=" + strVehicleStatus + "]";
	}
	
	
	
}
