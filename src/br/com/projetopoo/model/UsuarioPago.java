/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetopoo.model;

/**
 *
 * @author User
 */
public class UsuarioPago extends Usuario{
    private Enum licensa;
    private Endereco endereco;
    private Cpf cpf;
    public UsuarioPago(String nome, int idade, Email email, Entry login) {
        super(nome, idade, email, login);
    }
    
}
