package br.unipar.programacaointernet.servicecep.apivenda.repository;

import br.unipar.programacaointernet.servicecep.apivenda.model.Cliente;
import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ClienteRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Cliente> listar(){
        String jpql = "SELECT C FROM Cliente C";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente buscarPorID(Integer id){
        return em.find(Cliente.class, id);
    }
    public void cadastrar(Cliente cliente) throws Exception{
        try {
            em.persist(cliente);
        }catch (Exception ex){
            throw new Exception("Cliente não pode ser cadastrado");
        }
    }

    public void atualizar(Cliente cliente) throws Exception {
        try {
            em.merge(cliente);
        } catch (Exception ex) {
            throw new Exception("Cliente não pode ser atualizado");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
            Cliente cliente = em.find(Cliente.class, id);
            em.remove(cliente);
        } catch (Exception ex) {
            throw new Exception("Cliente não pode ser deletado");
        }
    }
}
