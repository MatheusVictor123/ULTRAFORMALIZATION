package br.com.projetopoo.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Organizador {
    private String texto;
    private Enum nivel;
    private ArrayList<Palavra> palavras;

    public Organizador(String texto, Enum nivel) {
        this.texto = texto;
        this.nivel = nivel;
    }

    public Organizador() {
        super();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Enum getNivel() {
        return nivel;
    }

    public void setNivel(Enum nivel) {
        this.nivel = nivel;
    }
    public void setPalavras(ArrayList<Palavra> p){
        this.palavras = p;
    }
    public ArrayList<Palavra>getPalavras(){
        return this.palavras;
    }
    public void separarPalavras(){
        String aux;
        String []vet;
        ArrayList<Palavra> palavra = new ArrayList();
        aux = this.removeIndesejados();
        vet = aux.split(" ");
        for(int i=0; i<vet.length; i++){
            Palavra p = new Palavra(vet[i], this.getNivel());
            p.pegarSinonimos();
            palavra.add(p);
        }
        this.setPalavras(palavra);
    }
    private String removeIndesejados(){
        String retornavel;
        retornavel = this.getTexto();
        if(retornavel.contains(",")){
           retornavel = retornavel.replace(",", "");
        }
        if(retornavel.contains(".")){
           retornavel = retornavel.replace(".", "");
        }
        if(retornavel.contains("´")){
           retornavel = retornavel.replace("´", "");
        }
        if(retornavel.contains("!")){
           retornavel = retornavel.replace("!", "");
        }
        if(retornavel.contains("?")){
           retornavel = retornavel.replace("?", "");
        }
        if(retornavel.contains("^")){
           retornavel = retornavel.replace("^", "");
        }
        //colocar tudo para minusculo
        retornavel = retornavel.toLowerCase();
        //fimm
        //remover duplo espaços
        while(retornavel.contains("  ")){
            retornavel = retornavel.replace("  ", " ");
        }
        //fim
        return retornavel;
    }
    public void formalizar(){
        String aux = "";
        ArrayList<Palavra> array = new ArrayList();
        array = this.getPalavras();
        for(int i = 0; i< array.size(); i++){
            if(array.get(i).pegarSinonimo() == null){
                aux = aux + array.get(i).getConteudo() + " ";
            }else{
                aux = aux + array.get(i).pegarSinonimo() + " ";
            }
        }
        this.setTexto(aux);
}
    @Override
    public String toString(){
        return texto;
    }
}
