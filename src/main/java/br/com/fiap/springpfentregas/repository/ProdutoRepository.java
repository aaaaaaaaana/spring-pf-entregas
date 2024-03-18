package br.com.fiap.springpfentregas.repository;

import br.com.fiap.springpfentregas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
