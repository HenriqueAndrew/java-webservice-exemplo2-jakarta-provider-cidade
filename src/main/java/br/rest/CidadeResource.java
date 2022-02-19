/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rest;

import br.data.crud.CrudCidade;
import br.data.model.Cidade;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author alexandrelerario
 */
@Path("cidade")
@RequestScoped
public class CidadeResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CidadeResource
     */
    public CidadeResource() {
    }

    /**
     * Retrieves representation of an instance of br.rest.CidadeResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cidade> getJson() {
        //TODO return proper representation object
        
        return new CrudCidade().getAll();
    }

    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade getCidade(@PathParam("id") int cod) {
        //TODO return proper representation object
        
        return new CrudCidade().getCidade(cod);
    }
    
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int cod) {
        //TODO return proper representation object
        
         new CrudCidade().Remove(cod);
    }
    
    
    /**
     * PUT method for updating or creating an instance of CidadeResource
     * @param codigo
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{codigo}/{nome}")
    public void putJson(@PathParam("codigo") int codigo, @PathParam("nome") String nome) {
        Cidade cid = new Cidade(codigo, nome);
        new br.data.crud.CrudCidade().create(cid);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        ObjectMapper om = new ObjectMapper();
        try{
            Cidade cid =  om.readValue(content, Cidade.class);
            new br.data.crud.CrudCidade().create(cid);
        }catch(Exception e){
            System.out.println("erro: " + e.getMessage());
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public void merge(String content) {
        ObjectMapper om = new ObjectMapper();
        try{
            Cidade cid =  om.readValue(content, Cidade.class);
            new br.data.crud.CrudCidade().merge(cid);
        }catch(Exception e){
            System.out.println("erro: " + e.getMessage());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/xml")
    public ArrayList<Cidade> getXmlCidades(){
        return new CrudCidade().getAll();
    }
    
    
}
