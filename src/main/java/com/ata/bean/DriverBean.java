package com.ata.bean;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.flight.models.ScheduleBean;

import lombok.Data;

@Entity
@Table(name="driverbean")
@Data
public class DriverBean {
	@Id
	private String driverID;
	
	private String name;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String licenseNumber;
	
	@OneToOne(mappedBy = "driver",orphanRemoval = true)
	@JsonIgnore
	private ReservationBean reserve;

	


}
