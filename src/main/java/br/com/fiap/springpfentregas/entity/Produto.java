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
@Table(name="TB_PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_PRODUTO")
	@SequenceGenerator(name="SQ_PRODUTO",sequenceName="SQ_PRODUTO",allocationSize=1)
	@Column(name="ID_PRODUTO")
	private Long id;

	@Column(name="ETIQUETA")
	private String etiqueta;

	@Column(name="NM_PRODUTO")
	private String nome;

	@Column(name="PESO")
	private Float peso;

	@Column(name="LARGURA")
	private Float largura;

	@Column(name="ALTURA")
	private Float altura;

	@Column(name="PROFUNDIDADE")
	private Float profundidade;

}
