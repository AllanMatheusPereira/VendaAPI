package br.unipar.programacaointernet.servicecep.apivenda.controller;

import br.unipar.programacaointernet.servicecep.apivenda.model.Venda;
import br.unipar.programacaointernet.servicecep.apivenda.service.ProdutoService;
import br.unipar.programacaointernet.servicecep.apivenda.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Venda")
public class VendaController {

    @Inject
    private VendaService vendaService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarVendas(){return Response.ok(vendaService.listar()).build();}

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarVendas(Venda venda){
        try{
            vendaService.cadastrar(venda);
            return Response.status(201).entity("Venda registrada com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizarVenda(Venda venda) {
        try {
            vendaService.atualizar(venda);
            return Response.status(201).entity("Venda atualizada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarVenda(Venda venda){
        try {
            vendaService.deletar(venda);
            return Response.status(201).entity("Venda deletada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
