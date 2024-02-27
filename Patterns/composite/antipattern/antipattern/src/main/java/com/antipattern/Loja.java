package com.antipattern;

import java.util.LinkedList;

public class Loja {
    private LinkedList<Loja> lojas = new LinkedList<>();  
    private LinkedList<Setor> setores = new LinkedList<>();  

    public void addLoja(Loja loja){
        lojas.add(loja);
    }

    public void addSetor(Setor setor){
        setores.add(setor);
    }
}
