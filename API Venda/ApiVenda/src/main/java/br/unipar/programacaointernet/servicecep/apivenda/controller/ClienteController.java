package br.unipar.programacaointernet.servicecep.apivenda.controller;

import br.unipar.programacaointernet.servicecep.apivenda.model.Cliente;
import br.unipar.programacaointernet.servicecep.apivenda.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Cliente")
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarClientes(){return Response.ok(clienteService.listar()).build();}

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(Cliente cliente){
        try{
            clienteService.cadastrar(cliente);
            return Response.status(201).entity("Cliente cadatrado com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizarCliente(Cliente cliente) {
        try {
            clienteService.atualizar(cliente);
            return Response.status(201).entity("Cliente atualizado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarCliente(Cliente cliente){
        try {
            clienteService.deletar(cliente);
            return Response.status(201).entity("Cliente deletado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

}
