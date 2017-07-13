package com.reservation.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.reservation.domain.UserInfo;

@RepositoryRestResource 
public interface UserRepository extends JpaRepository<UserInfo, Integer>{
	
	

}
