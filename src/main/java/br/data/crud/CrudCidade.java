/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.model.Cidade;
import java.util.ArrayList;

/**
 *
 * @author alexandrelerario
 */
public class CrudCidade {
    private static ArrayList<Cidade> lcidade = new ArrayList();

   // public CrudCidade() {
   //     lcidade.add(new Cidade(1, "Assis"));
   //     lcidade.add(new Cidade(2, "Sao Paulo"));
   // }
    
    
    
    public void create(Cidade cidade){
        lcidade.add(cidade);
    }
    
     public void merge(Cidade cidade){
        Cidade cid = getCidade(cidade.getCodigo());
        cid.setNome(cidade.getNome());
       
    }
    
    public ArrayList<Cidade> getAll(){
        return lcidade;
    }
    
    public Cidade getCidade(int codigo){
        boolean achou=false;
        for (Cidade cidade : lcidade) {
            if(cidade.getCodigo()==codigo){
                achou=true;
                return cidade;
            }
        }
        if(!achou){
            return null;
        }
        return null;
    }
    
    public void Remove(int codigo){
        Cidade cid = getCidade(codigo);
        if(cid!=null){
            lcidade.remove(cid);
        }
    }
}
