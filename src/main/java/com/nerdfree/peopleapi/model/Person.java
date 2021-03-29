package com.nerdfree.peopleapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder //traz um padrão de projeto para construir objetos
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank
	@Length(min = 2, max = 45, message = "O nome deve estar entre 2 - 45") //pode usar size tbm, mas length é mais genérico
	private String firstName;
	
	@Column(nullable = false)
	@Length(min = 2, max = 45, message = "O sobrenome deve estar entre 2 - 45") //pode usar size tbm, mas length é mais genérico
	private String lastName;
	
	@Column(nullable = false, unique = true)
	@CPF
	private String cpf;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private String birthDate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Valid //serve para indicar que cada telefone passado será validado
	private List<Phone> phones;
}
