package com.vendingmachine.manager;

import com.vendingmachine.beverages.Beverage;
import com.vendingmachine.exceptions.OutOfStockException;

public interface BeverageManager {

    Beverage prepare() throws OutOfStockException;

}
