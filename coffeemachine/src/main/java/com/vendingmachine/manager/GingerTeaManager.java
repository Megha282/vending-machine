package com.vendingmachine.manager;

import com.vendingmachine.beverages.Beverage;
import com.vendingmachine.beverages.GingerTea;
import com.vendingmachine.beverages.Ingredient;
import com.vendingmachine.beverages.IngredientStore;
import com.vendingmachine.beverages.IngredientType;
import com.vendingmachine.exceptions.OutOfStockException;

import java.util.ArrayList;
import java.util.List;

public class GingerTeaManager extends TeaManager {
    @Override
    public Beverage prepare() throws OutOfStockException {
        final Beverage beverage = super.prepare();
        final IngredientStore ingredientStore = IngredientStore.getInstance();
        final Ingredient ginger = ingredientStore.takeIngredient(IngredientType.GINGER_SYRUP, 5);
        final List<Ingredient> ingredientList = new ArrayList<>(beverage.getIngredientList());
        ingredientList.add(ginger);
        return new GingerTea(ingredientList);
    }

}
