package com.strategy;

public class Pessoa {
    public void reclamar(ReclamarEstrategia estrategia){
        estrategia.reclamar();
    }
}
