package com.vendingmachine.manager;

import com.vendingmachine.beverages.Beverage;
import com.vendingmachine.beverages.BeverageType;
import com.vendingmachine.beverages.Ingredient;
import com.vendingmachine.beverages.IngredientStore;
import com.vendingmachine.beverages.IngredientType;
import com.vendingmachine.beverages.Tea;
import com.vendingmachine.exceptions.OutOfStockException;

import java.util.ArrayList;
import java.util.List;

public class TeaManager implements BeverageManager {
    @Override
    public Beverage prepare() throws OutOfStockException {
        final List<Ingredient> ingredientsList = new ArrayList<>();
        final IngredientStore ingredientStore = IngredientStore.getInstance();
        final Ingredient milk = ingredientStore.takeIngredient(IngredientType.MILK, 10);
        final Ingredient water = ingredientStore.takeIngredient(IngredientType.WATER, 50);
        final Ingredient teaLeaves = ingredientStore.takeIngredient(IngredientType.TEA_LEAVES_SYRUP, 10);
        final Ingredient sugar = ingredientStore.takeIngredient(IngredientType.SUGAR_SYRUP, 10);
        ingredientsList.add(milk);
        ingredientsList.add(water);
        ingredientsList.add(teaLeaves);
        ingredientsList.add(sugar);
        return new Tea(BeverageType.TEA, ingredientsList);
    }
}
