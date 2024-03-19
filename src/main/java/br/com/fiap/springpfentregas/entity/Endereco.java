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
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_ENDERECO")
	@SequenceGenerator(
			name = "SQ_ENDERECO",
			sequenceName = "SQ_ENDERECO",
			allocationSize = 1
	)
	@Column(name = "ID_ENDERECO")
	private Long id;

	@Column(name = "CEP")
	private String cep;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
			name = "PESSOA",
			referencedColumnName = "ID_PESSOA",
			foreignKey = @ForeignKey(
					name = "FK_PESSOA_ENDERECO"
			)
	)
	private Pessoa pessoa;

}
