package br.com.projetopoo.model;

import java.util.ArrayList;

public interface Repositorio {
    public Integer pegarGrupo(String palavra);
    public ArrayList<String> pegarSinonimos(Enum nivel, Integer grupo);
}
