package br.com.projetopoo.model;
public abstract class Usuario {
    private String nome;
    private int idade;
    private Email email;
    private Entry login;
    
    public Usuario(String nome, int idade, Email email, Entry login){
        this.nome = nome;
        //this.endereco = endereco;
        this.idade = idade;
        this.email = email;
        //this.cpf = cpf;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }


    public Entry getLogin() {
        return login;
    }

    public void setLogin(Entry login) {
        this.login = login;
    }
    
    
}
