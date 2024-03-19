package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {


    @Autowired
    private ProdutoRepository repo;

    @GetMapping
    public List<Produto> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Produto save(@RequestBody Produto p){
        if(Objects.isNull(p)) return null;
        p.setId(null);

        return repo.save(p);
    }

}
