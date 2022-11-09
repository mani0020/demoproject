package com.syf.demoproject.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
	
	@Id
	private String id;
	private String userName;
	private String password;
	private String gender;
	
	@OneToMany
	@JoinTable(name = "user_images",
	      joinColumns = {
	    		  @JoinColumn(name = "id")
	      },
	      inverseJoinColumns = {
	    		  @JoinColumn(name = "imageId")
	      }
	 )
	private List<ImageEntity> images;

}
