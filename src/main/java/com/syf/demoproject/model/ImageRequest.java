package com.syf.demoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest {
	
	private DemoRequest user;
	
	private ImageDeatails imageDetails;
	

}
