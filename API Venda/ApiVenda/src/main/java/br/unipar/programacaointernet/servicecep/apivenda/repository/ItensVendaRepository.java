package br.unipar.programacaointernet.servicecep.apivenda.repository;

import br.unipar.programacaointernet.servicecep.apivenda.model.ItensVenda;
import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ItensVendaRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<ItensVenda> listar(){
        String jpql = "SELECT I FROM ItensVenda I";
        return em.createQuery(jpql, ItensVenda.class).getResultList();
    }

    public ItensVenda buscarPorID(Integer id){
        return em.find(ItensVenda.class, id);
    }

    public void cadastrar(ItensVenda itensVenda) throws Exception{
        try {
            em.persist(itensVenda);
        }catch (Exception ex){
            throw new Exception("Item não pode ser cadastrado");
        }
    }

    public void atualizar(ItensVenda itensVenda) throws Exception {
        try {
            em.merge(itensVenda);
        } catch (Exception ex) {
            throw new Exception("Item não pode ser atualizado");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
             ItensVenda itensVenda= em.find(ItensVenda.class, id);
            em.remove(itensVenda);
        } catch (Exception ex) {
            throw new Exception("Item não pode ser deletado");
        }
    }
}
