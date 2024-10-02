package com.antipattern;

public class Main {
    public static void main(String[] args) {
        Setor s1 = new Setor();
        Setor ss1 = new Setor();

        s1.addSubSetor(ss1);

        Loja l1 = new Loja();
        Loja l2 = new Loja();
        
        l1.addLoja(l2);
        l1.addSetor(s1);
    }
}