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
@Table(name="TB_PASSAGEIRO")
public class Passageiro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_PASSAGEIRO")
	@SequenceGenerator(
			name = "SQ_PASSAGEIRO",
			sequenceName = "SQ_PASSAGEIRO",
			allocationSize = 1
	)
	@Column(name = "ID_PASSAGEIRO")
	private Long id;

	// ManyToMany = *
	// OneToOne = 1 e 1
	// ManyToOne = sem notação

	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST}) // não é OneToOne por causa do projeto. O passageiro tem que se cadastrar a cada viagem;
	@JoinColumn(
			name = "PESSOA",
			referencedColumnName = "ID_PESSOA",
			foreignKey = @ForeignKey(
					name = "FK_PASSAGEIRO_PESSOA"
			)
	)
	private Pessoa pessoa;

}
