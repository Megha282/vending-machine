package com.vendingmachine.beverages;

import java.util.List;

public abstract class Beverage {

    private final BeverageType type;
    private final List<Ingredient> ingredientList;

    public Beverage(BeverageType type, List<Ingredient> ingredientList) {
        this.type = type;
        this.ingredientList = ingredientList;
    }

    public BeverageType getType() {
        return type;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
