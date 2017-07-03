package br.com.projetopoo.model;
import java.util.Calendar;

public class UsuarioFree extends Usuario{
    private Calendar inicio;
    private Calendar fim;
    private Enum statusConta;
    
    public UsuarioFree(String nome, int idade, Email email, Entry login, Enum status) {
        super(nome, idade, email, login);
        this.statusConta = status;
    }

    public Enum getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(Enum statusConta) {
        this.statusConta = statusConta;
    }
    
    
    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public Calendar getFim() {
        return fim;
    }

    public void setFim(Calendar fim) {
        this.fim = fim;
    }
    
    public void grabLicense(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Calendar.YEAR);
        calendar.set(Calendar.MONTH, Calendar.MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, Calendar.DAY_OF_MONTH);
        this.setInicio(calendar);
        if(calendar.get(Calendar.MONTH) == 11){
            calendar.set(Calendar.YEAR, Calendar.YEAR + 1);
        }
        calendar.set(Calendar.MONTH, Calendar.MONTH + 1);
        this.setFim(calendar);
    }
}
