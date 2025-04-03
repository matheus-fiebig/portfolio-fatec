<template>
    <div class="VisualizacaoParceiros">
        <div class="header">
            <h2>Visualização de Partners</h2>
            <button @click="changePage" class="button">Cadastrar</button>
        </div>
        <div class="container">
            <div class="card">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Partner</th>
                            <th>Cidade</th>
                            <th>Código</th>
                            <th>País</th>
                            <th>Nome Admin</th>
                            <th>E-mail Admin</th>
                        </tr>
                    </thead>
                    <tbody v-if="listaParceiros && listaParceiros.length > 0">
                        <tr v-for="parceiro in listaParceiros">
                            <td>{{ parceiro.nome }}</td>
                            <td>{{ parceiro.cidade }}</td>
                            <td>{{ parceiro.codigo }}</td>
                            <td>{{ parceiro.pais }}</td>
                            <td>{{ parceiro.adminNome }}</td>
                            <td>{{ parceiro.adminEmail }}</td>
                        </tr>
                    </tbody>
                    <div v-else>
                        Nenhum partner encontrado.
                    </div>
                </table>


            </div>

        </div>
    </div>

    <div class="container">
      <div class="card">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Parceiro</th>
              <th>Código</th>
              <th>Cidade</th> 
              <th>estado</th>   
              <th>País</th>
              <th>Nome Admin</th>
              <th>E-mail Admin</th>
            </tr>
          </thead>
          <tbody v-if="listaParceiros && listaParceiros.length > 0">
            <tr v-for="parceiro in listaParceiros" :key="parceiro.codigo" @click="editParceiro(parceiro)">
              <td>{{ parceiro.nome }}</td>
              <td>{{ parceiro.codigo }}</td>
              <td>{{ parceiro.cidade }}</td>
              <td>{{ parceiro.estado }}</td>
              <td>{{ parceiro.pais }}</td>
              <td>{{ parceiro.adminNome }}</td>
              <td>{{ parceiro.adminEmail }}</td>
              
            </tr>
          </tbody>
          <div v-else>
            Nenhum parceiro encontrado.
          </div>
        </table>
      </div>
    </div>

    <div class="modal" :class="{ 'is-active': showModal }">
      <div class="modal-background" @click="closeModal"></div>
      <div class="modal-content">
        <h2>Atualizar</h2>
        <form @submit.prevent="atualizarParceiro">
          <input type="text" v-model="parceiro.nome" required>
          <input type="text" v-model="parceiro.codigo" required>
          <input type="text" v-model="parceiro.cidade" required>
          <input type="text" v-model="parceiro.estado" required>
          <input type="text" v-model="parceiro.pais" required>
          <input type="text" v-model="parceiro.adminNome" required>
          <input type="text" v-model="parceiro.adminEmail" required>

          <button type="submit">Atualizar</button>
        </form>
      </div>
      <button class="modal-close is-large" aria-label="close" @click="closeModal">x</button>
    </div>
  </div>
</template>

<script lang="ts">
import axios from "axios";
import { Options, Vue } from "vue-class-component";
import Swal from "sweetalert2";
@Options({
  name: "visualizacaoParceiros",
})
export default class VisualizacaoParceiros extends Vue {
  listaParceiros: any[] = [];
  showModal: boolean = false;
  parceiro: any = {}; 

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

  editParceiro(parceiro: any) {
    this.parceiro = parceiro;
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
  }

  async atualizarParceiro() {
    try {
      
       await axios.put(`atualizar-empresas/${this.parceiro.id}`, this.parceiro);
       Swal.fire("Sucesso", "Parceiro atualizado com sucesso", "success");
    
      this.showModal = false;
      await this.getParceiros();
    } catch (error) {
      Swal.fire("Erro", "Falha ao atualizar parceiro", "error");

      console.log(this.parceiro.id);
      console.log(this.parceiro);

      console.log("Erro ao atualizar parceiro:", error);
    }
  }
  

  changePage() {
    this.$router.push({ name: 'cadastro' });
  }
}
</script>

<style lang="scss">
.VisualizacaoParceiros {
  .header {
    margin-bottom: 10px;
    padding-right: 12px;
    display: flex;
    justify-content: space-between;
    margin-left: 0px;
    margin-right: auto;
}

.container {
    padding-left: 0px;
    max-width: inherit;
    height: inherit;
    display: flex;
    flex-direction: column;
}

.card {
    flex: 1;
    border-radius: 8px;
    min-height: 350px;
    padding: 20px;
    background-color: #ededed;
    box-shadow: 0px 5px 7px #cec9c9;
}

.button {
    padding: 0.5rem 1rem;
    border: none;
    border-radius: 5px;
    background-color: rgba(79, 79, 79, 1);
    color: white;
    cursor: pointer;
    transition: background-color 0.3s ease;
    &:hover {
        background-color: #0e0e0e;
    }
}
}

.modal {
  display: none;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal.is-active {
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-background {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px; /* Cantos mais arredondados */
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); /* Sombra para efeito de profundidade */
  max-width: 400px; /* Largura máxima do modal */
  width: 100%;
}

.modal h2 {
  margin-top: 0;
}

.modal form {
  display: flex;
  flex-direction: column;
}

.modal input {
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 16px; /* Tamanho da fonte aumentado */
}

.modal button {
  padding: 12px 20px;
  margin-top: 10px;
  border: none;
  border-radius: 5px;
  background-color: #181919;
  color: #fff;
  cursor: pointer;
  transition: background-color 0.3s ease;
  font-size: 16px; /* Tamanho da fonte aumentado */
}

.modal button:hover {
  background-color: #575b62;
}

.modal-close {
  position: absolute;
  top: 15px;
  right: 15px;
  background: none;
  border: none;
  cursor: pointer;
}

</style>
