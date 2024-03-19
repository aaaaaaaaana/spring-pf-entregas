package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository repo;

    @GetMapping
    public List<Pessoa> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Pessoa save(@RequestBody Pessoa p){
        if(Objects.isNull(p)) return null;
        p.setId(null);

        return repo.save(p);
    }

}
