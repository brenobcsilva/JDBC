package br.com.breno.controler;

import br.com.breno.conexao.Funcionario;
import br.com.breno.persistencia.jdbc.postgresql.FuncionarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo
 *
 * @author Breno
 */
@WebServlet(name = "/usuController")
public class FunControler extends HttpServlet {

    public FunControler() {
//        System.out.println("Criando novo Servlet");
        System.out.println("Chamando o construtor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Chamando o init");
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        String acao = req.getParameter("acao");
        if(acao.equals("excluir")){
            String id = req.getParameter("id");
            Funcionario fun = new Funcionario();
            if(!(id == null))
                fun.setId(Integer.parseInt(id));
            
            FuncionarioDao funDao = new FuncionarioDao();
            funDao.excluir(fun);
            
            resp.getWriter().println("parametro excluido");
        }else if(acao.equals("lis")){
         //localhost:8080/com.breno/FunController   
            FuncionarioDao funDao = new FuncionarioDao();
            List<Funcionario> list = funDao.buscarTodos();
            req.setAttribute("ChaveLista", list);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listFuncionarios.jsp");
            dispatcher.forward(req, resp);
//            for(Funcionario f:list){
//            resp.getWriter().print(f.getNome() + "<br>");
//            }
        }else if(acao.equals("alterar")){
            String id = req.getParameter("id");
            FuncionarioDao usuDao = new FuncionarioDao();
            Funcionario fun = usuDao.buscaPeloId(Integer.parseInt(id));
            req.setAttribute("usu", fun);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formulario.jsp");
            dispatcher.forward(req, resp);
        }else if(acao.equals("cadastrar")){
            
            Funcionario fun = new Funcionario();
            fun.setId(0);
            fun.setNome("");
            fun.setLogin("");
            fun.setSenha("");
            
            req.setAttribute("usu", fun);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formulario.jsp");
            dispatcher.forward(req, resp);
        }
    }
        
//        String id = req.getParameter("id");
//        String nome = req.getParameter("nome");
//        String login = req.getParameter("login");
//        String senha = req.getParameter("senha");
//
//        Funcionario fun = new Funcionario();
//        if (!(id == null)) {
//            fun.setId(Integer.parseInt(id));
//        }
//        fun.setNome(nome);
//        fun.setLogin(login);
//        fun.setSenha(senha);
////        System.out.println("Chamando goGet" + req);
////        System.out.println("Chamando" + resp);
//
//        FuncionarioDao funDao = new FuncionarioDao();
//        funDao.salvar(fun);
//
//        resp.getWriter().println("<strong>Sucesso!</strong>");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Funcionario fun = new Funcionario();
        if (!(id == null)) {
            fun.setId(Integer.parseInt(id));
        }
        FuncionarioDao funDao = new FuncionarioDao();
        funDao.excluir(fun);
        
        resp.sendRedirect("funcontroller?acao=lis");
//        resp.getWriter().println("Excluido com sucesso");
    }
    
    //localhost:8080/com.bre

    //localhost:8080/com.breno/UsuControler/nome=breno&login=
    @Override
    public void destroy() {
        System.out.println("Destroy");
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

}
