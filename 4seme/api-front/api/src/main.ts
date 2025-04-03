import axios from "axios";
import { createApp } from "vue";

import App from "./App.vue";
import router from "./router";

import "bootstrap/dist/css/bootstrap.css";
import 'leaflet/dist/leaflet.css';

axios.defaults.baseURL = "http://localhost:8080/api/";
createApp(App).use(router).mount("#app");
