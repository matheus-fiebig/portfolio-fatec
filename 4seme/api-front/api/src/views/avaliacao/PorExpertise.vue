<template>
    <div class="porexpertise__container">
        <div class="header">
            <h2>Avaliações por Expertise</h2>
            <div class="buttons">
                <select class="select" id="select-trilha" v-model="trilhaSelecionada">
                    <option :value="0">Selecionar Trilha...</option>
                    <option v-for="trilha in listaDeTrilhas" :key="trilha.id" :value="trilha.id">
                        {{ trilha.workload }} #{{ trilha.id }}
                    </option>
                </select>
                <select class="select" id="select-expertise" v-model="expertiseSelecionada">
                    <option :value="0">Selecionar Expertise...</option>
                    <option v-for="expertise in listaDeExpertises" :key="expertise.id" :value="expertise.id">
                        {{ expertise.nome }} #{{ expertise.id }}
                    </option>
                </select>
                <button class="btn btn-outline-success" v-on:click="getStat()">Visualizar</button>
            </div>
        </div>
        <div class="card">
            <Bar id="por-expertise-chart" :options="chartOptions" :data="chartData" />
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
    name: "PorExpertise",
    components: {
        RouterLink,
        Bar,
    },
})
export default class PorExpertise extends Vue {
    chartData: any = {
        labels: [],
        datasets: [{ data: [] }],
    };

    chartOptions = {
        backgroundColor: ["rgba(54, 162, 235, 0.2)"],
        borderColor: ["rgba(54, 162, 235)"],
        responsive: true,
        maintainAspectRatio: false,
        indexAxis: "y",
        scales: {
            x: {
                beginAtZero: true,
                min: 0,
            },
        },
        plugins: {
            legend: {
                display: false
            },
        }
    };

    listaDeTrilhas: {
        workload: string,
        id: number;
    }[] = [];

    listaDeExpertises: {
        name: string,
        id: number;
    }[] = [];

    trilhaSelecionada: number = 0;

    expertiseSelecionada: number = 0;

    stats: {
        empresaId: number,
        empresaNome: string,
        count: number,
        avgNota: number,
    }[] = [];

    async getTrilhas() {
        const response = await axios.get("carregar-trilhas");
        this.listaDeTrilhas = response.data;
    }

    async getExpertises() {
        const response = await axios.get("carregar-expertises");
        this.listaDeExpertises = response.data;
    }

    async getStat() {
        const response = await axios.get(`avaliacao-por-trilha-expertise?trilhaId=${this.trilhaSelecionada}&expertiseId=${this.expertiseSelecionada}`);
        this.stats = response.data;

        this.chartData = {
            labels: response.data.map((s: any) => `${s.empresaNome} #${s.empresaId}`),
            datasets: [{ data: response.data.map((s: any) => s.count) }],
        };
    }

    mounted() {
        this.getTrilhas();
        this.getExpertises();
    }
}
</script>

<style lang="scss">
.porexpertise__container {
    position: relative;
    display: flex;
    flex-direction: column;
    min-height: 30vh;

    .header {
        display: flex;
        justify-content: space-between;
        margin-bottom: 2rem;
    }

    #select-trilha {
        border-radius: 4px;
        padding: 0.6rem;
        width: 250px;
        font-size: 0.8rem;
        margin-right: 1rem;
    }

    #select-expertise {
        border-radius: 4px;
        padding: 0.6rem;
        width: 250px;
        font-size: 0.8rem;
        margin-right: 1rem;
    }

    .container_head {
        position: relative;
        display: flex;
        flex-direction: row;
        align-items: baseline;
        width: 800px;
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
        min-height: 70vh;
    }
}
</style>
