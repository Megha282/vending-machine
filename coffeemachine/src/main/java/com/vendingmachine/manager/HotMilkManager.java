package com.vendingmachine.manager;

import com.vendingmachine.beverages.Beverage;
import com.vendingmachine.beverages.BeverageType;
import com.vendingmachine.beverages.HotMilk;
import com.vendingmachine.beverages.Ingredient;
import com.vendingmachine.beverages.IngredientStore;
import com.vendingmachine.beverages.IngredientType;
import com.vendingmachine.exceptions.OutOfStockException;

import java.util.ArrayList;
import java.util.List;

public class HotMilkManager implements BeverageManager {

    @Override
    public Beverage prepare() throws OutOfStockException {
        final IngredientStore ingredientStore = IngredientStore.getInstance();
        final Ingredient milk = ingredientStore.takeIngredient(IngredientType.MILK, 50);
        final List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(milk);
        return new HotMilk(BeverageType.HOT_MILK, ingredientList);
    }
}
