package br.com.projetopoo.controller;

import br.com.projetopoo.model.Entry;
import br.com.projetopoo.model.FactoryUsuario;
import br.com.projetopoo.model.IControllerUsuario;
import br.com.projetopoo.model.Usuario;
import java.util.Calendar;

public class ControllerUsuario {
    private Usuario usuario;
    
    public ControllerUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public ControllerUsuario(){
        
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Calendar login(Entry usuario){
        Calendar calendario;
        IControllerUsuario factory = FactoryUsuario.getInstance("mysql");
        calendario = factory.login(usuario);
        return calendario;
    }
    public boolean adicionar(Usuario usuario){
        boolean status;
        IControllerUsuario factory = FactoryUsuario.getInstance("mysql");
        status = factory.adicionar(usuario);
        return status;
    }
    
    public Entry verificarLogin(Entry login){
        IControllerUsuario factory = FactoryUsuario.getInstance("mysql");
        login = factory.verificarLogin(login);
        return login;
    }
}
