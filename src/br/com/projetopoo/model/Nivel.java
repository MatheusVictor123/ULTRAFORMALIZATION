package br.com.projetopoo.model;
public enum Nivel {
    BAIXO("baixo"), MEDIO("medio"), ALTO("alto");
    String nivel;
    Nivel(String nivel){
        this.nivel = nivel;
    }
    @Override
    public String toString(){
        return nivel;
    }
}
