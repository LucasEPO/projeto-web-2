function updateHorario() {
    let primeiraCelulaLinha = document.getElementById('linha-0').textContent;
    let primeiraCelulaID = document.getElementById('id-0').textContent;

    let horarios = ['09:10', '17:18', '21:45'];
    let horarioAtraso = Math.floor(Math.random() * (3));

    let payload = {novo_horario_chegada: horarios[horarioAtraso], linha_id: primeiraCelulaLinha, ponto_id: primeiraCelulaID}

    $.ajax({
        url: '/projeto_web_2/linha-ponto',
        type: 'POST',
        data: payload,
        error: function (status, error) {
            console.error('Erro na requisição AJAX:', status, error);
        }
    });
}

function getUpdatedHorario() {
    let primeiraCelulaID = document.getElementById('id-0').textContent;
    $.ajax({
        url: `/projeto_web_2/linha-ponto?pontoId=${primeiraCelulaID}&botao=atualizar`,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
           let conteudoTabela = $('#table-body')

           conteudoTabela.empty()
           for(i = 0; i < data.length; i++){
            conteudoTabela.append(`
                <tr>
                        <td>${data[i].nome_linha}</td>
                        <td id="linha-${i}">${data[i].linha_id}</td>
                        <td id="id-${i}">${data[i].ponto_id}</td>
                        <td>${data[i].horario_chegada}</td>
                </tr>
            `)
           }
           console.log(data)
        },
        error: function (status, error) {
            console.error('Erro na requisição AJAX:', status, error);
        }
    });
}

$(document).ready(function(){
    setInterval(updateHorario, 10000)
    setInterval(getUpdatedHorario, 11000)
})
