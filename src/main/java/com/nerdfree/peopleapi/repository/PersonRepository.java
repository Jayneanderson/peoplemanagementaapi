package com.nerdfree.peopleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nerdfree.peopleapi.model.Person;
													  //Generics do tipo de dado
public interface PersonRepository extends JpaRepository<Person, Long>{

}
