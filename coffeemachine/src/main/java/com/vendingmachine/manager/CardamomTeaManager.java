package com.vendingmachine.manager;

import com.vendingmachine.beverages.Beverage;
import com.vendingmachine.beverages.CardamomTea;
import com.vendingmachine.beverages.Ingredient;
import com.vendingmachine.beverages.IngredientStore;
import com.vendingmachine.beverages.IngredientType;
import com.vendingmachine.exceptions.OutOfStockException;

import java.util.ArrayList;
import java.util.List;

public class CardamomTeaManager extends TeaManager {
    @Override
    public Beverage prepare() throws OutOfStockException {
        final Beverage beverage = super.prepare();
        final IngredientStore ingredientStore = IngredientStore.getInstance();
        final Ingredient eliachi = ingredientStore.takeIngredient(IngredientType.ELAICHI_SYRUP, 5);
        final List<Ingredient> ingredientList = new ArrayList<>(beverage.getIngredientList());
        ingredientList.add(eliachi);
        return new CardamomTea(ingredientList);
    }
}
