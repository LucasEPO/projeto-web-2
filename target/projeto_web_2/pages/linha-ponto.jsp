<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.List" %>
<%@page import="model.LinhaPontoBean" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script type="text/javascript" src="/projeto_web_2/js/updateHorario.js"></script>
    <title>Pontos</title>
</head>
<body>
    <% List<LinhaPontoBean> linhas = (List<LinhaPontoBean>)request.getAttribute("linha-ponto"); %>
        <table border="1">
            <thead>
                <tr>
                    <th width="50">Linha</th>
                    <th width="50">Linha ID</th>
                    <th width="150">Ponto ID</th>
                    <th width="150">Horário</th>
                </tr>
            </thead>
            <tbody id="table-body">
                <% for(int i = 0; i < linhas.size(); i++){ %>
                    <tr>
                        <td><%=linhas.get(i).getNome_linha()%></td>
                        <td id="linha-<%=i%>"><%=linhas.get(i).getLinha_id()%></td>
                        <td id="id-<%=i%>"><%=linhas.get(i).getPonto_id()%></td>
                        <td><%=linhas.get(i).getHorario_chegada()%></td>
                    </tr>
                <%} %>
            </tbody>
        </table>
</body>
</html>