package br.unipar.programacaointernet.servicecep.apivenda.service;

import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import br.unipar.programacaointernet.servicecep.apivenda.repository.ProdutoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ProdutoService {

    @Inject
    private ProdutoRepository produtoRepository;

    public List<Produto> listar(){return produtoRepository.listar();}

    public  Produto buscarPorID(Integer id){
        return produtoRepository.buscarPorID(id);
    }

    public void cadastrar(Produto produto) throws Exception{
        produtoRepository.cadastrar(produto);
    }

    public void atualizar(Produto produto) throws Exception{
        produtoRepository.atualizar(produto);
    }

    public void deletar(Produto produto) throws Exception{
        deletar(produto.getId());
    }
    private void deletar(Integer id) throws Exception {
        try {
            produtoRepository.deletar(id);
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar produto: " + ex.getMessage());
        }
    }
}
