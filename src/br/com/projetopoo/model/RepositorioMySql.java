package br.com.projetopoo.model;
import br.com.projetopoo.controller.BancoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RepositorioMySql implements Repositorio{
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public RepositorioMySql(){
        this.conexao = null;
        this.pst = null;
        this.rs = null;
    }


    private Connection getConexao() {
        return conexao;
    }

    private void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    private PreparedStatement getPst() {
        return pst;
    }

    private void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    private ResultSet getRs() {
        return rs;
    }

    private void setRs(ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public Integer pegarGrupo(String palavra){
       BancoBD banco = new BancoBD();
       Integer valor = null;
       String url = "select * from palavras where palavra = ?";
       try {
        conexao = banco.conector();
        pst = conexao.prepareStatement(url);
        pst.setString(1, palavra);
        rs = pst.executeQuery();
        if(rs.next()){
            valor = rs.getInt(3);
        }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
       }
       
       return valor;
    }
    
    @Override
    public ArrayList<String> pegarSinonimos(Enum nivel, Integer grupo){
       ArrayList<String> array = new ArrayList();
       BancoBD banco = new BancoBD();
       String url = "select * from palavras where grupo = ? and nivel = ?";
       try {
           this.conexao = banco.conector();
           this.pst = conexao.prepareStatement(url);
           this.pst.setInt(1, grupo);
           this.pst.setString(2, nivel.toString());
           rs = pst.executeQuery();
           if(rs.next()){
               array.add(rs.getString(2));
           }else{
               array = null;
           }
       } catch (Exception e) {
       }
       return array;
    }
}
