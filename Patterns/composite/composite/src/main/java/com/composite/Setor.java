package com.composite;

public class Setor implements Composite {
    @Override
    public void addItem(Composite composite) {
        System.out.println("AddedItem");
    }
}
