package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="TB_VIAGEM")
public class Viagem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_VIAGEM")
	@SequenceGenerator(
			name = "SQ_VIAGEM",
			sequenceName = "SQ_VIAGEM",
			allocationSize = 1
	)
	@Column(name = "ID_VIAGEM")
	private Long id;

	@Column(name = "SAIDA")
	private LocalDateTime saida;

	@Column(name = "CHEGADA")
	private LocalDateTime chegada;

	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
			name = "PESSOA",
			referencedColumnName = "ID_PESSOA",
			foreignKey = @ForeignKey(
					name = "FK_PESSOA_CLIENTE"
			)
	)
	private Pessoa cliente;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "ENDERECO_DESTINO",
			referencedColumnName = "ID_ENDERECO",
			foreignKey = @ForeignKey(
					name = "FK_DESTINO_ENDERECO"
			)
	)
	private Endereco destino;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
			name = "ENDERECO_ORIGEM",
			referencedColumnName = "ID_ENDERECO",
			foreignKey = @ForeignKey(
					name = "FK_ORIGEM_ENDERECO"
			)
	)
	private Endereco origem;

	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "TB_VIAGEM_PASSAGEIRO",
			joinColumns = {
					@JoinColumn(
							name = "VIAGEM",
							referencedColumnName = "ID_VIAGEM",
							foreignKey = @ForeignKey(
									name = "FK_VOO_DO_PASSAGEIRO"
							)
					)
			},
			inverseJoinColumns = {
					@JoinColumn(
							name = "PASSAGEIRO",
							referencedColumnName = "ID_PASSAGEIRO",
							foreignKey = @ForeignKey(
									name = "FK_PASSAGEIRO_DO_VOO"
							)
					)
			}
	)
	private Set<Passageiro> passageiros = new LinkedHashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "TB_VIAGEM_PRODUTO",
			joinColumns = {
					@JoinColumn(
							name = "VIAGEM",
							referencedColumnName = "ID_VIAGEM",
							foreignKey = @ForeignKey(
									name = "FK_VOO_DO_PRODUTO"
							)
					)
			},
			inverseJoinColumns = {
					@JoinColumn(
							name = "PRODUTO",
							referencedColumnName = "ID_PRODUTO",
							foreignKey = @ForeignKey(
									name = "FK_PRODUTO_DO_VOO"
							)
					)
			}
	)
	private List<Produto> produtos = new ArrayList<>();


}
