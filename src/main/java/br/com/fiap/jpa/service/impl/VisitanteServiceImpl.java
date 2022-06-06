package br.com.fiap.jpa.service.impl;

import java.time.LocalDate;
import java.util.List;


import br.com.fiap.jpa.dao.impl.VisitanteDAOImpl;
import br.com.fiap.jpa.entity.Visitante;
import br.com.fiap.jpa.service.GenericService;

public class VisitanteServiceImpl extends GenericService<Visitante, Long>{

    private static VisitanteServiceImpl instance = null;

    private VisitanteDAOImpl visitanteDAO;

    private VisitanteServiceImpl() {
        this.visitanteDAO = VisitanteDAOImpl.getInstance();
    }

    public static VisitanteServiceImpl getInstance() {

        if (instance == null) {
            instance = new VisitanteServiceImpl();
        }

        return instance;
    }

	@Override
	public void cadastrar(Visitante instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Visitante instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Visitante obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visitante> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Visitante> pesquisar(String nome, String cpf, LocalDate dataCadastro) {
		List<Visitante> visitantes = null;
		
		try {
			visitantes = visitanteDAO.pesquisar(nome, cpf, dataCadastro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return visitantes;
	}

}
