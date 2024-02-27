package com.antipattern;

public class Setor {
    private Setor subsetor = new Setor();

    public void addSubSetor(Setor setor){
        subsetor = setor;
    }
}
