package br.unipar.programacaointernet.servicecep.apivenda.repository;

import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import br.unipar.programacaointernet.servicecep.apivenda.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class VendaRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Venda> listar(){
        String jpql = "SELECT V FROM Venda V";
        return em.createQuery(jpql, Venda.class).getResultList();
    }

    public Venda buscarPorID(Integer id){
        return em.find(Venda.class, id);
    }
    public void cadastrar(Venda venda) throws Exception{
        try {
            em.persist(venda);
        }catch (Exception ex){
            throw new Exception("Venda não pode ser cadastrada");
        }
    }

    public void atualizar(Venda venda) throws Exception {
        try {
            em.merge(venda);
        } catch (Exception ex) {
            throw new Exception("Venda não pode ser atualizada");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
             Venda venda= em.find(Venda.class, id);
            em.remove(venda);
        } catch (Exception ex) {
            throw new Exception("Venda não pode ser deletada");
        }
    }
}
