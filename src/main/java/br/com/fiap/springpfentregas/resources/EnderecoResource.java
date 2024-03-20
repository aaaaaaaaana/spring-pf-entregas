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
            if (Objects.nonNull(obj.getCep())){

                if (obj.getCep().equals(cep)){
                    id.add(obj.getId());
                }
            }
        }
        return repo.findAllById(id);
    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public List<Endereco> findAllById(@PathVariable Long idPessoa){
        List<Endereco> end = repo.findAll();
        List<Long> id = new ArrayList<>();
        for (Endereco obj :end){
            if (Objects.nonNull(obj.getPessoa())){
                var pes = obj.getPessoa();
                if (pes.getId().equals(idPessoa)){
                    id.add(obj.getId());
                }
            }
        }
        return repo.findAllById(id);
    }

    @Transactional
    @PostMapping
    public Endereco save(@RequestBody Endereco e) {
        if(Objects.isNull(e)) return null;

        e.setId(null);

        if (Objects.nonNull( e.getPessoa())) {
            e.setPessoa( repoP.findById(e.getPessoa().getId()).orElseThrow());
        }
        return repo.save( e );
    }

}
