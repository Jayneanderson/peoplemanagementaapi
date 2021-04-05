package com.nerdfree.peopleapi.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nerdfree.peopleapi.exception.PersonNotFoundException;
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
	
//	@Test
//	public void testAoSalvarUmaPessoaRetorneMessagemSucesso() {
//		final Person pessoaEsperada = PersonUtils.criarPessoaFake();
//		
//		//ao chamar o método save, então retorne um objeto
//		Mockito.when(personRepository.save(pessoaEsperada)).thenReturn(pessoaEsperada);
//		
//		final String messagemEsperada = "Pessoa salva com ID: " + pessoaEsperada.getId();
//		
//		final String message = personService.savePerson(pessoaEsperada);
//		
//		assertEquals(messagemEsperada, message);
//	}
//	
//	@Test
//	public void testAoPassarIdValidoPessoaRetorneEstaPessoa() throws PersonNotFoundException {
//		
//		final Person pessoaEsperada = PersonUtils.criarPessoaFake();
//
//		Mockito.when(personRepository.findById(pessoaEsperada.getId())).thenReturn(Optional.of(pessoaEsperada));
//		Person pessoaAtual = personService.findPersonById(pessoaEsperada.getId());
//				
//		Assertions.assertEquals(pessoaEsperada, pessoaAtual);
//		Assertions.assertEquals(pessoaEsperada.getFirstName(), pessoaAtual.getFirstName());
//		Assertions.assertEquals(pessoaEsperada.getLastName(), pessoaAtual.getLastName());
//		
//	}
//	
////	@Test
////	public void testAoPassarIdInvalidoPessoaLanceExcecao() {
////		long invalidId = 1L;
////		
////		Mockito.when(personRepository.findById(invalidId))
////			.thenReturn(Optional.ofNullable((Optional.class)));
////		Assertions.assertThrows(PersonNotFoundException.class, () -> personService.findPersonById(invalidId));
////	}
//	
//	@Test
//	public void testAoNaoPassarDadosRetorneTodasPessoasRegistradas() {
//		
//		List<Person> listaEsperadaDePessoas = Collections.singletonList(PersonUtils.criarPessoaFake());
//		
//		System.out.println(personRepository.findAll());
//		Mockito.when(personRepository.findAll()).thenReturn(listaEsperadaDePessoas);
//		System.out.println(listaEsperadaDePessoas);
//	}
}
