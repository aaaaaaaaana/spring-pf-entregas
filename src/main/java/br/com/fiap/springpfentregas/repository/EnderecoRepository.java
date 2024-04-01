package br.com.fiap.springpfentregas.repository;

import br.com.fiap.springpfentregas.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByCep(String cep);

    List<Endereco> findByPessoaId(Long idPessoa);
}
