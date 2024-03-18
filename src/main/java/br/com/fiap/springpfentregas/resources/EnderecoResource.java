package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    EnderecoRepository repo;

    @GetMapping
    public List<Endereco> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/cep/{cep}")
    public Endereco findById(@PathVariable String cep){
        return repo.findById( cep ).orElseThrow();
    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public Endereco findAllById(@PathVariable String idPessoa){
        return repo.findById( idPessoa ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Endereco save(@RequestBody Endereco e) {
        e.setId(null);
        return repo.save( e );
    }

}
