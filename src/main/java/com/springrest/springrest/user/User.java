package com.springrest.springrest.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.springrest.springrest.user.Customannotations.NameCustom; 

@Entity  
@Table(name = "User")
@ToString
@NoArgsConstructor
@Data
public class User {
	
	@Id  
	@GeneratedValue 
	@Column(name = "id")
	private Integer id;
	
	
	@NameCustom (message = "Name can contains only alphabates")
	@Column(name = "name")
	private String name; 
	
	@Column(name = "dob")
	private Date dob; 
    

}
