package ru.job4j.inheritance.icecream;

public class IceCream {
    private final int weight;

    public IceCream(int weight) {
        this.weight = weight;
    }

    public int price() {
        return weight * 100;
    }
}
