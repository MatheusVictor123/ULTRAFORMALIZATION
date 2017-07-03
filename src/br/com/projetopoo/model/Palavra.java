package br.com.projetopoo.model;
import java.util.ArrayList;
import java.util.HashMap;
import br.com.projetopoo.controller.Controller;

public class Palavra {
    private String conteudo;
    private Enum nivel;
    private HashMap<Enum, Sinonimo> sinonimos;

    public Palavra() {
        super();
    }
    
    public String pegarSinonimo(){
        String aux;
        ArrayList<String> auxiliar = new ArrayList();
        if(this.sinonimos == null){
            return null;
        }else{
            auxiliar = this.sinonimos.get(this.nivel).getNome();
            return auxiliar.get(0);
        }
    }
    
    
    public Palavra(String c, Enum n){
        this.conteudo = c;
        this.nivel = n;
    }
    public void setConteudo(String c){
        this.conteudo=c;
    }
    public void setNivel(Enum n){
        this.nivel = n;
    }
    public String getConteudo(){
        return this.conteudo;
    }
    public Enum getNivel(){
        return this.nivel;
    }

    public HashMap<Enum, Sinonimo> getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(HashMap<Enum, Sinonimo> sinonimos) {
        this.sinonimos = sinonimos;
    }
    
    public void pegarSinonimos(){
        Controller control = new Controller(this.conteudo);
        Integer grupo = control.pegarGrupo();
        if(grupo == null){
            this.setSinonimos(null);
        }else{
            Sinonimo baixo = new Sinonimo(grupo, Nivel.BAIXO);
            Sinonimo medio = new Sinonimo(grupo, Nivel.MEDIO);
            Sinonimo alto = new Sinonimo(grupo, Nivel.ALTO);
            baixo.pegarSinonimos();
            medio.pegarSinonimos();
            alto.pegarSinonimos();
            HashMap<Enum, Sinonimo> map = new HashMap();
            map.put(Nivel.BAIXO, baixo);
            map.put(Nivel.MEDIO, medio);
            map.put(Nivel.ALTO, alto);
            this.setSinonimos(map);
        }
    }
    @Override
    public String toString(){
        return "Conteudo: "+this.getConteudo()+ "\nNivel: " + this.getNivel();
    }

}


//select from *palavra where conteudo = conteudo;