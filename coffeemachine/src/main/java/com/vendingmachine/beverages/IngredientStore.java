package com.vendingmachine.beverages;

import com.vendingmachine.exceptions.OutOfStockException;

import java.util.HashMap;
import java.util.Map;

public class IngredientStore {

    private final Map<IngredientType, Integer> capacityMap = new HashMap<>();

    private static final IngredientStore INGREDIENT_STORE = new IngredientStore();


    public IngredientStore() {
        capacityMap.put(IngredientType.MILK, 100);
        capacityMap.put(IngredientType.WATER, 100);
        capacityMap.put(IngredientType.COFFEE_SYRUP, 300);
        capacityMap.put(IngredientType.ELAICHI_SYRUP, 500);
        capacityMap.put(IngredientType.SUGAR_SYRUP, 500);
        capacityMap.put(IngredientType.TEA_LEAVES_SYRUP, 500);
        capacityMap.put(IngredientType.GINGER_SYRUP, 500);
    }

    public static IngredientStore getInstance() {
        return INGREDIENT_STORE;
    }

    public synchronized Ingredient takeIngredient(final IngredientType ingredientType, int amount) throws OutOfStockException {
        if (capacityMap.get(ingredientType) < amount) {
            throw new OutOfStockException( "Ingredients not available :: " + ingredientType.name());
        }

        capacityMap.put(ingredientType, capacityMap.get(ingredientType) - amount);
        return new Ingredient(ingredientType, amount);
    }

    public void refillIngredient(final IngredientType ingredientType){
        switch (ingredientType){
            case MILK:
                capacityMap.put(IngredientType.MILK, 100);
            case WATER:
                capacityMap.put(IngredientType.WATER, 100);
            case SUGAR_SYRUP:
                capacityMap.put(IngredientType.SUGAR_SYRUP, 500);
            case COFFEE_SYRUP:
                capacityMap.put(IngredientType.COFFEE_SYRUP, 300);
            case GINGER_SYRUP:
                capacityMap.put(IngredientType.GINGER_SYRUP, 500);
            case ELAICHI_SYRUP:
                capacityMap.put(IngredientType.ELAICHI_SYRUP, 500);
            case TEA_LEAVES_SYRUP:
                capacityMap.put(IngredientType.TEA_LEAVES_SYRUP, 500);
        }
    }
}
