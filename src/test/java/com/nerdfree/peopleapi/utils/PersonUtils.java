package com.nerdfree.peopleapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.nerdfree.peopleapi.model.Person;

public class PersonUtils {
	
	private static final String FIRST_NAME = "Jayneanderson";
	private static final String LAST_NAME = "Santos";
	private static final String CPF_NUMBER = "10907926894";
	private static final long PERSON_ID = 1L;
	private static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 03);
	
	public static Person criarPessoaFake() {
		return Person.builder()
				.id(PERSON_ID)
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE.toString())
				.phones(Collections.singletonList(PhoneUtils.criarTelefoneFake()))
				.build();
	}
}
