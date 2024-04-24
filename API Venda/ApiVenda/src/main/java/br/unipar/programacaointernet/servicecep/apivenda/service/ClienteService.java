package br.unipar.programacaointernet.servicecep.apivenda.service;

import br.unipar.programacaointernet.servicecep.apivenda.model.Cliente;
import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import br.unipar.programacaointernet.servicecep.apivenda.repository.ClienteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public List<Cliente> listar(){return clienteRepository.listar();}

    public Cliente buscarPorID(Integer id){
        return clienteRepository.buscarPorID(id);
    }
    public void cadastrar(Cliente cliente) throws Exception{
        clienteRepository.cadastrar(cliente);
    }

    public void atualizar(Cliente cliente) throws Exception{
        clienteRepository.atualizar(cliente);
    }

    public void deletar(Cliente cliente) throws Exception{
        deletar(cliente.getId());
    }
    private void deletar(Integer id) throws Exception {
        try {
            clienteRepository.deletar(id);
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar cliente: " + ex.getMessage());
        }
    }
}
