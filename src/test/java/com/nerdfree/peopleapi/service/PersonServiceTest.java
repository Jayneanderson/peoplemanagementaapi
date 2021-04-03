package com.nerdfree.peopleapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nerdfree.peopleapi.model.Person;
import com.nerdfree.peopleapi.repository.PersonRepository;
import com.nerdfree.peopleapi.utils.PersonUtils;

//significa que a queremos injetar nesta classe para rodar com o mockito, ou seja, criar objetos mock
//vamos gerar um fake do person repository para não testar as dependencias e afins
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	//indica que vamos criar um objeto dublê dele (fake)
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void aoCriarUmaPessoaRetorneMessagemSucesso() {
		final Person pessoaEsperada = PersonUtils.createFakeEntity();
		
		//ao chamar o método save, então retorne um objeto
		Mockito.when(personRepository.save(pessoaEsperada)).thenReturn(pessoaEsperada);
		
		final String messagemEsperada = "Pessoa salva com ID: " + pessoaEsperada.getId();
		
		final String message = personService.savePerson(pessoaEsperada);
		
		assertEquals(messagemEsperada, message);
	}
}
