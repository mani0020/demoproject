package com.syf.demoproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.syf.demoproject.dao.DemoRepository;
import com.syf.demoproject.entity.ImageEntity;
import com.syf.demoproject.entity.UserEntity;
import com.syf.demoproject.model.DemoRequest;
import com.syf.demoproject.model.ImageRequest;
import com.syf.demoproject.service.DemoService;

@Component
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	DemoRepository repository;
	
	@Override
	public void save(DemoRequest request) {
		
		UserEntity entity = new UserEntity();
		entity.setGender(request.getGender());
		request.setPassword(request.getPassword());
		request.setUserName(request.getUserName());
		entity.setId(request.getUserId());
		repository.save(entity);
		
	}
	
	@Override
	public DemoRequest getUserData(String id){
		UserEntity entity = repository.findById(id).orElse(null);
		
		DemoRequest response = new DemoRequest();
		response.setGender(entity.getGender());
		response.setPassword(entity.getPassword());
		response.setUserName(entity.getUserName());
		
		return response;
	}
	
	
	// upload a image to imugur
	@Override
	public String uploadImage(ImageRequest request) {
		
		String userName = request.getUser().getUserName();
		String pwd = request.getUser().getPassword();
		
		//Validate the user
		int count = repository.count(userName, pwd);
		
		if (count == 1) {
			// code for upload else it wont upload since authentication fails.
			//imugur url
			String imugurUrl = "https://imgur.com";
			HttpEntity httpEntity = new HttpEntity(request.getImageDetails(),null);
			RestTemplate rest = new RestTemplate();
			ResponseEntity<String> response = null;
			response = rest.exchange(imugurUrl,HttpMethod.POST,httpEntity,String.class);
			
			//saving image details in table
			
			List<ImageEntity> imagesList = new ArrayList<ImageEntity>();
			ImageEntity entity = new ImageEntity();
			entity.setHeight(request.getImageDetails().getHeight());
			entity.setImageId(request.getImageDetails().getImageId());
			entity.setInGallery(request.getImageDetails().getInGallery());
			entity.setLink(request.getImageDetails().getLink());
			entity.setName(request.getImageDetails().getName());
			entity.setSize(request.getImageDetails().getSize());
			entity.setTypr(request.getImageDetails().getTypr());
			entity.setWidth(request.getImageDetails().getWidth());
			imagesList.add(entity);
			UserEntity userEntity = new UserEntity();
			userEntity.setImages(imagesList);
			repository.save(userEntity);
			
			
			return "image uploaded succesfully";
		}
		
		
		return "authenticating a user fails";
		
		
	}
	
	
	// view a image from imugur
	@Override
	public String viewImage(String  id, DemoRequest request) {
		
		String userName = request.getUserName();
		String pwd = request.getPassword();
		
		//validating a user to view images for a particular user
		
		int count = repository.count(userName, pwd);
		
		if(count == 1) {
			// jpa query for retrieving images for a particular user
			List<ImageEntity> imageEntityList = repository.getImages(userName);
			// https://api.imgur.com/3/image/{{imageHash}}
			String imugurUrl = "https://imgur.com/image";
			for(ImageEntity ent : imageEntityList) {
				String imageId = ent.getImageId();
				String url = imugurUrl+imageId;
				RestTemplate rest = new RestTemplate();
				String response = rest.getForObject(url, String.class);
				
			}
			
			
			return "images are viewed by user successfully";
		}
		return "authenticating a user fails";
	}

}
