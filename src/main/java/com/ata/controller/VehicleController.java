package com.ata.controller;


import java.util.List;
import java.util.Random;
import com.ata.exception.VehicleNotFoundException;
import com.ata.exception.ListIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.ata.bean.VehicleBean;
import com.ata.service.AdminService;


  
@RestController
  
public class VehicleController {
  
    @Autowired 
    AdminService adminservice;
    
    //View all Vehicles
    
    @GetMapping(value="/vehicles")
    public List<VehicleBean> fetchVehicleList() 
    {     
  	 
  	 if(adminservice.fetchVehicleList().isEmpty())   throw new ListIsEmptyException();

  		System.out.println("Fetched successfully");

  	 	return adminservice.fetchVehicleList();
     }

   
    //Post Vehicle Details
	
	@PostMapping(value= "/vehicle/addvehicle")
    public String addVehicle(@RequestBody VehicleBean vehiclebean)
  { 
		Random rand=new Random();
		int randint=rand.nextInt((9999 - 500) + 1) +10;
		vehiclebean.setVehicleID(vehiclebean.getName().substring(0, 2) + Integer.toString(randint));
		adminservice.addVehicle(vehiclebean);
		return "Created successfully";
   }
	
	
	//Delete Vehicle Details
	
	  @DeleteMapping(value="/vehicle/delete/{vehicleID}")
	   public String deleteVehicle(@PathVariable("vehicleID")String vehicleID)
	   {
		  adminservice.deleteVehicle(vehicleID);

	       return "Deleted Successfully";
	 }
	  
	  //View Vehicle Details by ID
	  
	  @GetMapping(value= "/vehicle/vehicleid/{vehicleID}")

	  public List<VehicleBean> viewVehicle(@PathVariable("vehicleID")String vehicleID)
	   { 
			
	   if(adminservice.viewVehicle(vehicleID).isEmpty())  throw new VehicleNotFoundException();
	 

	   System.out.println("Fetched Successfully");
	   return adminservice.viewVehicle(vehicleID);

	   }
	  
	  
	  //Put Vehicle Details
	  
	  @PutMapping(path="/vehicle/update",consumes= {"application/json"})

	   public String modifyVehicle(@RequestBody VehicleBean vehiclebean)

	   {
		  
		  adminservice.modifyVehicle(vehiclebean);
	      return "Updated Sucessfully";

	   }
	  
}  