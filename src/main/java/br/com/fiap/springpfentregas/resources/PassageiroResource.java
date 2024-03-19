package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.repository.PassageiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {


    @Autowired
    private PassageiroRepository repo;

    @GetMapping
    public List<Passageiro> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Passageiro findById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Passageiro save(@RequestBody Passageiro p){
        if(Objects.isNull(p)) return null;
        p.setId(null);
        return repo.save(p);
    }

}
