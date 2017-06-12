<%-- 
    Document   : Formulario
    Created on : 12/06/2017, 14:17:25
    Author     : Breno
--%>

<%@page import="br.com.breno.conexao.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Funcionario fun =(Funcionario) request.getAttribute("fun");
        %>
        <form action="FunController" method="post">
            
            Informe o ID: <input type="number" name="id" value="<%=fun.getId()%>"/>
            Digite seu Nome: <input type="text" name="nome" value="<%=fun.getNome()%>"/>
            Digite o Login: <input type="text" name="login" value="<%=fun.getLogin()%>"/>
            Digite a Ssenha: <input type="text" name="senha" value="<%=fun.getSenha()%>" />
            
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
