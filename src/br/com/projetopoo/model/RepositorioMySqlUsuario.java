package br.com.projetopoo.model;

import br.com.projetopoo.controller.BancoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class RepositorioMySqlUsuario implements IControllerUsuario{
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public RepositorioMySqlUsuario(){
        this.conexao = null;
        this.pst = null;
        this.rs = null;
    }
    @Override
    public boolean adicionar(Usuario usuario) {
        BancoBD banco = new BancoBD();
        boolean status = false;
        if(usuario instanceof UsuarioFree){
            String url = "INSERT INTO normaluser (login, senha, nome, idade, email, datedayinicio, datemonthinicio, dateyearinicio, datedayfim, datemonthfim, dateyearfim, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try{
                this.conexao = banco.conector();
                this.pst = conexao.prepareStatement(url);
                pst.setString(1, usuario.getLogin().getLogin());
                pst.setString(2, usuario.getLogin().getSenha());
                pst.setString(3, usuario.getNome());
                pst.setInt(4, usuario.getIdade());
                pst.setString(5, usuario.getEmail().getEmail());
                pst.setInt(6, ((UsuarioFree) usuario).getInicio().get(Calendar.DAY_OF_MONTH));
                pst.setInt(7, ((UsuarioFree) usuario).getInicio().get(Calendar.MONTH + 1));
                pst.setInt(8, ((UsuarioFree) usuario).getInicio().get(Calendar.YEAR));
                pst.setInt(9, ((UsuarioFree) usuario).getFim().get(Calendar.DAY_OF_MONTH));
                pst.setInt(10, ((UsuarioFree) usuario).getFim().get(Calendar.MONTH));
                pst.setInt(11, ((UsuarioFree) usuario).getFim().get(Calendar.YEAR));
                pst.setString(12, ((UsuarioFree) usuario).getStatusConta().toString());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario Cadastrado");
                status = true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
                status = false;
            }
        }
        return status;
    }

    @Override
    public void remover(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Calendar login(Entry usuario) {
        BancoBD banco = new BancoBD();
        Calendar calendario = Calendar.getInstance();
            String url = "select * from normaluser where login = ? and senha = ?";
            try{
                conexao = banco.conector();
                pst = conexao.prepareStatement(url);
                pst.setString(1, usuario.getLogin());
                pst.setString(2, usuario.getSenha());
                rs = pst.executeQuery();
                if(rs.next()){
                    calendario.set(Calendar.YEAR, rs.getInt(11));
                    calendario.set(Calendar.MONTH, (rs.getInt(10) - 1));
                    calendario.set(Calendar.DAY_OF_MONTH, rs.getInt(9));
                    return calendario;
                }else{
                    return null;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
                calendario = null;
            }
        return calendario;
    }

    @Override
    public Entry verificarLogin(Entry usuario) {
        BancoBD banco = new BancoBD();
        
            String url = "select * from normaluser where login = ?";
            try{
                conexao = banco.conector();
                pst = conexao.prepareStatement(url);
                pst.setString(1, usuario.getLogin());
                rs = pst.executeQuery();
                if(rs.next()){
                    return usuario;
                }else{
                    return null;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        
        return usuario;
    }
    
}
