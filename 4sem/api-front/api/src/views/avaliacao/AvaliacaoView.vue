<template>
    <div class="avaliacao">
        <div class="avaliacao__header">
            <h4>Avaliação de Partners</h4>
        </div>
        <div class="avaliacao__content">
            <div class="avaliacao__card" v-for="ava in avaliacoes" :key="ava.id">
                <div class="avaliacao__card-header">
                    <div class="logo"><img
                            src="data:image/png;base64,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">
                    </div>
                    <span> {{ ava.empresaNome }}</span>
                </div>
                <div class="avaliacao__row">
                    <span class="header">Colaborador:</span>
                    <span class="value">{{ ava.colaboradorNome }}</span>
                </div>
                <hr class="avaliacao__hr">
                <div class="avaliacao__row">
                    <span class="header">Trilha:</span>
                    <span class="value">{{ ava.trilhaWorkload }}</span>
                </div>
                <div class="avaliacao__row">
                    <span class="header">Expertise:</span>
                    <span class="value">{{ ava.expertiseNome }}</span>
                </div>
                <hr class="avaliacao__hr">
                <div class="avaliacao__row">
                    <span class="header">Feedback:</span>
                    <span class="value">{{ ava.feedback }}</span>
                </div>
                <div class="avaliacao__row">
                    <span class="header">Nota:</span>
                    <input type="number" disabled v-model="ava.nota" class="form-control avaliacao__input" max="5" min = 1>
                </div>
                <div class="avaliacao__row-right">
                    <button class="btn btn-outline-success btn-block" v-if="false" style="width:100%;"
                        v-on:click="salvarNota(ava)">Salvar Avaliação</button>
                </div>
            </div>
        </div>
        <router-link class="btn btn-primary mt-5" to="/por-expertise">Avaliações de Parceiros por Expertise</router-link>
    </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue';
import axios from 'axios'
import Swal from 'sweetalert2';

let avaliacoes = ref<any[]>([])

function salvarNota(data: any) {
    axios.post("avaliacoes/criar-avaliacao", {
        nota: +data.nota,
        dataAvaliacao: new Date(),
        expertiseId: data.expertiseId,
        trilhaId: data.trilhaId,
        feedback: data.feedback,
        empresaId: data.empresaId,
        colaboradorId: data.colaboradorId
    })
        .then(() => {
            const toast = Swal.mixin({
                toast: true,
                position: "top-end",
                showConfirmButton: false,
                timer: 3000,
                timerProgressBar: true,
                didOpen: (toast) => {
                    toast.onmouseenter = Swal.stopTimer;
                    toast.onmouseleave = Swal.resumeTimer;
                }
            });
            toast.fire({
                icon: "success",
                title: "Signed in successfully"
            });
        });
}

function loadData(empresas: any[]) {
    for (let i = 0; i < empresas.length; i++) {
        let emp = (empresas[i] as any).id
        loadAvalicaoes(emp)
    }
}

function loadAvalicaoes(emp: number) {
    axios.get(`avaliacoes/${emp}`)
        .then(x => {
            if (x.data && x.data.length > 0) {
                for (let index = 0; index < x.data.length; index++) {
                    const element = x.data[index];
                    avaliacoes.value.push(element)
                }
            }
        })

}


onMounted(() => {
    axios
        .get("carregar-empresas")
        .then(x => {
            loadData(x.data)
        });

})
</script>

<style lang="scss">
.avaliacao {
    &__header {
        display: flex;
        justify-content: left;
    }

    &__content {
        gap: 1%;
        justify-content: space-between;
        width: 99%;
        height: inherit;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
    }

    &__card {
        border-radius: 8px;
        min-height: 225px;
        width: 20%;
        margin-bottom: 30px;
        background-color: #ededed;
        box-shadow: 0px 5px 7px #cec9c9;

        &-header {
            border-top-right-radius: 8px;
            border-top-left-radius: 8px;
            width: 100%;
            height: 30px;
            display: flex;
            padding: 0 10px;
            align-items: center;
            justify-content: space-between;
            background-color: #464444;
            margin-bottom: 10px;

            span {
                font-weight: 600;
                color: whitesmoke;
            }
        }
    }

    &__row {
        padding: 0px 10px;
        display: flex;
        justify-content: space-between;

        &-right {
            padding: 15px 10px;
            display: flex;
            justify-content: flex-end;
        }
    }

    &__input {
        width: 165px !important;
        height: 23px !important;
        text-align: center;
        padding-left: 25px !important;
    }

    &__col {
        width: 100%;
        display: flex;
    }

    .header {
        font-weight: 600;
    }

    .value{
        width:165px;
    }

    .logo {
        img {
            margin: auto 0;
            height: 25px;
        }
    }

    &__hr {
        margin: 1rem 1rem !important;
        color: inherit !important;
        border: 0 !important;
        border-top: var(--bs-border-width) solid !important;
        opacity: 0.25 !important;
    }
}
</style>
