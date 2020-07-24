package com.vendingmachine.service;

import com.vendingmachine.beverages.Beverage;
import com.vendingmachine.beverages.BeverageType;
import com.vendingmachine.exceptions.OutOfStockException;
import com.vendingmachine.exceptions.OutletUnavailableException;
import com.vendingmachine.manager.BeverageManager;
import com.vendingmachine.manager.BeverageManagerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachineService {

    private AtomicInteger freeOutlets;
    private final BeverageManagerFactory beverageManagerFactory;

    public VendingMachineService(final int outlets, BeverageManagerFactory beverageManagerFactory) {
        this.freeOutlets = new AtomicInteger(outlets);
        this.beverageManagerFactory = beverageManagerFactory;
    }

    public Beverage prepareBeverage(final BeverageType beverageType) throws OutOfStockException, OutletUnavailableException {
        if (freeOutlets.get() == 0) {
            throw new OutletUnavailableException("No outlets is free for " + beverageType.name());
        }

        System.out.println(" Preparing " + beverageType.name());
        freeOutlets.decrementAndGet();
        final BeverageManager beverageManager = beverageManagerFactory.getBeverageManager(beverageType);
        final Beverage beverage = beverageManager.prepare();
        freeOutlets.incrementAndGet();
        System.out.println("finished at" + System.nanoTime()+ "for "+ beverageType.name());
        return beverage;
    }

}
