package br.com.projetopoo.model;

import java.util.ArrayList;
import br.com.projetopoo.controller.Controller;

public class Sinonimo {
  private ArrayList<String> nome;
  private int grupo;
  private Enum nivel;
  
   public Sinonimo(){
      super();
  }
  
  public Sinonimo(int g, Enum n){
      this.grupo=g;
      this.nivel=n;
  }
  
    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public Enum getNivel() {
        return nivel;
    }

    public void setNivel(Enum nivel) {
        this.nivel = nivel;
    }
    public void pegarSinonimos(){
        Controller control = new Controller(this.getNivel(), this.getGrupo());
        ArrayList<String> array = new ArrayList();
        array = control.pegarSinonimos();
        if(array == null){
            this.nome = null;
        }else{
            this.nome = array;
        }
    }
    public ArrayList<String> getNome() {
        return nome;
    }

    private void setNome(String nome) {
        
    }
}
