package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.dto.request.ProdutoRequest;
import br.com.fiap.springpfentregas.dto.response.ProdutoResponse;
import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {


    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoResponse> findAll(){


        /*
        Collection<Produto> produtos = service.findAll();
        List<ProdutoResponse> respostas = new ArrayList<>();
        for (Produto p : produtos){
            respostas.add(service.toResponse(p));
        }
        return respostas;
        */

        // Isso aqui resume o que ta em cima
        return service.findAll().stream().map(service::toResponse).toList();

    }

    @GetMapping(value = "/{id}")
    public ProdutoResponse findById(@PathVariable Long id){
        /*
        Produto produto = service.findById(id);
        return  service.toResponse(produto);
        */
        return service.toResponse(service.findById(id));
    }

    @Transactional
    @PostMapping
    public ProdutoResponse save(@RequestBody ProdutoRequest produto){
        Produto save = service.save(service.toEntity(produto));
        return service.toResponse(save);
    }

}
