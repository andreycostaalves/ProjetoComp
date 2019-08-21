package com.andreyalves.projetofullstack;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andreyalves.projetofullstack.domian.Categoria;
import com.andreyalves.projetofullstack.domian.Cidade;
import com.andreyalves.projetofullstack.domian.Cliente;
import com.andreyalves.projetofullstack.domian.Endereco;
import com.andreyalves.projetofullstack.domian.Estado;
import com.andreyalves.projetofullstack.domian.Produto;
import com.andreyalves.projetofullstack.domian.enums.TipoCliente;
import com.andreyalves.projetofullstack.repositories.CategoriaRepository;
import com.andreyalves.projetofullstack.repositories.CidadeRepository;
import com.andreyalves.projetofullstack.repositories.ClienteRepository;
import com.andreyalves.projetofullstack.repositories.EnderecoRepository;
import com.andreyalves.projetofullstack.repositories.EstadoRepository;
import com.andreyalves.projetofullstack.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetofullstackApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRespository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetofullstackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRespository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "38754378609" , TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("3222888", "9893888"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300" , "apto 300", "Jardim", "03399933", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Mattos", "105", "Sala 300", "Centro" , "12345678", cli1 , c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		
	}

}
