package br.com.projetopoo.model;

import br.com.projetopoo.model.Entry;
import br.com.projetopoo.model.Entry;
import br.com.projetopoo.model.Usuario;
import br.com.projetopoo.model.Usuario;
import java.util.Calendar;

public interface IControllerUsuario {
    
    public boolean adicionar(Usuario usuario);
    public void remover(Usuario usuario);
    public Calendar login (Entry usuario);
    public Entry verificarLogin(Entry usuario);
}
