<template>
  <h2>Dashboard Partners</h2>
  <div class="porestadomapa">
    <div id="map-container" style="height: 600px;width: 600px;"></div>
    <div class="legenda">
      <p>Partners Total: {{ parceirosTotal }}</p>
      <div class="legend-item">
        <span class="color-box zero"></span>
        <span class="label">Sem partners</span>
      </div>
      <div class="legend-item">
        <span class="color-box low"></span>
        <span class="label">1-5 (%)</span>
      </div>
      <div class="legend-item">
        <span class="color-box medium"></span>
        <span class="label">6-10 (%)</span>
      </div>
      <div class="legend-item">
        <span class="color-box high"></span>
        <span class="label">&gt; 10 (%)</span>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import axios from "axios";
import { Options, Vue } from "vue-class-component";
import * as L from 'leaflet';
import brazil from "@/assets/brazil.json";

@Options({})
export default class PorEstadoMapa extends Vue {
  map: any;
  parceirosTotal: number = 0;

  colorScale(value: number) {
    if (value == 0) {
      return "#F5F5F5";
    } else if (value <= 5) {
      return '#ADD8E6';
    } else if (value <= 10) {
      return '#1E90FF';
    } else {
      return '#191970';
    }
  };

  async renderMap() {
    const data = (await axios.get("/empresas-por-estado")).data;
    this.map = L.map('map-container').setView([-14.2350, -56.4757], 4);
    L.geoJson(brazil as any, {
      style: (feature: any) => ({
        fillColor: this.colorScale(data[feature?.properties?.name as any] || 0),
        fillOpacity: 0.7,
        weight: 2
      })
    }).addTo(this.map);
    this.parceirosTotal = Object.keys(data).reduce((sum, key) => sum + parseFloat(data[key] || 0), 0);
  }

  mounted() {
    this.renderMap();
  }
}
</script>

<style>
.porestadomapa {
  display: flex;
  min-height: 40vh;
  justify-content: center;
  align-items: center;

  flex-direction: row;
  gap: 2rem;
  border-radius: 8px;
  background-color: #ededed;
  margin-bottom: 10px;
  padding: 20px;
  box-shadow: 3px 5px 10px #555;

  .header {
    display: flex;
    justify-content: space-between;
  }

  .legend-item {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
  }

  .color-box {
    width: 20px;
    height: 20px;
    margin-right: 10px;
  }

  .zero {
    background-color: #F5F5F5;
  }

  .low {
    background-color: #ADD8E6;
  }

  .medium {
    background-color: #1E90FF;
  }

  .high {
    background-color: #191970;
  }

  .label {
    font-size: 14px;
  }
}
</style>
