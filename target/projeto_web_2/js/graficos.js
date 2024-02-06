google.charts.load('current', { 'packages': ['corechart'] });

function plotChart() {
    $.ajax({
        url: '/projeto_web_2/onibus',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            let chartData = new google.visualization.DataTable();
            chartData.addColumn('string', 'Modelo do Ônibus');
            chartData.addColumn('number', 'Lotação Máxima');

            for (let i = 0; i < data.length; i++) {
                let onibus = data[i];
                chartData.addRow([onibus.modelo, onibus.lotacaoMax]);
            }

            let options = {
                title: 'Lotação Máxima dos Ônibus',
                hAxis: { title: 'Modelo do Ônibus' },
                vAxis: { title: 'Lotação Máxima' }
            };

            let chart = new google.visualization.ColumnChart(document.getElementById('chart-lotacao'));
            chart.draw(chartData, options);
            plotDonutChart(data);
        },
        error: function (status, error) {
            console.error('Erro na requisição AJAX:', status, error);
        }
    });
}

function plotDonutChart(data) {
    if (data && data.length > 0) {
        contarLinhas(data, function(countLinha) {
            let tabelaDados =[['Linha', 'Contagem']];
            for(let linha in countLinha) {
                tabelaDados.push([linha, countLinha[linha]]);
            }

            let chartData = google.visualization.arrayToDataTable(tabelaDados);

            let options = {
                title: 'Distribuição de Linhas',
                pieHole: 0.4,
            };

            let chart = new google.visualization.PieChart(document.getElementById('chart-linha'));
            chart.draw(chartData, options);
        });
    } else {
        console.error('Dados ausentes ou inválidos.');
    }
}

function contarLinhas(data, callback) {
    let contagem = {};
    $.ajax({
        url: '/projeto_web_2/linhas',
        type: 'GET',
        dataType: 'json',
        success: function (dataLinhas) {
            let linhasPorId = {};
            for (let i = 0; i < dataLinhas.length; i++) {
                let linha = dataLinhas[i];
                linhasPorId[linha.id] = linha.nome;
            }

            for (let i = 0; i < data.length; i++) {
                let linhaId = data[i].linha_id;
                let linhaNome = linhasPorId[linhaId];

                if (linhaNome) {
                    contagem[linhaNome] = (contagem[linhaNome] || 0) + 1;
                }
            }
            callback(contagem);
        }
    });

}

window.addEventListener('load', plotChart);