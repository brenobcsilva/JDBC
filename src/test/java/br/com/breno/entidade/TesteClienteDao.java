package br.com.breno.entidade;

import br.com.breno.persistencia.jdbc.postgresql.FuncionarioDao;
import br.com.breno.conexao.Funcionario;
import java.sql.PreparedStatement;
import java.util.List;

public class TesteClienteDao {

    public static void main(String[] args) {
        //Chamar os metdoos
//        cadastrarFuncionario();
//        alterarFuncionario();
//        excluirFuncionario();
//            salvarFuncionario();
            testarBuscartodos();
            testeConexao();
    }

    
    
    public static void salvarFuncionario(){
        Funcionario fun = new Funcionario();
        fun.setId(1);
        fun.setNome("BrenoS");

        FuncionarioDao funDao = new FuncionarioDao();
        funDao.salvar(fun);
        
        System.out.println("Funcionario salvo com sucesso!");
    }
    
    public static void excluirFuncionario() {
        Funcionario fun = new Funcionario();
        fun.setId(1);
//        fun.setNome("BrenoS");
//        fun.setLogin("brenobcsilva@");
//        fun.setSenha("a1b1c1");
        
        FuncionarioDao funDao = new FuncionarioDao();
        funDao.excluir(fun);
        
        System.out.println("Funcionario excluido com sucesso");
    }
    public static void alterarFuncionario() {
        Funcionario fun = new Funcionario();
        fun.setId(1);
        fun.setNome("BrenoS");
        fun.setLogin("brenobcsilva@");
        fun.setSenha("a1b1c1");
        
        FuncionarioDao funDao = new FuncionarioDao();
        funDao.cadastrar(fun);
        
        System.out.println("Dados alterados com sucesso");
    }

    public static void cadastrarFuncionario() {
        Funcionario fun = new Funcionario();
        fun.setNome("BrenoS");
        fun.setLogin("brenobcsilva@");
        fun.setSenha("a1b1c1");

        FuncionarioDao funDao = new FuncionarioDao();
        funDao.alterar(fun);

        System.out.println("Cadastrado com sucesso");
    }
    public static void testarResultadoPorId(){
        FuncionarioDao funDao = new FuncionarioDao();
        Funcionario fun = funDao.buscaPeloId(1);
        System.out.println(fun);
    }
    public static void testarBuscartodos(){
        FuncionarioDao funDao = new FuncionarioDao();
        List<Funcionario>listar = funDao.buscarTodos();
        for(Funcionario f : listar){
            System.out.println(f);
        }
        
    }

    private static void testeConexao() {
        FuncionarioDao funDao = new FuncionarioDao();
        Funcionario fun = new Funcionario();
        fun.setLogin("jao");
        fun.setSenha("123");
        
        Funcionario funcAutenticar = funDao.autenticar(fun);
        System.out.println(funcAutenticar);
    }

}
