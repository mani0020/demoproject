package com.syf.demoproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.syf.demoproject.entity.ImageEntity;
import com.syf.demoproject.entity.UserEntity;

@Repository
public interface DemoRepository extends JpaRepository<UserEntity, String>{
	
	
	@Query("SELECT count(*) FROM User u WHERE u.userName = ?uname and u.password = ?upwd")
	public int count(String uname, String upwd);
	
	@Query("SELECT * FROM image i JOIN user u  WHERE u.userId = ?userId")
	List<ImageEntity> getImages(String userId);

}
