package com.example.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciossb.model.entities.Produto;
import com.example.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired//interface para persistecia 
	private ProdutoRepository produtoRepository;
	
				                     					//@valid importa de validation e garante que
	             										//minhas notações estejam conforme as regras
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	public Iterable<Produto>obterProdutos(){
		return produtoRepository.findAll();
					
	}
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Produto>obterProdutoPorNome(@PathVariable String parteNome){
		//return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
		return produtoRepository.searchByNameLike(parteNome);
	}
		
	//consulta paginada
	@GetMapping(path = "/pagina/{numeroPagina}/{qntdPagina}")
	public Iterable<Produto> obterProdutosPorPagina(
			@PathVariable int numeroPagina, @PathVariable int qntdPagina) {
		if(qntdPagina >= 5) qntdPagina = 5;	
		Pageable page = PageRequest.of(numeroPagina , qntdPagina);
		return produtoRepository.findAll(page);
		
	}
	@GetMapping(path="/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
/*	@PutMapping //Put é usado para alterar o produto... seja 1 atributo apenas ou todos	
	
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
    } 
    USEI O METODO PUT JUNTO COM O METODO POST NA MESMA FUNÇÃO = LINHA 27  */	
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable int id) {
		 produtoRepository.deleteById(id);
	}
}
