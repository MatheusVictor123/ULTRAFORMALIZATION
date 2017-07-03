package br.com.projetopoo.controller;

import br.com.projetopoo.model.Repositorio;
import br.com.projetopoo.model.Factory;
import static br.com.projetopoo.model.Factory.getInstance;
import br.com.projetopoo.model.RepositorioMySql;
import java.util.ArrayList;

public class Controller {
   private String palavra;
   private Enum nivel;
   private Integer grupo;
  
   
   public Controller(String c, Enum n, Integer g){
       this.palavra = c;
       this.nivel = n;
       this.grupo = g;
   }
   public Controller(String n){
       this.palavra = n;
   }
   public Controller (Enum n, Integer g){
       this.nivel=n;
       this.grupo=g;
   }
   public Integer pegarGrupo(){
       Repositorio factory = Factory.getInstance("mysql");
       Integer valor = factory.pegarGrupo(this.palavra);
       return valor;
   }
   
   public ArrayList<String> pegarSinonimos(){
       Repositorio factory = Factory.getInstance("mysql");
       ArrayList<String> array = new ArrayList();
       array = factory.pegarSinonimos(this.nivel, this.grupo);
       return array;
   }
}