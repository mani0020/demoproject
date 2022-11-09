package com.syf.demoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoRequest {
	
	private String userId;
	private String gender;
	private String userName;
	private String password;
	

}
