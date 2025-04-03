<template>
  <div class="rastreio">
    <div class="rastreio__header">
      <h2>Rastreio</h2>
    </div>
    <div class="rastreio__container">
      <div class="rastreio__card">
        <select class="form-select" v-model="selectedParceiro" @change="filtroNomeParceiro(selectedParceiro)">
          <option value="0">Cancelar filtro</option>
          <option v-for="nome in nomeColaborador" :key="nome.id" :value="nome.id">{{ nome.nome }}</option>
        </select>
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Partner</th>
              <th>Status</th>
              <th>Ação</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="nome in nomeColaboradorFiltrado.length > 0 ? nomeColaboradorFiltrado : nomeColaborador"
              :key="nome.nome" value="id">
              <td>{{ nome.nome }}</td>
              <td>
                <button type="button" class="btn btn-secondary" @click="abrirModal">
                  Ver Mais
                </button>
              </td>
              <td>
                <router-link :to="'/trilha/'+nome.id">
                  <button type="button" class="btn btn-outline-primary">
                    Acompanhar trilhas
                  </button>
                </router-link>
                <button type="button" @click="solicitarFeedback(nome.id)" class="btn btn-outline-primary" style="
                margin-right: -20;
                margin-left: 20px;
              ">
                  Solicitar Feedback
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

    </div>
  </div>
</template>

<script lang="ts">
import axios from "axios";
import Swal from "sweetalert2";

import { Options, Vue } from "vue-class-component";
import { RouterLink } from "vue-router";
@Options({
  name: "RastreioView",
  components: {
    RouterLink,
  },
})
export default class RastreioView extends Vue {
  nomeColaborador: {
    id: number,
    nome: string
  }[] = [];
  status: boolean = false;
  modalAberto: boolean = false;
  acompanhamentoTrilha: {
    nomeDatrilha: string;
    porcentagemEmanadamento: string;
  }[] = [];
  nomeColaboradorFiltrado: {
    id: number,
    nome: string
  }[] = [];
  selectedParceiro: number = 0;

  mounted() {
    this.getNomeParceiro();
  }


  async getNomeParceiro() {
    axios.get("/colaborador/1").then((response) => {
      this.nomeColaborador = response.data;
    });
  }

  filtroNomeParceiro(id: number) {
    if (id === 0) {
      this.nomeColaboradorFiltrado = [];
    } else {
      this.nomeColaboradorFiltrado = this.nomeColaborador.filter((nome) => nome.id === id);
    }
  }

  abrirModal() {
    this.modalAberto = true;

    axios
      .get("/progresso-colaborador/1")
      .then((response) => {
        this.acompanhamentoTrilha = [];
        this.acompanhamentoTrilha = response.data.map((item: any) => ({
          nomeDatrilha: item.nomeTrilha,
          porcentagemEmanadamento: item.porcentagemAndamento,
        }));

        if (this.acompanhamentoTrilha.length > 0) {
          this.acompanhamentoTrilha.forEach((item) => {
            Swal.fire({
              title: "Status",
              html: `
              <p>Nome da trilha: ${item.nomeDatrilha}</p>
              <p>Progresso do colaborador: ${item.porcentagemEmanadamento} %</p>
            `,
              showCloseButton: true,
              showConfirmButton: false,
            });
          });
        } else {
          Swal.fire({
            title: "Aviso",
            text: "Nenhum dado disponível para exibir",
            icon: "warning",
            showCloseButton: true,
          });
        }
      })
      .catch((error) => {
        Swal.fire({
          title: "Erro",
          text: "Erro ao obter dados da trilha",
          icon: "error",
          showCloseButton: true,
        });
      });
  }

  solicitarFeedback(colaboradorId: number) {
    axios.post("feedback/" + colaboradorId).then((r) => {
      Swal.fire({
        html: `Feedback solicitado ao partner`,
        showCloseButton: true,
        showConfirmButton: false,
      });
    });
  }

  fecharModal() {
    this.modalAberto = false;
  }
}
</script>

<style lang="scss">
.rastreio {
  select {
    width: 30%;
    margin-bottom: 20px;
  }

  &__header {
    display: flex;
    justify-content: flex-start;
    margin-left: 0px;
    margin-right: auto;
  }

  &__container {
    display: flex;
    flex-direction: column;
    width: inherit;
    height: inherit;
  }

  &__card {
    flex: 1;
    border-radius: 8px;
    min-height: 350px;
    padding: 20px;
    background-color: #ededed;
    box-shadow: 0px 5px 7px #cec9c9;
  }
}
</style>
