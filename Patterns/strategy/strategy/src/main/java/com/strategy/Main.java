package com.strategy;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

        pessoa.reclamar(new JovemEstrategia());
        pessoa.reclamar(new VelhoEstrategia());
    }
}