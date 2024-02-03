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
        error: function (xhr, status, error) {
            console.error('Erro na requisição AJAX:', status, error);
        }
    });
}

function plotDonutChart(data) {
    if (data && data.length > 0) {
        let countLinha = contarLinhas(data);

        let tabelaDados = [['Linha', 'Contagem']];
        for (let linha in countLinha) {
            tabelaDados.push([linha, countLinha[linha]]);
        }

        let chartData = google.visualization.arrayToDataTable(tabelaDados);

        let options = {
            title: 'Distribuição de Linhas',
            pieHole: 0.4,
        };

        let chart = new google.visualization.PieChart(document.getElementById('chart-linha'));
        chart.draw(chartData, options);
    } else {
        console.error('Dados ausentes ou inválidos.');
    }
}

function contarLinhas(data) {
    let contagem = {};
    for (let i = 0; i < data.length; i++) {
        let linha = data[i].linha;
        contagem[linha] = (contagem[linha] || 0) + 1;
    }
    return contagem;
}

window.addEventListener('load', plotChart);