package com.nerdfree.peopleapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.nerdfree.peopleapi.model.Person;
import com.nerdfree.peopleapi.repository.PersonRepository;

@Service //significa que o Spring irá tratar uma classe de serviço (regras de negócio)
public class PersonService{
	
private PersonRepository personRepository;
	
	@Autowired //Spring, injeta uma implementação do contrato do personRepository aqui para mim
	public PersonService(PersonRepository personRepository) {//dentro do construtor facilita na criação de testes unitários
		this.personRepository = personRepository;
	}	
	
	@PostMapping("/addperson")
	public String createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return "Pessoa salva com ID: " + savedPerson.getId();
	}

	public List<Person> getAllPeople() {
		return personRepository.findAll();
	}
	
}
