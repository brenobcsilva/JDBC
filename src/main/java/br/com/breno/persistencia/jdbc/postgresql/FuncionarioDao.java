package br.com.breno.persistencia.jdbc.postgresql;

import br.com.breno.conexao.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDao {
    
    private Connection c = ConexaoFactory.getConnection();
    
    public void cadastrar(Funcionario f){
        String sql = "insert into \"Clientes\" ( login, senha) values(?,?)";
        
        try (PreparedStatement pre = c.prepareStatement(sql)){
//            pre.setString(1, f.getNome());
            pre.setString(2, f.getLogin());
            pre.setString(3, f.getSenha());
            pre.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    public void alterar(Funcionario f) {
        
        String sql = "update \"Clientes\" set Nome?, login=?, senha=? where id=?";
        
        try (PreparedStatement pre = c.prepareStatement(sql)){
//            pre.setString(1, f.getNome());
            pre.setString(2, f.getLogin());
            pre.setString(3, f.getSenha());
            pre.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    public void excluir(Funcionario f) {
        String sql = "delete from \"Clientes\" where id=?";
        try(PreparedStatement pre = c.prepareStatement(sql)){
            pre.setInt(1, f.getId());
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void salvar(Funcionario f){
        if(f.getId()!= null && f.getId()!=0){
            alterar(f);
        }else{
            cadastrar(f);
        }
    }
    
    public Funcionario buscaPeloId(Integer id){
        String sql = "select * from \"Clientes\" where id=?";
        try(PreparedStatement pre = c.prepareStatement(sql)){
            pre.setInt(1, id);
            ResultSet resul = pre.executeQuery();
            if(resul.next()){
                Funcionario fun = new Funcionario();
                fun.setId(resul.getInt("id"));
                fun.setNome(resul.getString("nome"));
                fun.setLogin(resul.getString("login"));
                fun.setSenha(resul.getString("senha"));
                
                return fun;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Buscar por resgistros na tabela funcionario
     * @return os dados da table funcionario.
     */
    public List<Funcionario> buscarTodos(){
        String sql = "select * from \"Clientes\" where id=?";
        List<Funcionario> lista = new ArrayList<Funcionario>();
        try(PreparedStatement pre = c.prepareStatement(sql)){
            ResultSet resul = pre.executeQuery();
            while(resul.next()){
                Funcionario fun = new Funcionario();
                fun.setId(resul.getInt("id"));
                fun.setNome(resul.getString("nome"));
                fun.setLogin(resul.getString("login"));
                fun.setSenha(resul.getString("senha"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public Funcionario autenticar(Funcionario funcConsulta){
        
        String sql="Select * from usuario where login=? and senha=?";
        
        try(PreparedStatement pre = c.prepareStatement(sql)){
            pre.setString(1, funcConsulta.getLogin());
            pre.setString(2, funcConsulta.getSenha());
            ResultSet resul =  pre.executeQuery();
            
            if(resul.next()){
            Funcionario fun = new Funcionario();
            fun.setId(resul.getInt("id"));
            fun.setNome(resul.getString("nome"));
            fun.setLogin(resul.getString("login"));
            fun.setSenha(resul.getString("senha"));
            
            return fun;
            }else{
                return null;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    }

