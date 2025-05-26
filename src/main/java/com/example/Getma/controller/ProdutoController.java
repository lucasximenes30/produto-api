package com.example.Getma.controller;


import com.example.Getma.model.Produto;
import com.example.Getma.repository.ProdutoRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto salvo com sucesso!");
        System.out.println(produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }
    @GetMapping("{id}")
    public Produto salvarPorId(@PathVariable String id){
        return produtoRepository.findById(id).orElse(null);

    }
    @DeleteMapping("{id}")
    public void deletar(@PathVariable String id){
        produtoRepository.deleteById(id);

    }
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto ){
        produto.setId(id);
        produtoRepository.save(produto);
    }
    @GetMapping
    public List <Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }


}
