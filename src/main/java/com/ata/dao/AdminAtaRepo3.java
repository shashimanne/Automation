package com.ata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ata.bean.DriverBean;


public interface AdminAtaRepo3 extends JpaRepository<DriverBean,String> {
	List<DriverBean> findByDriverID(String DriverID);


	
	
	}

