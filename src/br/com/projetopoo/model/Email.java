/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetopoo.model;

/**
 *
 * @author Mateus
 */
public class Email {
    private String email;
    private boolean status;
    
    private boolean verificarEmail(){
        String [] valor;
        int cont = 0;
        if(this.email.isEmpty() || this.email.equals("")){
            return true;
        }else if(this.email.contains(",") || this.email.contains("*") || this.email.contains(" ") ||
                this.email.contains(":") || this.email.contains(";") || this.email.contains("ç")){
            return true;
        }else{
            if(this.email.contains("@")){
                valor = this.email.split("@");
               if(valor.length > 2){
                   return true;
               }else{
                   return false;
               }
            }else{
                return true;
            }
        }
    }
    public Email(String e){
        this.email = e;
        if(this.verificarEmail() == true){
            this.status = false;
        }else{
            this.status = true;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
         if(this.verificarEmail() == true){
            this.status = true;
        }else{
            this.status = false;
        }
    }

    public boolean isStatus() {
        return status;
    }
    
}
