package com.ata.controller;


import java.util.List;
import java.util.Random;
import com.ata.exception.RouteNotFoundException;
import com.ata.exception.ListIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.ata.bean.RouteBean;
import com.ata.service.AdminService;


  
@RestController
  
public class RouteController {
  
    @Autowired 
    AdminService adminservice;
	  
	//View all Route Details
	    
	    @GetMapping(value="/routes")
	    public List<RouteBean> fetchsRouteList() 
	    {     
	  	 
	  	 if(adminservice.fetchRouteList().isEmpty())   throw new ListIsEmptyException();

	  		System.out.println("Fetched successfully");

	  	 	return adminservice.fetchRouteList();
	     }
	  
	  //Post Route Details
	  
		@PostMapping(value= "/route/addroute")
	    public String addRoute(@RequestBody RouteBean routebean)
	  { 
			Random rand=new Random();
			int randint=rand.nextInt((9999 - 500) + 1) +10;
			routebean.setRouteID(routebean.getSource().substring(0, 2) + routebean.getDestination().substring(0, 2) + Integer.toString(randint));
			adminservice.addRoute(routebean);
			return "Created successfully";
	   }
		
		//Delete Route Details
		
		  @DeleteMapping(value="/route/delete/{routeID}")
		   public String deleteRoute(@PathVariable("routeID") String routeID)
		   
		   {
			  System.out.println("route deleted");
			  adminservice.deleteRoute(routeID);

		       return "Deleted Successfully";
		 }
		  
		  //View Route Details by ID
		  
		  @GetMapping(value= "/route/routeID/{routeID}")

		  public List<RouteBean> viewRoute(@PathVariable("routeID")String routeID)
		   { 
				
		   if(adminservice.viewRoute(routeID).isEmpty())  throw new RouteNotFoundException();
		 

		   System.out.println("Fetched Successfully");
		   return adminservice.viewRoute(routeID);

		   }
		  
		  //Put Route Details
		
		  @PutMapping(path="/route/update",consumes= {"application/json"})

		   public String modifyRoute(@RequestBody RouteBean routebean)

		   {

			  adminservice.modifyRoute(routebean);
		      return "Updated Sucessfully";

		   }
	
}
