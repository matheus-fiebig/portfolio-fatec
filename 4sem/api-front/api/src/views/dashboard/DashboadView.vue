<template>
    <div class="Dashboard">
        <div class="header">
            <h2>Dashboard</h2>
        </div>
        <div class="content">
            <div class="card">
                <div class="charts">
                    <div class="chart-category">
                        <canvas id="category"></canvas>
                    </div>
                    <div class="chart-pie">
                        <canvas id="pie"></canvas>
                    </div>
                </div>
                <div class="companies">
                    <div class="header">
                        <h4>Listagem de Empresas</h4>
                    </div>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Identificador</th>
                                <th>Compania</th>
                                <th>País</th>
                                <th>Cidade</th>
                                <th>Administrador</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="selectable-row" v-for="company in companies" v-on:click="changeCompany(company.id)">
                                <td>{{company.codigo}}</td>
                                <td>{{company.nome}}</td>
                                <td>{{company.pais}}</td>
                                <td>{{company.cidade}}</td>
                                <td>{{company.adminNome}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue } from 'vue-class-component';
import { Chart, ChartConfiguration, registerables } from 'chart.js';
import axios from 'axios';

Chart.register(...registerables);

interface ProgressoItem {
    progresso: {
        [key: string]: {
            expertiseId: number;
            status: string;
        };
    };
}
function getFixedRandomValue(seed: number) {
    const x = Math.sin(seed) * 10000;
    return (x - Math.floor(x)) * 100;
}


export default class Dashboard extends Vue {
    selectedCompany: number = 1;
    selectedExpertise: number = 3;
    companies:any[] = [];
    barChart: Chart | null = null;
    pieChart: Chart | null = null;
    
    

    changeCompany(id:number){
        this.selectedCompany = id;

        axios.get(`dash/trilhas/empresa/${this.selectedCompany}`)
        .then(response => {
            const trilhas = response.data;
            console.log(trilhas)
            const data = {
                labels: trilhas.map((trilha: { nome: string }) => trilha.nome),
                values: trilhas.map((trilha: { progressoColaborador: number }) => trilha.progressoColaborador)
            };
            const categoryChartConfig = this.createCategoryChartConfig(data);
            this.createChart("category", categoryChartConfig);
        })
        .catch(error => {
            console.error("Erro ao buscar dados da categoria:", error);
            
        });
    }

    changeExpertise(id: number){
        this.selectedExpertise = id
        axios.get(`dash/expertises/empresa/${this.selectedCompany}/trilha/${this.selectedExpertise}`)
            .then(data => {
                this.createChart("pie", this.createPieChartConfig(data.data))
            })
    }

    createPieChartConfig(data: ProgressoItem[]) {
        const concluded = data
            .filter(x => Object.values(x.progresso)[0].status == "NAO_CONCLUIDO")
            .map(x => Object.keys(x.progresso)[0])

        const notConcluded = data
            .filter(x => Object.values(x.progresso)[0].status == "CONCLUIDO")
            .map(x => Object.keys(x.progresso)[0])

        const status = data.reduce((total, item) => {
            const status = Object.values(item.progresso)[0].status;
            total[status] = (total[status] || 0) + 1;
            return total;
        }, {} as { [key: string]: number });

        const pieData = {
            labels: ['Concluído', 'Não Concluído'],
            datasets: [
                {
                    label: '',
                    data: [status['CONCLUIDO'], status['NAO_CONCLUIDO']],
                },
            ]
        };

        return {
            type: 'pie',
            data: pieData,
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'right',
                    },
                    tooltip: {
                        callbacks: {
                            title: (a: any, d: any) => {
                                const index = a[0].dataIndex
                                return index == 1 ? concluded.join("\n") : notConcluded.join("\n")
                            }
                        }
                    }
                },
            },
        } as ChartConfiguration;

    }

    createCategoryChartConfig(data: { labels: string[], values: number[] }) {
        
        const categoryData = {
            labels: data.labels,
            datasets: [{
                label: 'Meu Primeiro Dataset',
                data: data.values,
                backgroundColor: [
                ],
                borderColor: [
                ],
                borderWidth: 1
            }]
        };
        

        return {
            type: 'bar',
            data: categoryData,
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                onClick: (event, elements) => {
                    if (elements.length > 0) {
                        const chartElement = elements[0];
                        const index = chartElement.index;
                        this.changeExpertise(index + 1);  
                    }
                }
            }
        } as ChartConfiguration;
    }

    createChart(id: string, config: ChartConfiguration) {
        const canvas = document.getElementById(id) as HTMLCanvasElement;
        if (canvas) {
            const ctx = canvas.getContext('2d');
            if (ctx) {
                if (id === 'category' && this.barChart) {
                    this.barChart.destroy();
                }
                if (id === 'pie' && this.pieChart) {
                    this.pieChart.destroy();
                }
                if (id === 'category') {
                    this.barChart = new Chart(ctx, config);
                } else if (id === 'pie') {
                    this.pieChart = new Chart(ctx, config);
                }
            }
        }
    }

    mounted() {
        
        axios.get('carregar-empresas').then(x => this.companies = x.data)
    }
}
</script>

<style style="scss">
.Dashboard {
    .header {
        display: flex;
        justify-content: space-between;
        margin-left: 0px;
        margin-right: auto;
    }

    .content {
        width: inherit;
        height: inherit;
        display: flex;
        flex-direction: column;
        padding: 0 12px 0 0;
    }

    .card {
        flex: 1;
        flex-direction: column;
        border-radius: 8px;
        min-height: 350px;
        padding: 20px;
        background-color: #ededed;
        box-shadow: 0px 5px 7px #cec9c9;
    }

    .charts {
        display: flex;
        justify-content: space-between;
        height: 400px;
    }

    .chart-pie,
    .chart-category {
        display: flex;
        width: 48%;
        justify-content: center;
        flex-direction: row;
        align-items: center;
    }

    .selectable-row{
        cursor:pointer;
    }
}
</style>
