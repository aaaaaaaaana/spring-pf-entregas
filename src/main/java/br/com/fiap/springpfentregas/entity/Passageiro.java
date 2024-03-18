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
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SQ_PASSAGEIRO")
	@SequenceGenerator(name="SQ_PASSAGEIRO",sequenceName="SQ_PASSAGEIRO",allocationSize=1)
	@Column(name="ID_PASSAGEIRO")
	private Long id;

	@Column(name="FK_PASSAGEIRO_PESSOA") // CHAVE ESTRANGEIRA
	private Pessoa pessoa;

}
