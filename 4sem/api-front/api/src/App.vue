<template>
    <div class="page">
        <nav class="menu">
            <div class="menu__logo">
                <img src="./assets/logo.png">
            </div>
            <div class="menu__links">
                <router-link to="/visualizacaoparceiro">Partners</router-link>
                <router-link to="/rastreio">Rastreio</router-link>
                <router-link to="/acompanhamento">Acompanhamento</router-link>
                <router-link to="/visualizacao">Habilidades</router-link>
                <router-link to="/avaliacao">Avaliações</router-link>
                <router-link to="/Dashboard">Dashboard</router-link>
                <router-link to="/notificacoes">Configurações</router-link>
                        <router-link to="/por-estado-mapa">Partners por Estado</router-link>
            </div>
        </nav>

        <div class="content">
            <router-view />
        </div>

        <div class="footer">
            <img src="./assets/logo.png">
        </div>
    </div>
</template>

<style lang="scss">
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}

body {
    margin: 0px !important;
}

.page {
    background-color: #f5f5f5;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    width: 100vw;
    padding: 0;
    margin: 0;
}

.menu {
    background-color: #464444;
    width: 100vw;
    height: 60px;
    display: grid;
    grid-template-columns: auto;
    justify-items: center;
    align-items: center;
    text-align: center;
    grid-template-columns: 200px max-content;
}

.menu__logo {
    margin-left: 25px;
    display: flex;
    align-content: center;

    img {
        height: 47px;
        margin: auto 0;
    }
}

.menu__links {
    margin: 0 auto;
    display: flex;
    width: 100%;

    align-items: center;
    flex-direction: row;
    text-align: center;

    a {
        color: white;
        text-decoration: none;
        min-width: fit-content;
        margin: 0 15px;
        padding-left: 15px;
    }

    justify-content: space-around;
}



.content {
    flex: 1;
    padding: 60px 20px 0 20px;
    margin-bottom: 20px;
}

.footer {
    display: flex;
    align-items: flex-end;
    justify-content: flex-end;
    width: 100%;
    height: 43px;
    border-top: 1px solid black;

    img {
        margin-right: 20px;

    }
}

table {
    --bs-table-color-type: initial !important;
    --bs-table-bg-type: initial !important;
    --bs-table-color-state: initial !important;
    --bs-table-bg-state: initial !important;
    --bs-table-color: initial !important;
    --bs-table-bg: initial !important;
    --bs-table-border-color: initial !important;
    --bs-table-accent-bg: transparent !important;
    --bs-table-striped-color: initial !important;
    --bs-table-striped-bg: initial !important;
    --bs-table-active-color: initial !important;
    --bs-table-active-bg: initial !important;
    --bs-table-hover-color: initial !important;
    --bs-table-hover-bg: initial !important;
    width: 100%;
    margin-bottom: 1rem;
    vertical-align: top;
    border-color: var(--bs-table-border-color);
}
</style>
