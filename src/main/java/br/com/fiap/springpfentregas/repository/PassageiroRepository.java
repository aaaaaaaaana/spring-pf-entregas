package br.com.fiap.springpfentregas.repository;

import br.com.fiap.springpfentregas.entity.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
}
