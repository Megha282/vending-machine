package com.vendingmachine.beverages;

public class Ingredient {

    private final IngredientType type;
    private final int quantity;

    public Ingredient(final IngredientType type,
                      final int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public IngredientType getIngredientType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}
