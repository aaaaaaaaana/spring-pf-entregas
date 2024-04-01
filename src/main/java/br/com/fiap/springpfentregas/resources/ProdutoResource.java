package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.dto.request.ProdutoRequest;
import br.com.fiap.springpfentregas.dto.response.ProdutoResponse;
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
    public List<ProdutoRequest> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public ProdutoResponse findById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @Transactional
    @PostMapping
    public ProdutoResponse save(@RequestBody ProdutoResponse produto){

        if(Objects.isNull(produto)) return null;
        produto.setId(null);

        // Podemos gerar aleatoriamente uma etiqueta.

        return repo.save( produto );
    }

}
