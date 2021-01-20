package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;




@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
//	public List<User> findByEmailAndPassword(String u_email, String u_password);
	
	@Query(value="select * from user where u_email=:u_email and u_password=:u_password",nativeQuery=true)
	public List<User> findByU_emailAndU_password(@Param("u_email") String U_email, @Param("u_password") String U_password);
}
