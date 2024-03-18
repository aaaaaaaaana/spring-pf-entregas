package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {
    @Autowired
    PessoaRepository repo;

    @GetMapping
    public List<Pessoa> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa fincById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Pessoa save(@RequestBody Pessoa p){
        p.setId(null);
        return repo.save(p);
    }

}
