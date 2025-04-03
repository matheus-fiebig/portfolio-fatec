<template>
    <div class="notificacao">
        <div class="notificacao__header">
            <h2>Configuração de Notificações</h2>
        </div>
        <div class="notificacao__content">
            <div class="notificacao__card">
                <div class="notificacao__row">
                    <div class="notificacao__row-header">
                        <h4>Solicitações</h4>
                    </div>
                    <hr />
                    <div class="notificacao__input">
                        <h6>Dias para solicitar feedback</h6>
                        <input class="form-control" v-model="feedback" />
                    </div>
                </div>
                <div class="notificacao__row">
                    <div class="notificacao__row-header">
                        <h4>Avisos</h4>
                    </div>
                    <hr />
                    <div class="notificacao__input">
                        <h6>Dias para avisar sobre vencimento da trilha</h6>
                        <input class="form-control" v-model="vencimentoTrilha" />
                    </div>
                </div>
                <div class="notificacao__row">
                    <div class="notificacao__row-header">
                        <h4>Backup</h4>
                    </div>
                    <hr />
                    <div class="notificacao__input">
                        <h6>Data do último backup</h6>
                        <div style="color:green">{{ getUltimoBackup() }}</div>
                    </div>
                </div>
                <div class="notificacao__row--right">
                    <button v-on:click="atualizar()" class="btn btn-outline-success">Salvar</button>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">
import axios from "axios";
import Swal from "sweetalert2";
import { onMounted, ref } from "vue";
let vencimentoTrilha = ref<number>(0);
let feedback = ref<number>(0);

function atualizar() {
    const request = [
        {
            frequenciaDias: vencimentoTrilha.value,
            tipoNotificacao: "AVISO",
        },
        {
            frequenciaDias: feedback.value,
            tipoNotificacao: "FEEDBACK",
        },
    ];

    axios.put("configuracao", request).then((x) => {
        Swal.fire({
            title: "Sucesso",
            text: "Configurações salvas com sucesso",
            icon: "success",
            showCloseButton: true,
        });
    });
}

function getUltimoBackup(){
    let currentDate = new Date();
    let oneHourAgo = new Date(currentDate.getTime() - 3600000);
    return formatDate(oneHourAgo);
}

function formatDate(date:Date) {
    let day = String(date.getDate()).padStart(2, '0');
    let month = String(date.getMonth() + 1).padStart(2, '0'); 
    let year = date.getFullYear();
    let hours = String(date.getHours()).padStart(2, '0');
    let minutes = String(date.getMinutes()).padStart(2, '0');

    return `${day}/${month}/${year} ${hours}:${minutes}`;
}


onMounted(() => {
    axios.get("configuracao").then((x) => {
        vencimentoTrilha.value = +x.data.filter((x: any) => x.tipo === "AVISO").map((x: any) => x.frequencia)[0]
        feedback.value = +x.data.filter((x: any) => x.tipo === "FEEDBACK").map((x: any) => x.frequencia)[0]
    });
});
</script>

<style lang="scss">
.notificacao {
    &__row {
        width: 100%;
        display: flex;
        flex-direction: column;
        align-content: flex-start;
        flex-wrap: wrap;
        margin-bottom: 30px;

        &--right {
            width: 100%;
            display: flex;
            flex-direction: column;
            flex-wrap: wrap;
            align-content: flex-end;
            margin-top: 15px;
        }
    }

    &__input {
        align-items: flex-start;
        display: flex;
        flex-direction: column;
        width: 30%;
        height: 30px;
        gap: 40px;
        justify-content: center;
        flex-wrap: wrap;
    }

    &__row-header {
        display: flex;
    }

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

    hr {
        width: 100%;
    }
}
</style>
