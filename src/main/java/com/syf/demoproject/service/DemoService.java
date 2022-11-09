package com.syf.demoproject.service;

import com.syf.demoproject.model.DemoRequest;
import com.syf.demoproject.model.ImageRequest;

public interface DemoService {
	
	public void save(DemoRequest request);
	
	public DemoRequest getUserData(String id);
	
	public String uploadImage(ImageRequest request);
	
	public String viewImage(String id, DemoRequest request);

}
