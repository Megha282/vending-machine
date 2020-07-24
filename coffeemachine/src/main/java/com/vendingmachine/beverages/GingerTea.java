package com.vendingmachine.beverages;

import java.util.List;

public class GingerTea  extends Tea{

    public GingerTea(final List<Ingredient> ingredientList) {
        super(BeverageType.GINGER_TEA, ingredientList);
    }

}
