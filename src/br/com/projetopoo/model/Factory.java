package br.com.projetopoo.model;

public class Factory {
    private Factory(){
        
    }
    
    public static Repositorio getInstance(String instance){
        switch(instance){
            case "mysql":
                return new RepositorioMySql();
            }
        return null;
    }
}
