package com.ata.service;

import java.util.List;
import com.ata.exception.DriverNotFoundException;
import com.ata.exception.VehicleNotFoundException;
//import com.flight.models.ScheduleBean;
import com.ata.exception.RouteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ata.dao.AdminAtaRepo1;

import com.ata.dao.AdminAtaRepo2;

import com.ata.dao.AdminAtaRepo3;

import com.ata.dao.AdminAtaRepo5;

import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;




@Service

public class AdminService{
	
	@Autowired
	
	private AdminAtaRepo1 adminrepo1;
	@Autowired
	private AdminAtaRepo2 adminrepo2;
	@Autowired
	private AdminAtaRepo3 adminrepo3;
	
	@Autowired
	private AdminAtaRepo5 adminrepo5;
	//Vehicle Methods
	//View all
	public List<VehicleBean> fetchVehicleList() {
		return (List<VehicleBean>) adminrepo1.findAll();
	}

	//add Vehicle
	
	public VehicleBean addVehicle(VehicleBean vehiclebean) {

		return adminrepo1.save(vehiclebean);
	}
	
	//Delete Vehicle

	public int deleteVehicle(String vehicleID) {
		if(adminrepo1.existsById(vehicleID))
		{
		adminrepo1.deleteById(vehicleID);
		return 1;
		}
		else {
			throw new VehicleNotFoundException();
		}
		
	}
	
	//View Vehicle by VehicleID

	public List<VehicleBean> viewVehicle(String vehicleID) {

		return (List<VehicleBean>) adminrepo1.findByVehicleID(vehicleID);

	}
	
	//Modify Vehicle Details

	public void modifyVehicle(VehicleBean vehicleBean) {
		 adminrepo1.save(vehicleBean);
	}
	
	
	
	//Driver Methods
	//View all Drivers Details
	
	public List<DriverBean> fetchDriverList() {
		return (List<DriverBean>) adminrepo3.findAll();
	}
	
	//Add Driver

	public DriverBean addDriver(DriverBean driverBean) {

		return  adminrepo3.save(driverBean);
	}
	
	//Delete Driver by DriverID

	public int deleteDriver(String driverID) {
		if(adminrepo3.existsById(driverID))
		{
		adminrepo3.deleteById(driverID);
		return 1;
		}
		else {
			throw new DriverNotFoundException();
		}
	}
	
	//View Driver by DriverID

	public List<DriverBean> viewDriver(String DriverID) {

		return (List<DriverBean>) adminrepo3.findByDriverID(DriverID);
	}

	//Modify Driver Details
	
	public void modifyDriver(DriverBean driverBean) {
		 adminrepo3.save(driverBean);

	}
	public ReservationBean allotDriver(ReservationBean reservationbean) {
		
		return  adminrepo5.save(reservationbean);

	}


	//Route Methods
	//View all Route Details
	
	public List<RouteBean> fetchRouteList() {
		return (List<RouteBean>) adminrepo2.findAll();
	}
	
	//add Routes
	
	public String addRoute(RouteBean routeBean) {
		adminrepo2.save(routeBean);
		return null;
	}

	//Delete Route by RouteID
	
	public int deleteRoute(String routeID) {
		if(adminrepo2.existsById(routeID))
		{
		adminrepo2.deleteById(routeID);
		return 1;
		}
		else {
			throw new RouteNotFoundException();
		}
	}

	
	//View Route by RouteID
	
	public List<RouteBean> viewRoute(String routeID) {
		return (List<RouteBean>) adminrepo2.findByRouteID(routeID);
	}
	

	//Modify RouteDetails
	
	public void modifyRoute(RouteBean routeBean) {
		 adminrepo2.save(routeBean);
	}

	//@Override
//	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate, String source, String destination) {
	//	return null;
//	}

}