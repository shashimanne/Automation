package com.ata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ata.bean.VehicleBean;


public interface AdminAtaRepo1 extends JpaRepository<VehicleBean,String> {
	List<VehicleBean> findByVehicleID(String vehicleID);


	
	
	}

