package com.ata.bean;



import javax.persistence.*;

//import com.ata.bean.FlightBean;

import lombok.Data;
import java.util.Date;


@Entity
@Table(name="reservationbean")
@Data
public class ReservationBean {
	@Id




	private String reservationID;	
	private String userID	;
	private String routeID	;
	private Date bookingDate	;
	private Date journeyDate;	
	private String vehicleID;	
	//private String driverID;
	private String bookingStatus;	
	private double totalFare	;
	private String boardingPoint;	
	private String dropPoint	;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name="driver_id")
	private DriverBean driver;

}
