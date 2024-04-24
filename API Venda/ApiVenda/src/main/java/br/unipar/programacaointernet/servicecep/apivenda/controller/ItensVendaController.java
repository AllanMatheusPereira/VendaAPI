package br.unipar.programacaointernet.servicecep.apivenda.controller;

import br.unipar.programacaointernet.servicecep.apivenda.model.ItensVenda;
import br.unipar.programacaointernet.servicecep.apivenda.service.ItensVendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ItensVenda")
public class ItensVendaController {

    @Inject
    private ItensVendaService itensVendaService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarItensVenda(){return Response.ok(itensVendaService.listar()).build();}

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarItensVenda(ItensVenda itensVenda){
        try{
            itensVendaService.cadastrar(itensVenda);
            return Response.status(201).entity("Item cadastrado com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizarItensVenda(ItensVenda itensVenda) {
        try {
            itensVendaService.atualizar(itensVenda);
            return Response.status(201).entity("Item atualizado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarItensVenda(ItensVenda itensVenda){
        try {
            itensVendaService.deletar(itensVenda);
            return Response.status(201).entity("Item deletado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
