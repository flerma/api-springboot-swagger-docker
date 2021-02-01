package br.com.customer.api.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResumoOrcamento {
	
	private Long codigo;
	private String cliente;
	private LocalDate dataAgendamento;
	private String tipoServico;
	private BigDecimal valor;
	private String descricaoStatusOrcamento;

}
