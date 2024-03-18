package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {
    @Autowired
    ProdutoRepository repo;

    @GetMapping
    public List<Produto> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Produto fincById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Produto save(@RequestBody Produto p){
        p.setId(null);
        return repo.save(p);
    }

}
