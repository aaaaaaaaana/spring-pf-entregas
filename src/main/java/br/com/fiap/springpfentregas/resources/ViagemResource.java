package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Viagem;
import br.com.fiap.springpfentregas.repository.ViagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/viagem")
public class ViagemResource {
    @Autowired
    ViagemRepository repo;

    @GetMapping
    public List<Viagem> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Viagem fincById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Viagem save(@RequestBody Viagem p){
        p.setId(null);
        return repo.save(p);
    }

}
