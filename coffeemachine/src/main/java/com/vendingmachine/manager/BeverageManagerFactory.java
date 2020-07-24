package com.vendingmachine.manager;

import com.vendingmachine.beverages.BeverageType;

public class BeverageManagerFactory {

    public BeverageManager getBeverageManager(final BeverageType beverageType) {
        if (beverageType == BeverageType.ELAICHI_TEA) {
            return new CardamomTeaManager();
        } else if (beverageType == BeverageType.HOT_MILK) {
            return new HotMilkManager();
        } else if (beverageType == BeverageType.HOT_WATER) {
            return new HotWaterManager();
        } else if (beverageType == BeverageType.GINGER_TEA) {
            return new GingerTeaManager();
        }  else if (beverageType == BeverageType.COFFEE) {
            return new CoffeeManager();
        } else {
            return new TeaManager();
        }
    }

}
