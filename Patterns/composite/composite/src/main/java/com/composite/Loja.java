package com.composite;

import java.util.LinkedList;

public class Loja implements Composite {
    private LinkedList<Composite> composites = new LinkedList<Composite>();

    public void addItem(Composite composite){
        composite.addItem(composite);
    }
}
