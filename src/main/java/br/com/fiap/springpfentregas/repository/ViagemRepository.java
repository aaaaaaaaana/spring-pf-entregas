package br.com.fiap.springpfentregas.repository;

import br.com.fiap.springpfentregas.entity.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagemRepository extends JpaRepository<Viagem,Long> {
}
