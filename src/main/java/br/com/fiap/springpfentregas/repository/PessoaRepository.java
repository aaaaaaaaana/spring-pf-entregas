package br.com.fiap.springpfentregas.repository;

import br.com.fiap.springpfentregas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
