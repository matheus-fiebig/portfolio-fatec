<template>
    <div class="acompanhamento">
        <div class="acompanhamento__header">
            <h2>Acompanhamento de Partners</h2>

        </div>
        <div class="acompanhamento__content">
            <div class="acompanhamento__card">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Empresa</th>
                            <th>Partner</th>
                            <th>Progresso</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="item in progressos">
                            <td :key="1">{{ item.nomeEmpresa }}</td>
                            <td :key="2">{{ item.nomeColaborador }}</td>
                            <td>
                                <table class="acompanhamento__subtable">
                                    <thead>
                                        <tr>
                                            <th>Trilha</th>
                                            <th>Conclusão da Trilha</th>
                                            <th>Criticidade</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="trilha in item.dadosTrilha">
                                            <td>{{ trilha.nomeTrilha }}</td>
                                            <td>{{ Intl.DateTimeFormat('pt-BR').format(new
                                                Date(trilha.dataConclusaoTrilha)) }}</td>
                                            <td>
                                                <span :class="getCriticity(trilha)">&nbsp</span>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <div class="acompanhamento__legend">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th colspan="2">
                                    Legenda
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <span class="bg-danger">&nbsp;</span>
                                </td>
                                <td>
                                    Perto da expirar
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="bg-warning">&nbsp;</span>
                                </td>
                                <td>
                                    Na metade da validade
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="bg-success">&nbsp;</span>
                                </td>
                                <td>
                                    Longe de expirar
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">
import axios from 'axios'
import { DadosProgresso, DadosProgressoTrilha } from './acompanhamento.model';
import { onMounted, ref } from 'vue';

let progressos = ref<DadosProgresso[] | null>(null)

function getAllPartners() {
    axios.get("progresso-colaborador/progresso/1")
        .then(response => {
            progressos.value = [response.data as DadosProgresso];
        });
}

function getCriticity(item: DadosProgressoTrilha) {
    const startedAt = new Date(item.dataConclusaoTrilha);
    const today = new Date();
    const dueDate = new Date(startedAt);
    dueDate.setFullYear(startedAt.getFullYear() + item.validadeTrilha, startedAt.getMonth(), startedAt.getDate())

    const diffTime = (dueDate.getTime() - startedAt.getTime());
    const diffTimeRatio = (today.getTime() - startedAt.getTime());
    const ratio = diffTime / Math.max(diffTimeRatio, 1);

    if (diffTime <= 0 || ratio <= 1) return "bg-danger"
    if (ratio <= 2) return "bg-warning"
    return "bg-success";
}

onMounted(() => {
    getAllPartners();
})
</script>

<style lang="scss">
.acompanhamento {
    &__header {
        display: flex;
        justify-content: space-between;
        margin-left: 0px;
        margin-right: auto;
    }

    &__legend {
        display: flex;
        justify-content: flex-end;
        padding: 0px;
        width: 30%;
    }

    &__content {
        width: inherit;
        height: inherit;
        display: flex;
        flex-direction: column;
    }

    &__card {
        flex: 1;
        border-radius: 8px;
        min-height: 350px;
        padding: 20px;
        background-color: #ededed;
        box-shadow: 0px 5px 7px #cec9c9;
    }

    td,
    th {
        padding: 0px 15px;
    }

    &__subtable {
        width: 80%;
        height: 80px;
        overflow-y: auto;
        margin: auto;

        td,
        th {
            padding: 0px 15px;
        }
    }

    span {
        width: 30px;
        height: 30px;
        display: block;
        margin: auto;
        border-radius: 30px;
    }


}
</style>
