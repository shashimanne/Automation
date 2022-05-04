package com.ata.bean;



import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name="routebean")
@Data

public class RouteBean {
	@Id
	private String routeID;
	private String source;
	private String destination;
	private int distance;
	private int travelDuration;


}
