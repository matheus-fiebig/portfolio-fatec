<template>
    <div class="CadastroParceiros">
        <h2 style="width: 1100px; margin: 1rem auto; text-align: left;">Cadastro de Partners</h2>
        <button class="button" @click="cadastrarParceiro">Cadastrar</button>

        <div class="container">
            <form>
                <div class="form-row">
                    <div class="form-group">
                        <label for="nome">Colaborador</label>
                        <input type="text" id="nome" name="nome" v-model="nome" required>
                    </div>
                    <div class="form-group" >
                        <label2 for="nome">Código </label2>
                        <input type="text" id="codigo" name="codigo" v-model="codigo" required>
                    </div>
                    <div class="form-group">
                        <label for="cidade">Cidade</label>
                        <input type="text" id="cidade" name="cidade" v-model="cidade" required placeholder="SJC">
                    </div>
                    <div class="form-group">
                        <label for="cidade">Estado</label>
                        <input type="text" id="estado" name="estado" v-model="estado" required placeholder="São Paulo">
                    </div>
                    <div class="form-group">
                        <label for="pais">País</label>
                        <input type="text" id="pais" name="pais" v-model="pais" required placeholder="Brasil"
                            :list="listaPaises">
                        <datalist id="paises">
                            <option v-for="pais in paises" :value="pais">{{ pais }}</option>
                        </datalist>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" v-model="email" required>
                    </div>
                    <div class="form-group centralizado">
                        <label2 for="nome">Nome da empresa </label2>
                        <input type="text" id="adminNome" name="adminNome" v-model="adminNome" required>
                    </div>
                    

                </div>
            </form>


        </div>
    </div>
</template>

<script lang="ts">
import axios from "axios";
import { Options, Vue } from "vue-class-component";
import { RouterLink } from "vue-router";
import Swal from "sweetalert2";

@Options({
    name: "CadastroParceiros",
    components: {
        RouterLink,
    },
})
export default class CadastroParceiros extends Vue {
    nome: string = "";
    cidade: string = "";
    pais: string = "";
    email: string = "";
    adminNome: string = "";
    codigo: string = "";
    paises: string[] = ['Brasil', 'Estados Unidos', 'Canadá', 'Reino Unido', 'França', 'China'];
    estado: string = "";

    get listaPaises(): string {
        return this.paises.join(",");
    }


    cadastrarParceiro(): void {
        if (!this.nome || !this.cidade || !this.pais || !this.email || !this.adminNome || !this.codigo) {
            Swal.fire({
                title: "ops...",
                text: "Por favor, preencha todos os campos.",
                icon: "warning",
                showCloseButton: true,
            });

            return;
        }
        if (!this.validateEmail(this.email)) {
            Swal.fire({
                title: "ops...",
                text: "Por favor, insira um email válido.",
                icon: "warning",
                showCloseButton: true,
            });

            return;
        }
        if (!this.validateNome(this.nome)) {
            Swal.fire({
                title: "ops...",
                text: "Por favor, insira o nome com a primeira letra maiúscula.",
                icon: "warning",
                showCloseButton: true,
            });
            return;
        }
        if (!this.validatePais(this.pais)) {
            Swal.fire({
                title: "ops...",
                text: "Por favor, selecione um país válido.",
                icon: "warning",
                showCloseButton: true,
            });
            return;
        }
        const codigoNumero = Number(this.codigo);
        if (isNaN(codigoNumero)) {
            Swal.fire({
                title: "ops...",
                text: "Por favor, insira um código válido (números apenas).",
                icon: "warning",
                showCloseButton: true,
            });
            return;
        }

        const parceiro = {
            codigo: this.codigo,
            nome: this.nome,
            cidade: this.cidade,
            pais: this.pais,
            adminNome: this.adminNome,
            adminEmail: this.email,
            estado: this.estado,
        };

        axios.post('/criar-empresas', parceiro)
            .then(response => {
                Swal.fire({
                    text: "Partner cadastrado com sucesso ",
                    icon: "success",
                    showConfirmButton: false,
                    timer: 2000
                });
                this.resetForm();
            })
            .catch(error => {
                console.error('Erro ao cadastrar partner:', error);
                Swal.fire({
                    title: "ops...",
                    text: "Erro ao cadastrar partner",
                    icon: "error",
                    showCloseButton: true,
                });
                console.log(parceiro);
            });
    }

    validateEmail(email: string): boolean {
        const re = /\S+@\S+\.\S+/;
        return re.test(email);
    }

    validateNome(nome: string): boolean {
        if (nome.length === 0) {
            return false;
        }
        return nome[0] === nome[0].toUpperCase();
    }

    validatePais(pais: string): boolean {
        return this.paises.includes(pais);
    }

    resetForm(): void {
        this.nome = "";
        this.cidade = "";
        this.pais = "";
        this.email = "";
        this.codigo = "";
        this.estado = "";
        this.adminNome = "";
    }
}
</script>

<style lang="scss">
.CadastroParceiros {
    .button {
        padding: 0.5rem 1rem;
        border: none;
        border-radius: 5px;
        background-color: rgba(79, 79, 79, 1);
        color: white;
        cursor: pointer;
        transition: background-color 0.3s ease;
        position: absolute;
        top: 18%;
        right: 20%;

        &:hover {
            background-color: #0e0e0e;
        }
    }

    .error {
        color: red;
    }

    .container {
        position: relative;
        display: flex;
        flex-direction: column;
        width: 1099px;
        min-height: 60vh;
        margin: auto;
        border-radius: 20px;
        background-color: #ededed;
        opacity: 1;
        gap: 3rem;
        padding: 2rem 5rem;
        box-shadow: 3px 5px 10px #555;

        .form-row {
            display: flex;
            flex-wrap: wrap;
            gap: 1rem;
        }

        .form-group {
            flex: 1;
            display: flex;
            flex-direction: column;
            margin-bottom: 1rem;
            color: black;

            label {
                margin-bottom: 0.5rem;

            }

            label2 {
                margin-bottom: 0.5rem;
                margin-right: 5%;

            }

            input {
                padding: 0.5rem;
                border-radius: 10px;
                border: 1px solid #ccc;
                height: 30px;
                width: 300px;
            }


        }
        .form-group.centralizado {
            margin-right: 65%; 
        }
    

    }

}
</style>