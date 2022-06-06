package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.PortariaDAOImpl;
import br.com.fiap.jpa.entity.Portaria;
import br.com.fiap.jpa.service.GenericService;

public class PortariaServiceImpl extends GenericService<Portaria, Long>{

    private static PortariaServiceImpl instance = null;

    private PortariaDAOImpl portariaDAO;

    private PortariaServiceImpl() {
        this.portariaDAO = PortariaDAOImpl.getInstance();
    }

    public static PortariaServiceImpl getInstance() {

        if (instance == null) {
            instance = new PortariaServiceImpl();
        }

        return instance;
    }

	@Override
	public void cadastrar(Portaria instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Portaria instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Portaria obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Portaria> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
