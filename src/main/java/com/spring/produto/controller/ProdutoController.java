package com.spring.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.produto.modal.Produto;
import com.spring.produto.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	  @Autowired
	  ProdutoRepository produtoRepository;
	  
	  
	  @PostMapping
	  public Produto inserir(@RequestBody Produto produto) {
		  produtoRepository.inserir(produto);
		  return produto;
	  }
	  
	  @GetMapping
	  public List<Produto> buscar(){
		return produtoRepository.buscarTodos();
	  }
	  
	  @GetMapping("/{id}")
	  public Produto buscarPorId(@PathVariable int id) {
		return produtoRepository.buscarPorId(id);
	  }
	  
	  @PutMapping("/{id}")
	  public Produto alterar(@RequestBody Produto produto, @PathVariable int id) {
		   produtoRepository.alterar(id, produto);
		   return produto;
	  }
	  
	  @DeleteMapping("/{id}")
	  public int removerPorId(@PathVariable int id) {
		  produtoRepository.removerPorId(id);
		  return id;
	  }
	 

}
