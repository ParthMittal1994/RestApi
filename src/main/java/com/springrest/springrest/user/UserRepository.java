package com.springrest.springrest.user;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer>,JpaSpecificationExecutor<User>{
	
	public  List<User> findByName(String name);
		
	}
