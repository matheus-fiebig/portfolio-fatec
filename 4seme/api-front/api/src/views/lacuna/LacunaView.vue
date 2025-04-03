<template>
    <div class="lacuna">
        <div class="lacuna__header">
            <h4>Lacunas e Habilidades</h4>
        </div>
        <div class="lacuna__content">
            <div class="lacuna__card">
                <h3>Trilhas</h3>
                <br>
                    <div class="lacuna__trilha" v-for="(trilha,i) in integracoes">
                        <table align="center" class="table table-striped" style="margin:auto">
                                <thead>
                                    <tr>
                                        <th  colspan="2"><i>{{ trilha.nomeTrilha }}</i></th>
                                    </tr>
                                    <tr>
                                        <th>
                                            Trilhas do curso    
                                        </th>
                                        <th>
                                            Trilhas concluidas    
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <span v-for="naoConcluida in trilha.expertisesPorTrilha.nome">
                                                {{naoConcluida}}<br/>
                                            </span>
                                            
                                        </td>
                                        <td>
                                            <span  v-for="concluida in trilha.expertisesConcluidas.nome">
                                                {{concluida}}<br/>
                                            </span></td>
                                    </tr>
                                </tbody>
                        </table>
                        <br>
                        <div class="title" style="display: flex; justify-content: start; width: 100%;">
                            <span align="left">
                                Percentagem de conclusão da trilha - {{ 100*(trilha.expertisesConcluidas.id.length / trilha.expertisesPorTrilha.id.length) + '%' }}
                            </span>
                        </div>
                        <div id="lacuna__percentage" style="width: 100%; display: flex;">
                            <div class="blue" :id="'percentagem-ok'+i">&nbsp;</div>
                            <div class="red" :id="'percentagem-nok'+i">&nbsp;</div>
                        </div>
                    </div>
            </div>
    </div>
</div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import axios from 'axios';
@Options({

})
export default class LacunaView extends Vue {
    colaboradorSelecionado = 0;
    integracoes = []

    created() {
        this.colaboradorSelecionado = +this.$route.params.id
        console.log(this.colaboradorSelecionado)
        this.getProgressoTrilhas() 
    }

    getProgressoTrilhas(){
        axios.get('progresso-colaborador/habilidades/'+this.colaboradorSelecionado)
            .then(x => {
                this.integracoes = x.data
                this.integracoes.forEach((inte:any, i)=> {
                    let ok = "percentagem-ok"+i;
                    let nok = "percentagem-nok"+i;
                    let porcentagemConclusao = (inte.expertisesConcluidas.id.length / inte.expertisesPorTrilha.id.length);
                    setTimeout(() => {
                        document.getElementById(ok)!.style.width = `${(porcentagemConclusao) * 100}%`
                        document.getElementById(nok)!.style.width = `${(1 - porcentagemConclusao) * 100}%`
                    }, 500)
                    
                })
            })
    }

}
</script>

<style lang="scss">
.lacuna {
    &__header {
        display: flex;
        justify-content: left;
    }

    &__content {
        gap: 5%;
        width: inherit;
        height: inherit;
        display: flex;
        flex-direction: row;
    }

    .blue{
        background-color: blue;
    }

    .red{
        background-color: red;
    }
    
    &__card {
        flex: 1;
        border-radius: 8px;
        min-height: 250px;
        padding: 20px;
        background-color: #ededed;
        box-shadow: 0px 5px 7px #cec9c9;
    }
    
    &__trilha{
        display: flex;
        align-items: center; 
        flex-direction: column;
        width: 100%;
        height: 50%;
    }

     th{
            width: 50%;
        }
}

</style>
