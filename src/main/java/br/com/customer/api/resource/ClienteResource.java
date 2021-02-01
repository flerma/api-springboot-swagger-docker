package br.com.customer.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.customer.api.model.Cliente;
import br.com.customer.api.service.ClienteService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Cadastro e consulta de clientes")
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> pesquisar() {
		return ResponseEntity.ok().body(clienteService.pesquisar());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(clienteService.buscarPorCodigo(codigo));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> incluir(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		
		Cliente clienteSalvo = clienteService.incluir(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(clienteSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(clienteSalvo);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.atualizar(cliente);
		return ResponseEntity.ok().body(clienteSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long codigo) {
		clienteService.excluir(codigo);
	}

	
}
