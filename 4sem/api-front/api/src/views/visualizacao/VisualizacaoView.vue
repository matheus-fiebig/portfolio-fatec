<template>
    <div class="visualizacao__container">
        <div class="header">
            <h2>Visualização de Dados</h2>
            <div class="buttons">
                <select class="select" id="select_visu" v-on:change="getColaboradores()" v-model="empresaSelecionada">
                    <option :value="0">Selecione Partner...</option>
                    <option v-for="colaborador in listaDeEmpresas" :key="colaborador.id" :value="colaborador.id" >
                        {{ colaborador.nome }} #{{ colaborador.id }}
                    </option>
                </select>

                <select class="select" id="select_visu" @change="getProgresso($event.target?.value)">
                    <option :value="0">Selecione Colaborador...</option>
                    <option v-for="colaborador in listaDeColaboradores" :key="colaborador.id" :value="colaborador.id">
                        {{ colaborador.nome }} #{{ colaborador.id }}
                    </option>
                </select>
                <button class="btn btn-outline-success" v-on:click="download()">Extrair Dados</button>
            </div>
        </div>
        <div class="card">
            <Bar id="my-chart-id" :options="chartOptions" :data="chartData" />
        </div>
    </div>
</template>

<script lang="ts">
import axios from "axios";
import { Options, Vue } from "vue-class-component";
import { RouterLink } from "vue-router";

import { Bar } from "vue-chartjs";
import {
    Chart as ChartJS,
    Title,
    Tooltip,
    Legend,
    BarElement,
    CategoryScale,
    LinearScale,
} from "chart.js";
import { ref } from "vue";

ChartJS.register(Title, Tooltip, BarElement, CategoryScale, LinearScale);

@Options({
    name: "VisualizacaoView",
    components: {
        RouterLink,
        Bar,
    },
})
export default class VisualizacaoView extends Vue {
    listaDeColaboradores: {
        id: number;
        nome: string;
    }[] = [];

    listaDeEmpresas: {
        id: number;
        nome: string;
    }[] = [];

    empresaSelecionada = 0

    chartData: any = {
        labels: [],
        datasets: [{ data: [] }],
    };

    chartOptions = {
        backgroundColor: ["rgba(54, 162, 235, 0.2)"],
        borderColor: ["rgba(54, 162, 235)"],
        responsive: true,
        indexAxis: "y",
        scales: {
            x: {
                beginAtZero: true,
                min: 0,
                max: 100,
                ticks: {
                    callback: function (value: number) {
                        return value + "%";
                    },
                },
            },
        },
    };

    mounted() {
        this.getEmpresas();
        this.getColaboradores();

    }

    download() {
        var link = document.createElement('a');
        link.href = axios.defaults.baseURL + "relatorio/1";
        link.style.position = 'absolute';
        link.style.left = '-9999px';
        document.body.appendChild(link);
        link.click();
    }

    async getColaboradores() {
    try {
        const response1 = await axios.get("colaborador/1");
        console.log("Primeira requisição:", response1.data);

        const response2 = await axios.get("colaborador/2");
        console.log("Segunda requisição:", response2.data);

        const response3 = await axios.get("colaborador/3");
        console.log("Terceira requisição:", response3.data);

        this.listaDeColaboradores = [...response1.data, ...response2.data, ...response3.data];
    } catch (error) {
        console.error("Erro ao obter colaboradores:", error);
    }
}


    async getEmpresas() {
        const response = await axios.get("carregar-empresas");
        this.listaDeEmpresas = response.data;
    }

    async getProgresso(colaboradorId: string | null | any) {
        if (colaboradorId === null || colaboradorId === "0") {
            this.chartData = {
                labels: [],
                datasets: [{ data: [] }],
            };
            return;
        }

        const response = await axios.get(`progresso-colaborador/${colaboradorId}`);
        const progresso = response.data as {
            porcentagemAndamento: number;
            nomeTrilha: string;
        }[];

        this.chartData = {
            labels: progresso.map((p) => p.nomeTrilha),
            datasets: [{ data: progresso.map((p) => p.porcentagemAndamento) }],
        };
    }
}


</script>

<style>
.visualizacao__container {
    position: relative;
    display: flex;
    flex-direction: column;
    min-height: 30vh;

    .header {
        display: flex;
        justify-content: space-between;
    }

    #select_visu {
        border-radius: 4px;
        padding: 0.6rem;
        width: 170px;
        font-size: 0.8rem;
        margin-right: 10px;
        ;
    }

    .container_head {
        position: relative;
        display: flex;
        flex-direction: row;
        align-items: baseline;
        width: 1099px;
        margin: auto;
        border-radius: 20px;
        opacity: 1;
        gap: 0.5rem;
        padding: 2rem 5rem;
    }

    .card {
        display: flex;
        justify-content: space-between;
        flex-direction: row;
        border-radius: 8px;
        background-color: #ededed;
        margin-bottom: 10px;
        padding: 20px;
        box-shadow: 3px 5px 10px #555;
    }
}
</style>
