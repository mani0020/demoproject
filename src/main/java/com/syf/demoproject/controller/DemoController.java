package com.syf.demoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syf.demoproject.model.DemoRequest;
import com.syf.demoproject.model.ImageRequest;
import com.syf.demoproject.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService service;
	
	// registering a user with username and password
	@PostMapping("/save/userInfo")
	public String saveUser(@RequestBody DemoRequest request) {
		
		service.save(request);
		return "User Data saved successfully";
		
	}
	
	@GetMapping("/get/userInfo")
	public DemoRequest getUserInfoByUserId(@RequestParam String id){
		
		DemoRequest response = service.getUserData(id);
		return response;
	}
	
	// upload a image in imugur
	@PostMapping("/image/upload")
	public String imageUpload(@RequestBody ImageRequest request) {
		
		String str = service.uploadImage(request);
		return str;
		
	}
	
	//view image
	@GetMapping("/image/view/id")
	public String getImage(@PathVariable String id, @RequestParam DemoRequest request) {
		
		String str = service.viewImage(id, request);
		return str;
		
	}
	
}

