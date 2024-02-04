<%@page import="java.util.List" %>
<%@page import="model.PontoBean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pontos</title>
</head>
<body>
    <% List<PontoBean> pontos = (List<PontoBean>)request.getAttribute("pontos"); %>
    <form action="linha-ponto" method="get">
        <p>Escolha o ponto:</p>
        <select name="pontoId" id="pontoId">
            <% for(PontoBean ponto : pontos){ %>
                <option value="<%=ponto.getId() %>"><%=ponto.getNome()%></option>
            <% } %>
        </select>
        <input type="submit" value="consultar" name="botao">
    </form>
</body>
</html>