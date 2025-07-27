package depaiva.produtosapi.controller;

import depaiva.produtosapi.model.Produto;
import depaiva.produtosapi.repository.ProdutoRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"produtos"})
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto.toString());
        String id = UUID.randomUUID().toString();
        produto.setId(id);
        this.produtoRepository.save(produto);
        return produto;
    }

    @GetMapping({"/{id}"})
    public Produto obterPorId(@PathVariable("id") String id) {
        return (Produto)this.produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping({"{id}"})
    public void deletar(@PathVariable("id") String id) {
        this.produtoRepository.deleteById(id);
    }

    @PutMapping({"{id}"})
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);
        this.produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome) {
        return this.produtoRepository.findByNome(nome);
    }
}
