package com.ata.bean;



import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name="vehiclebean")
@Data
public class VehicleBean {
	@Id
	private String vehicleID;
	private String name;
	private String type;
	private String registrationNumber;
	private int seatingCapacity;
	private double farePerKM;


}
