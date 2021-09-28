package com.spring.produto.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.produto.modal.Produto;

@Repository
public class ProdutoRepository {
	
	private final static String INSERIR = "INSERT INTO estoque (nome,preco) VALUES (? , ?);";
	private final static String BUSCAR = "SELECT * FROM estoque;";
	private final static String BUSCAR_POR_ID = "SELECT id, nome, preco FROM estoque WHERE id = ?;";
	private final static String ALTERAR = "UPDATE estoque SET nome = ? , preco = ? WHERE id = ?;";
	private final static String DELETAR = "DELETE FROM estoque WHERE id = ?;";
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	 
	 public Produto inserir(Produto produto) {
		 try {
			 
			 Object[] parametro = {produto.getNome(),produto.getPreco()};
			 
			 jdbcTemplate.update(INSERIR,parametro);
			 
			 return produto;
			 
		 } catch (Exception e) {
			 
			 return null;
		 }
	 }
	 
	 public List<Produto> buscarTodos() {
		 try {
			 
		List<Produto> lista = jdbcTemplate.query(BUSCAR,BeanPropertyRowMapper.newInstance(Produto.class));
			 
		return lista;
			 
		 } catch (Exception e) {
			 
		return null;
			 
		 }
	 }
	 
	 public Produto buscarPorId(int id) {
		
		 Object[] parametro = {id};
		 
		 Produto result = jdbcTemplate.queryForObject(BUSCAR_POR_ID, BeanPropertyRowMapper.newInstance(Produto.class),parametro);
		 
		 return result;
		
	 }
	 
	 public int alterar(int id, Produto produto) {
		 
		 Object[] parametro = {produto.getNome(),produto.getPreco(),id};
		 
		 int result = jdbcTemplate.update(ALTERAR, parametro);
		 
		 return result;
	 }
	 
	 
	 
	 public int removerPorId(int id) {
		 try {
			 
			Object[] parametro = {id}; 
			int result = jdbcTemplate.update(DELETAR, parametro);
			
			return result;
			 
		 } catch (Exception e) {
			 
			return -1;
		 }
	 }
	 
	
	 
}
	 
	 
	 
