package br.com.fiap.springpfentregas.resources;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
     private EnderecoRepository repo;

    @Autowired
    private PessoaRepository repoP;


    @GetMapping
    public List<Endereco> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/cep/{cep}")
    public List<Endereco> findById(@PathVariable String cep){
        List<Endereco> end = repo.findAll();
        List<Long> id = new ArrayList<>();
        for (Endereco obj  : end ) {
            if (obj.getCep().equals(cep)){
                id.add(obj.getId());
            }
        }
        return repo.findAllById(id);
    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public Endereco findAllById(@PathVariable Long idPessoa){
        Pessoa pessoa = repoP.findById(idPessoa).orElseThrow();
        return repo.findById(pessoa.getId()).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Endereco save(@RequestBody Endereco e) {
        if(Objects.isNull(e)) return null;
        e.setId(null);
        return repo.save( e );
    }

}
