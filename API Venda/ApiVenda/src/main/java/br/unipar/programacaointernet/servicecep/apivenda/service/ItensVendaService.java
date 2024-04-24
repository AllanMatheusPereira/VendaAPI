package br.unipar.programacaointernet.servicecep.apivenda.service;

import br.unipar.programacaointernet.servicecep.apivenda.model.ItensVenda;
import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import br.unipar.programacaointernet.servicecep.apivenda.repository.ItensVendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ItensVendaService {

    @Inject
    private ItensVendaRepository itensVendaRepository;

    public List<ItensVenda> listar(){return itensVendaRepository.listar();}

    public ItensVenda buscarPorID(Integer id){
        return itensVendaRepository.buscarPorID(id);
    }
    public void cadastrar(ItensVenda itensVenda) throws Exception{
        itensVendaRepository.cadastrar(itensVenda);
    }

    public void atualizar(ItensVenda itensVenda) throws Exception{
        itensVendaRepository.atualizar(itensVenda);
    }

    public void deletar(ItensVenda itensVenda) throws Exception{
        deletar(itensVenda.getId());
    }
    private void deletar(Integer id) throws Exception {
        try {
            itensVendaRepository.deletar(id);
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar item: " + ex.getMessage());
        }
    }
}
