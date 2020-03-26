package com.example.lovecode;

public enum Singleton {
    INSTANCE;

    public Singleton getInstance() {
        return INSTANCE;
    }

    public void doSomeThing() {
        System.out.println("doSomeThing");
    }
}
