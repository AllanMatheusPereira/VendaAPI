package br.unipar.programacaointernet.servicecep.apivenda.repository;

import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ProdutoRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Produto> listar(){
        String jpql = "SELECT P FROM Produto P";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public Produto buscarPorID(Integer id){
        return em.find(Produto.class, id);
    }

    public void cadastrar(Produto produto) throws Exception{
        try {
            em.persist(produto);
        }catch (Exception ex){
            throw new Exception("Produto não pode ser cadastrado");
        }
    }

    public void atualizar(Produto produto) throws Exception {
        try {
            em.merge(produto);
        } catch (Exception ex) {
            throw new Exception("Produto não pode ser atualizado");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
             Produto produto= em.find(Produto.class, id);
            em.remove(produto);
        } catch (Exception ex) {
            throw new Exception("Produto não pode ser deletado");
        }
    }
}
