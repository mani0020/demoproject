package com.syf.demoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDeatails {
	
	private String imageId;
	private String typr;
	private String width;
	private String height;
	private String size;
	private String link;
	private String inGallery;
	private String name;

}
