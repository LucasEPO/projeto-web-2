<%@page import="java.util.List" %>
<%@page import="model.LinhaPontoBean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pontos</title>
</head>
<body>
    <% List<LinhaPontoBean> linhas = (List<LinhaPontoBean>)request.getAttribute("linha-ponto"); %>
        <table border="1">
            <thead>
                <tr>
                    <th width="50">Linha ID</th>
                    <th width="150">Ponto ID</th>
                    <th width="150">Horário</th>
                </tr>
            </thead>
            <tbody>
                <% for(LinhaPontoBean linha : linhas){ %>
                    <tr>
                        <td><%=linha.getLinha_id()%></td>
                        <td><%=linha.getPonto_id()%></td>
                        <td><%=linha.getHorario_chegada()%></td>
                    </tr>
                <%} %>
            </tbody>
        </table>
</body>
</html>