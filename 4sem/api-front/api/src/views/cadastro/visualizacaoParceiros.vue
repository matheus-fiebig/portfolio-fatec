<template>
    <div>
        <h2 style="width: 1100px; margin: 1rem auto; text-align: left;">Visualização de Partners</h2>
        <div class="container">
            <div class="parceiro-header">
                <span class="header-item">Partner</span>

                <span class="header-item">Cidade</span>
                <span class="header-item">Código</span>
                <span class="header-item">País</span>
                <span class="header-item">Nome do Colaborador</span>
            </div>
            <div v-if="listaParceiros && listaParceiros.length > 0">
                <div class="parceiro" v-for="parceiro in listaParceiros" :key="parceiro.id">
                    <span class="parceiro-item">{{ parceiro.nome }}</span>
                    <span class="parceiro-item">{{ parceiro.cidade }}</span>
                    <span class="parceiro-item">{{ parceiro.codigo }}</span>
                    <span class="parceiro-item">{{ parceiro.pais }}</span>
                    <span class="parceiro-item">{{ parceiro.adminNome }}</span>
                </div>
            </div>
            <div v-else>
                Nenhum partner encontrado.
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import axios from "axios";
import { Options, Vue } from "vue-class-component";
import { RouterLink } from "vue-router";


@Options({
  name: "visualizacaoParceiros",
  components: {
    RouterLink,
  },
})
export default class VisualizacaoParceiros extends Vue {
    listaParceiros: any[] = [];

    async mounted() {
        await this.getParceiros();
    }

    async getParceiros() {
        try {
            const response = await axios.get("carregar-empresas");
            console.log(response.data);
            this.listaParceiros = response.data;
        } catch (error) {
            console.log("Erro:", error);
        }
    }
}
</script>

<style lang="scss">
.container {
    position: relative;
    display: flex;
    flex-direction: column;
    width: 1100px;
    min-height: 60vh;
    margin: auto;
    border-radius: 20px;
    background-color: #ededed;
    opacity: 1;
    padding: 2rem 5rem;
    box-shadow: 3px 5px 10px #555;
  }
  
  .parceiro-header {
    display: flex;
    justify-content: space-between;
    border-bottom: 1px solid #ccc;
    padding-bottom: 0.5rem;
    font-weight: bold;
  }
  
  .header-item {
    width: calc(100% / 6); 
  }
  
  .parceiro {
    display: flex;
    justify-content: space-between;
    border-bottom: 1px solid #ccc;
    padding-top: 0.2rem;
    padding-bottom: 0.8rem;
  }
  
  .parceiro-item {
    width: calc(100% / 6); 
  }
</style>
