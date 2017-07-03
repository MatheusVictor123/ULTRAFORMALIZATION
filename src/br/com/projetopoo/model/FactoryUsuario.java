package br.com.projetopoo.model;
public class FactoryUsuario {
    
    private FactoryUsuario(){
        
    }
    public static RepositorioMySqlUsuario getInstance(String tipo){
        switch(tipo){
            case "mysql":
                return new RepositorioMySqlUsuario();
               
            default:
                return null;
        }
    }
}
