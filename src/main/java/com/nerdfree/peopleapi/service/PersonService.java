package com.nerdfree.peopleapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nerdfree.peopleapi.exception.PersonNotFoundException;
import com.nerdfree.peopleapi.model.Person;
import com.nerdfree.peopleapi.repository.PersonRepository;

@Service //significa que o Spring irá tratar uma classe de serviço (regras de negócio)
public class PersonService{
	
private PersonRepository personRepository;
	
	@Autowired //Spring, injeta uma implementação do contrato do personRepository aqui para mim
	public PersonService(PersonRepository personRepository) {//dentro do construtor facilita na criação de testes unitários
		this.personRepository = personRepository;
	}	
	
	public String createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return "Pessoa salva com ID: " + savedPerson.getId();
	}

	public List<Person> findAllPeople() {
		return personRepository.findAll();
	}
	
	public Person findPersonById(Long id) throws PersonNotFoundException {
//		Optional<Person> optionalPerson = personRepository.findById(id);
//		if(optionalPerson.isEmpty()) {
//			throw new PersonNotFoundException(id);
//		}
		
		//esta é uma versão resumida do código acima
		return isExists(id);
	}
	
	
	public void deletPerson(Long id) throws PersonNotFoundException {// código 200 e 204 (no content)
		isExists(id);
		personRepository.deleteById(id);
	}

	
	private Person isExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
	
}
