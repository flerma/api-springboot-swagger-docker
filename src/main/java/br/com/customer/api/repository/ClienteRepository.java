package br.com.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.customer.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
}
