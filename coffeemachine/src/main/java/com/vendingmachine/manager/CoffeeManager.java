package com.vendingmachine.manager;

import com.vendingmachine.beverages.Beverage;
import com.vendingmachine.beverages.BeverageType;
import com.vendingmachine.beverages.Coffee;
import com.vendingmachine.beverages.Ingredient;
import com.vendingmachine.beverages.IngredientStore;
import com.vendingmachine.beverages.IngredientType;
import com.vendingmachine.exceptions.OutOfStockException;

import java.util.ArrayList;
import java.util.List;

public class CoffeeManager implements BeverageManager {

    @Override
    public Beverage prepare() throws OutOfStockException {
        final IngredientStore ingredientStore = IngredientStore.getInstance();
        final List<Ingredient> ingredientsList = new ArrayList<>();
        final Ingredient milk = ingredientStore.takeIngredient(IngredientType.MILK, 10);
        final Ingredient water = ingredientStore.takeIngredient(IngredientType.WATER, 50);
        final Ingredient coffee = ingredientStore.takeIngredient(IngredientType.COFFEE_SYRUP, 10);
        final Ingredient sugar = ingredientStore.takeIngredient(IngredientType.SUGAR_SYRUP, 10);
        ingredientsList.add(milk);
        ingredientsList.add(sugar);
        ingredientsList.add(water);
        ingredientsList.add(coffee);
        return new Coffee(BeverageType.COFFEE, ingredientsList);
    }

}
