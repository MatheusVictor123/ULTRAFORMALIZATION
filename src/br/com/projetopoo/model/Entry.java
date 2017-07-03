package br.com.projetopoo.model;
public class Entry {
    private String login;
    private String senha;
    private boolean status;
    
    private boolean verificarSenha(){
        if(this.senha.isEmpty() || this.senha.equals("")){
            return true;
        }else if(this.senha.length()>6){
            return true;
        }else{
            return false;
        }
    }
    private boolean verificarLogin(){
        if(this.login.isEmpty() || this.login.equals("")){
            return true;
        }else if(this.login.contains(",") || this.login.contains(".") || this.login.contains("!")
                || this.login.contains("?") || this.login.contains(";") || this.login.contains("´")||
                this.login.contains("^") || this.login.contains(" ")){
            return true;
        }else{
            return false;
        }
    }
    public Entry(String l, String s){
        this.login = l;
        this.senha = s;
        if(this.verificarLogin() == true || this.verificarSenha() == true){
            this.status = false;
        }else{
            this.status = true;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        if(this.verificarLogin() == true || this.verificarSenha() == true){
            this.status = false;
        }else{
            this.status = true;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        if(this.verificarLogin() == true || this.verificarSenha() == true){
            this.status = false;
        }else{
            this.status = true;
        }
    }

    public boolean isStatus() {
        return status;
    }
}
