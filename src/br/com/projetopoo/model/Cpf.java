/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetopoo.model;

import java.util.InputMismatchException;

/**
 *
 * @author User
 */
public class Cpf {
    private String cpf;
    private boolean status;
    
    public Cpf(String cpf){
        this.cpf = cpf;
    }
    
    public Cpf(double cpf){
        this.cpf = Double.toString(cpf);
    }
    
    public Cpf(int cpf){
        this.cpf = Integer.toString(cpf);
    }
    
    public Cpf(float cpf){
        this.cpf = Float.toString(cpf);
    }
     public void isCPF() {
    if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
        cpf.equals("22222222222") || cpf.equals("33333333333") ||
        cpf.equals("44444444444") || cpf.equals("55555555555") ||
        cpf.equals("66666666666") || cpf.equals("77777777777") ||
        cpf.equals("88888888888") || cpf.equals("99999999999") ||
       (cpf.length() != 11)){
        status = false;
    }
    try {
      int sm = 0, i, r, num, peso;
      peso = 10;
      for (i=0; i<9; i++) {              
        num = (int)(cpf.charAt(i) - 48); 
        sm = sm + (num * peso);
        peso = peso - 1;
      }

      r = 11 - (sm % 11);
        char dig10;
      if ((r == 10) || (r == 11))
         dig10 = '0';
      else dig10 = (char)(r + 48); 
      sm = 0;
      peso = 11;
      for(i=0; i<10; i++) {
        num = (int)(cpf.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso - 1;
      }

      r = 11 - (sm % 11);
        char dig11;
      if ((r == 10) || (r == 11))
         dig11 = '0';
      else dig11 = (char)(r + 48);

      if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
         status = true;
      else status = false;
    } catch (InputMismatchException erro) {
        status = false;
    }
  }

  public String imprimeCPF(String cpf) {
    return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
      cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
  }

    public String getCpf() {
        return cpf;
    }

    public boolean isStatus() {
        return status;
    }
  
}
