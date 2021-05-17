package com.springrest.springrest.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserDynamicqueryclass {

			
		@Autowired
		private UserRepository userRepo;
		
		@SuppressWarnings("serial")
		public List<User> findByCriteria(String name){
	        return userRepo.findAll(new Specification<User>() {
	            @Override
	            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	                List<Predicate> predicates = new ArrayList<>();
	                if(name!=null) {
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%"+name+"%")));
	                      
	                }
	                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	            }
	        });

	}
	}

