package com.ata;

import java.util.Scanner;
//import com.ata.util.Authenticate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutomationTravelAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomationTravelAgencyApplication.class,args);
		
		
		/*Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Welcome to Automatic Travel Agency");
	    System.out.println("Admin Login");
	     System.out.println("Enter Credentials");
	     System.out.println("Admin ID:");
	     String gettinguid=sc.nextLine();
	     System.out.println("Password:");
	     String gettingpw=sc.nextLine();
	     Authenticate au=new Authenticate();
	     au.verify(gettinguid,gettingpw);*/
	}
}
