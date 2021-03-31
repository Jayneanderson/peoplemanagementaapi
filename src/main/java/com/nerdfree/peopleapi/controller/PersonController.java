package com.nerdfree.peopleapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nerdfree.peopleapi.exception.PersonNotFoundException;
import com.nerdfree.peopleapi.model.Person;
import com.nerdfree.peopleapi.model.Phone;
import com.nerdfree.peopleapi.service.PersonService;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonService personService;
	
	@Autowired //Spring, injeta uma implementação do contrato do personRepository aqui para mim
	public PersonController(PersonService personService) {//dentro do construtor facilita na criação de testes unitários
		this.personService = personService;
	}	
	
	@GetMapping
	public List<Person> getPeople() {
		return personService.findAllPeople();
	}
	
	//a anotação @RequestBody faz entender que receberemos um objeto do tipo pessoa a partir de uma requisição
	@PostMapping("/addperson")
	public String createPerson(@RequestBody @Valid Person person) {
		return personService.savePerson(person);
	}
	
	@GetMapping("/{id}") //a propriedade é parecida com RB, pois diz que que será pego por um HTTP
	public Person getPersonById(@PathVariable("id") Long id) throws PersonNotFoundException { 
		return personService.findPersonById(id);
	}
	
	@PutMapping("/{id}")
	public String updatePerson(@PathVariable  Long id, @RequestBody Person person) throws PersonNotFoundException {	
		return personService.updateById(id, person);		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable("id")Long id) throws PersonNotFoundException {
		personService.deletPerson(id);
	}

}
