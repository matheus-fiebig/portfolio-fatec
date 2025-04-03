<template>
    <div class="home">
    </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import LacunaView from "./lacuna/LacunaView.vue";

@Options({
    components: {
        LacunaView,
    },
})
export default class HomeView extends Vue { }
</script>
