package com.ata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ata.bean.RouteBean;


public interface AdminAtaRepo2 extends JpaRepository<RouteBean,String> {
	List<RouteBean> findByRouteID(String routeID);


	
	
	}

