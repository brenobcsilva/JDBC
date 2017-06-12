<%-- 
    Document   : listFuncionarios
    Created on : 12/06/2017, 11:20:02
    Author     : Breno
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.breno.conexao.Funcionario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Funcionários</title>
        <script type="text/javascript">
            if(window.confirm('Deseja mesmo excluir?')){
//                location.href="funcontroller?acao=exc&id="+id; Mensagem para excluir
            }
            </script>
    </head>
    <body>
        <%
            List<Funcionario> list = (List<Funcionario>)request.getAttribute("ChaveLista");
        %>
            <table border=5>
                <tr><th> id </th> </tr> nome </th></tr>
            
            <% for(Funcionario f : list){%>
                <tr>
                    <td><% out.print(f.getId()); %></td>
                <td><%=f.getNome() %></td>
                </td><a href="FunController?acao=exc&id=<%=f.getId()%>">excluir </a> | <a href="funcontroller?acao=alt&id=<%=f.getId()%>"> alterar<a/> </td>
            <%}%>
            
            out.print("</table>");
        %>
    </body>
</html>
