package com.ata.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ata.bean.CredentialsBean;


public interface AdminAtaRepo extends JpaRepository<CredentialsBean,Integer> {

	
	
	}

