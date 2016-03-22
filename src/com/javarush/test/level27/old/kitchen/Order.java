package com.javarush.test.level27.old.kitchen;

import com.javarush.test.level27.old.ConsoleHelper;
import com.javarush.test.level27.old.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dmitry on 19.02.2016.
 */
public class Order {
    private List<Dish> dishes;
    private Tablet orderedTablet;

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";


        String chosenDishString = String.format("Your order: %s of %s", dishes, orderedTablet.toString());
        return chosenDishString;
    }
    public Order(Tablet orderedTablet) throws IOException {
        this.orderedTablet = orderedTablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
    public int getTotalCookingTime(){
        int time = 0;
        for(Dish dish: dishes){
            time = time + dish.getDuration();
        }
        return time;
    }
    public boolean isEmpty(){
        if(dishes.isEmpty()){
            return true;
        }
        else return false;
    }
}
