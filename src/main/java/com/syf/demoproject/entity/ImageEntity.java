package com.syf.demoproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "image")
public class ImageEntity {
	
	private String imageId;
	private String typr;
	private String width;
	private String height;
	private String size;
	private String link;
	private String inGallery;
	private String name;

}
