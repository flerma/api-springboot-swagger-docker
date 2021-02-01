package br.com.customer.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.customer.api.model.Cliente;
import br.com.customer.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> pesquisar() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorCodigo(Long codigo) {
		return clienteRepository.findById(codigo).get();
	}
	
	public Cliente incluir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente atualizar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long codigo) {
		clienteRepository.deleteById(codigo);
	}
}
