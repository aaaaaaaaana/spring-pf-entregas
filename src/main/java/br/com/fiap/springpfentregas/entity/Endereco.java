package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="TB_ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SQ_ENDERECO")
	@SequenceGenerator(name="SQ_ENDERECO",sequenceName="SQ_ENDERECO",allocationSize=1)
	@Column(name="ID_ENDERECO")
	private Long id;

	@Column(name="CEP")
	private String cep;

	@Column(name="NUMERO")
	private String numero;

	@Column(name="COMPLEMENTO")
	private String complemento;

	@Column(name="FK_ENDERECO_PESSOA") //CHAVE ESTRANGEIRA
	private Pessoa pessoa;

}
