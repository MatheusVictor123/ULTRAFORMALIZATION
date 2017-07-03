package br.com.projetopoo.model;
public enum Status {
    FREE("free"), PAID("paid"), WAITINGPAYMENT("waitingpayment");
    String status;
    Status(String status){
        this.status = status;
    }
    @Override
    public String toString(){
        return status;
    }
}
