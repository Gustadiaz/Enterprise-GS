package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.CondominioDAOImpl;
import br.com.fiap.jpa.entity.Condominio;
import br.com.fiap.jpa.service.GenericService;

public class CondominioServiceImpl extends GenericService<Condominio, Long>{

    private static CondominioServiceImpl instance = null;

    private CondominioDAOImpl condominioDAO;

    private CondominioServiceImpl() {
        this.condominioDAO = CondominioDAOImpl.getInstance();
    }

    public static CondominioServiceImpl getInstance() {

        if (instance == null) {
            instance = new CondominioServiceImpl();
        }

        return instance;
    }

    @Override
    public void cadastrar(Condominio instance) {
        try {
            condominioDAO.salvar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Condominio instance) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remover(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Condominio obter(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Condominio> listar() {
        // TODO Auto-generated method stub
        return null;
    }

	
}


