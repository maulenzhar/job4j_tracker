package ru.job4j.inheritance.pizza;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String TOMATO = "extra tomato";

    @Override
    public String name() {
        return super.name() + " + " + TOMATO;
    }
}
