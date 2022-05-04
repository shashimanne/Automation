package com.ata.controller;


import java.util.List;
import java.util.Random;
import com.ata.exception.DriverNotFoundException;
import com.ata.exception.ListIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.service.AdminService;
import com.ata.dao.*;

  
@RestController
  
public class DriverController {
  
    @Autowired 
    AdminService adminservice;
    @Autowired
    AdminAtaRepo3 admin;
    

   	//View all Drivers Details
   	    
   	    @GetMapping(value="/drivers")
   	    public List<DriverBean> fetchsDriverList() 
   	    {     
   	  	 
   	  	 if(adminservice.fetchDriverList().isEmpty())   throw new ListIsEmptyException();

   	  		System.out.println("Fetched successfully");

   	  	 	return adminservice.fetchDriverList();
   	     }
   	  
   	  
   	  //Post Driver Details
   	  
   		@PostMapping(value= "/driver/adddriver")
   	    public String addDriver(@RequestBody DriverBean driverbean)
   	  {
   			Random rand=new Random();
   			int randint=rand.nextInt((9999 - 500) + 1) +10;
   			driverbean.setDriverID(driverbean.getName().substring(0, 2) + Integer.toString(randint));
   			adminservice.addDriver(driverbean);
   			return "Created successfully";
   	   }
   		
   		
   		//Delete Driver Details by ID
   		
   		  @DeleteMapping(value="/driver/delete/{driverID}")
   		   public String deleteDriver(@PathVariable("driverID") String driverID)
   		   {
   			  adminservice.deleteDriver(driverID);

   		       return "Deleted Successfully";
   		 }
   		  
   		//View Driver Details by ID
   		  
   		  @GetMapping(value= "/driver/driverid/{driverID}")

   		  public List<DriverBean> viewdriver(@PathVariable("driverID")String driverID)
   		   { 
   				
   		   if(adminservice.viewDriver(driverID).isEmpty())  throw new DriverNotFoundException();
   		 

   		   System.out.println("Fetched Successfully");
   		   return adminservice.viewDriver(driverID);

   		   }
   		  
   		  //Put Driver Details
   		  
   		  @PutMapping(path="/driver/update",consumes= {"application/json"})

   		   public String modifyDriver(@RequestBody DriverBean driverbean)

   		   {
   			  adminservice.modifyDriver(driverbean);
   		      return "Updated Sucessfully";

   		   }
   		@PostMapping(consumes = "application/json",value="/schedule/save")
   		public String allotDriver(@RequestBody ReservationBean reservebean) {

   			List<DriverBean> Ddetails = admin.findAll();

   			for(DriverBean fd: Ddetails) {
   				if(fd.getDriverID().equals(reservebean.getDriver().getDriverID())) {
   					reservebean.getDriver().setDriverID(fd.getDriverID());
   					Random rand = new Random();
   					int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
   					reservebean.setReservationID(reservebean.getDriver().getName().substring(0,2) + Integer.toString(resRandom)); 
   					adminservice.allotDriver(reservebean);
   					return "Alloted succesfully";
   					 
   				}	
   			}
   			throw new DriverNotFoundException();
   				
   		}
   			
   			
   		}
   		  
   		  
   		  

    
    