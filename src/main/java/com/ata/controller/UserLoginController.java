package com.ata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ata.dao.AdminAtaRepo;
import com.ata.bean.CredentialsBean;
import com.ata.bean.Status;
@RestController
public class UserLoginController {

@Autowired
AdminAtaRepo cred;




@GetMapping("users/credentialslist")
public List<CredentialsBean> Cred(){
	return cred.findAll();
}

@PostMapping(value="/users/login",consumes = "application/json")
public Status loginUser(@RequestBody CredentialsBean user) {
  
            if(user.getUserId().equals("admin") && user.getPassword().equals("ata")) {

            	return Status.Login_Successfully;
            }
    

    return Status.User_not_found;
}
@PostMapping("/users/logout")
public Status logUserOut(@RequestBody CredentialsBean user) {
    
  
            if(user.getUserId().equals("admin") && user.getPassword().equals("ata")) {

            	return Status.Logout_Successfully;
            }
 
    return Status.Failure;
}

    
}


