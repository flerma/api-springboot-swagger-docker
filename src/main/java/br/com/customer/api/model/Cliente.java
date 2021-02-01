package br.com.customer.api.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private long codigo;
	
	@NotNull
	@Column(name="NOME")
	private String nome;

	@Embedded
	private Endereco endereco;

	@NotNull
	@Column(name="ATIVO")
	private Boolean ativo;
	
}
