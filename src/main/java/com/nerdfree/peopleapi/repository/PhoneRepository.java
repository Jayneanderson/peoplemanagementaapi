package com.nerdfree.peopleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nerdfree.peopleapi.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
