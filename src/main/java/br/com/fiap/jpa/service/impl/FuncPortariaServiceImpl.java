package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.FuncPortariaDAOImpl;
import br.com.fiap.jpa.entity.FuncPortaria;
import br.com.fiap.jpa.service.GenericService;

public class FuncPortariaServiceImpl extends GenericService<FuncPortaria, Long>{

    private static FuncPortariaServiceImpl instance = null;

    private FuncPortariaDAOImpl funcionarioDAO;

    private FuncPortariaServiceImpl() {
        this.funcionarioDAO = FuncPortariaDAOImpl.getInstance();
    }

    public static FuncPortariaServiceImpl getInstance() {

        if (instance == null) {
            instance = new FuncPortariaServiceImpl();
        }

        return instance;
    }

	@Override
	public void cadastrar(FuncPortaria instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(FuncPortaria instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FuncPortaria obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncPortaria> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
