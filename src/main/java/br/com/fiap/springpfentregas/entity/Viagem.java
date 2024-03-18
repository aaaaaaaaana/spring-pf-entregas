package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="TB_VIAGEM")
public class Viagem {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SQ_VIAGEM")
	@SequenceGenerator(name="SQ_VIAGEM",sequenceName="SQ_VIAGEM",allocationSize=1)
	@Column(name="ID_VIAGEM")
	private Long id;

	@Column(name = "SAIDA")
	private LocalDateTime saida;

	@Column(name = "CHEGADA")
	private LocalDateTime chegada;

	@Column(name = "FK_VIAGEM_CLIENTE") // CHAVE ESTRANGEIRA
	private Pessoa cliente;

	@Column(name = "FK_VIAGEM_DESTINO") //CHAVE ESTRANGEIRA
	private Endereco destino;

	@Column(name = "FK_VIAGEM_ORIGEM") //CHAVE ESTRANGEIRA
	private Endereco origem;


	@Column(name = "FK_VIAGEM_PASSAAGEIRO") // CHAVE ESTRANGEIRA
	private Set<Passageiro> passageiros = new LinkedHashSet<>();

	@Column(name = "FK_VIAGEM_PRODUTO") // CHAVE ESTRANGEIRA
	private Set<Produto> produtos = new LinkedHashSet<>();


}
