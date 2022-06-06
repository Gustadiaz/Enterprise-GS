package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.jpa.entity.Condominio;
import br.com.fiap.jpa.entity.FuncPortaria;
import br.com.fiap.jpa.entity.MovimentacaoPortaria;
import br.com.fiap.jpa.entity.Portaria;
import br.com.fiap.jpa.entity.Visitante;
import br.com.fiap.jpa.service.impl.CondominioServiceImpl;
import br.com.fiap.jpa.service.impl.FuncPortariaServiceImpl;
import br.com.fiap.jpa.service.impl.MovimentacaoPortariaServiceImpl;
import br.com.fiap.jpa.service.impl.PortariaServiceImpl;
import br.com.fiap.jpa.service.impl.VisitanteServiceImpl;

public class App {

	public static void main(String[] args) {
		CondominioServiceImpl condominioService = CondominioServiceImpl.getInstance();
		FuncPortariaServiceImpl funcionarioService = FuncPortariaServiceImpl.getInstance();
		PortariaServiceImpl portariaService = PortariaServiceImpl.getInstance();
		VisitanteServiceImpl visitanteService = VisitanteServiceImpl.getInstance();
		MovimentacaoPortariaServiceImpl movimentacaoService = MovimentacaoPortariaServiceImpl.getInstance();
		
		Condominio condominio1 = new Condominio(856478234, "Vila Prudente", "VL", LocalDate.of(2022, 1, 1) );
		condominioService.cadastrar(condominio1);
		
		Condominio condominio2 = new Condominio(542658756, "Brecheret", "BR", LocalDate.of(2021, 1, 1) );
		condominioService.cadastrar(condominio2);
		
		Portaria portaria1 = new Portaria(1, "Portaria Principal", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), condominio1);
        Portaria portaria2 = new Portaria(2, "Portaria de Serviço", LocalDate.of(2021, 1, 1), LocalDate.of(2024, 1, 1), condominio2);

        portariaService.cadastrar(portaria1);
        portariaService.cadastrar(portaria2);
        
        
        Visitante visitante1 = visitanteService.obter(1L);
        Visitante visitante2 = visitanteService.obter(2L);
        
        FuncPortaria funcionario1 = funcionarioService.obter(1L);
        FuncPortaria funcionario2 = funcionarioService.obter(2L);
        
        MovimentacaoPortaria movimentacao1 = new MovimentacaoPortaria("E", LocalDateTime.of(2022, 6, 1, 15, 00, 0), portaria1, funcionario1, visitante1);
        MovimentacaoPortaria movimentacao2 = new MovimentacaoPortaria("E", LocalDateTime.of(2022, 6, 1, 15, 30, 0), portaria1, funcionario1, visitante2);
        MovimentacaoPortaria movimentacao3 = new MovimentacaoPortaria("S", LocalDateTime.of(2022, 6, 1, 15, 45, 0), portaria1, funcionario2, visitante1);
        
        movimentacaoService.cadastrar(movimentacao1);
		movimentacaoService.cadastrar(movimentacao2);
		movimentacaoService.cadastrar(movimentacao3);
		
		
		movimentacaoService.listarTipo("E").forEach(System.out::println);
		movimentacaoService.listarTipo("S").forEach(System.out::println);

		visitanteService.pesquisar("j", null, null).forEach(System.out::println);
        visitanteService.pesquisar("j", "111.111.111-11", null).forEach(System.out::println);
    
		
		
	}
}
