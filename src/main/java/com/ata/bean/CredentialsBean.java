package com.ata.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="credentialsbean")
@Data
public class CredentialsBean {
	
	@Id
	private String userId;
	private String password;
	private String usertype;
	private int loginStatus;
}