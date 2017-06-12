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
    </head>
    <body>
        <%
            List<Funcionario> list = (List<Funcionario>)request.getAttribute("ChaveLista");
        
            out.print("<table border=5>");
            out.print("<tr><th> id </th> </tr> nome </th></tr>");
            
            for(Funcionario f : list){
                out.print("<tr>");
                out.print("<td>" + f.getNome() + "</td><td> " + f.getNome() + "</td>");
                out.print("/tr");
            }
            out.print("</table>");
        %>
    </body>
</html>
