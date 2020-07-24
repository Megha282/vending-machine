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

public class HotWaterManager implements BeverageManager {
    @Override
    public Beverage prepare() throws OutOfStockException {
        final IngredientStore ingredientStore = IngredientStore.getInstance();
        final Ingredient water = ingredientStore.takeIngredient(IngredientType.WATER, 500);
        final List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(water);
        return new HotMilk(BeverageType.HOT_WATER, ingredientList);
    }
}
