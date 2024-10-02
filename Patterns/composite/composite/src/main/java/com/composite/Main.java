package com.composite;

public class Main {
    public static void main(String[] args) {
        Loja l = new Loja();
        Loja l1 = new Loja();
        Setor setor = new Setor();

        l.addItem(l1);
        l.addItem(setor);
    }
}