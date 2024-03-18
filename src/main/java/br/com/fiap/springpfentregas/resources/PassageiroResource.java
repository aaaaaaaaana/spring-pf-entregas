package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.repository.PassageiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {
    @Autowired
    PassageiroRepository repo;

    @GetMapping
    public List<Passageiro> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Passageiro fincById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Passageiro save(@RequestBody Passageiro p){
        p.setId(null);
        return repo.save(p);
    }

}
