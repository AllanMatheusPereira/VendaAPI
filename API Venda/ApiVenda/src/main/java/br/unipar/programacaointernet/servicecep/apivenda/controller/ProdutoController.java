package br.unipar.programacaointernet.servicecep.apivenda.controller;

import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import br.unipar.programacaointernet.servicecep.apivenda.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Produto")
public class ProdutoController {

    @Inject
    private ProdutoService produtoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarProdutos(){return Response.ok(produtoService.listar()).build();}

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarProduto(Produto produto){
        try{
            produtoService.cadastrar(produto);
            return Response.status(201).entity("Produto cadastrado com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizarProduto(Produto produto) {
        try {
            produtoService.atualizar(produto);
            return Response.status(201).entity("Produto atualizado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarProduto(Produto produto){
        try {
            produtoService.deletar(produto);
            return Response.status(201).entity("Produto deletado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
